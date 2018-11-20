package victor.ppool.site.servlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static victor.ppool.site.util.MineHubConnector.*;

@WebServlet("/minedata")
public class MinePricesServlet extends HttpServlet {
	
	
	public static void main(String[] args) throws IOException, ParseException {
		System.out.println(getBPCReducedPrices(4.5, new HashSet<>(Arrays.asList(new String[] {"HUSH", "ZCL", "ZEN"}))));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!"123123123".equals(req.getParameter("key"))) {
			return;
		}
		String reductionPercentStr = req.getParameter("reductionPercent");
		double reductionPercenr = reductionPercentStr == null ? 0 : Double.valueOf(reductionPercentStr);
		
		String lowBeepStr = req.getParameter("lowBeep");
		double lowBeep = 0;
		if (lowBeepStr != null) {
			lowBeep = Double.valueOf(lowBeepStr);
			req.setAttribute("lowBeepVal", lowBeepStr);
		}
		
		String highBeepStr = req.getParameter("highBeep");
		double highBeep = 0;
		if (highBeepStr != null) {
			highBeep = Double.valueOf(highBeepStr);
			req.setAttribute("highBeepVal", highBeepStr);
		}
		
		String expectedProfitStr = req.getParameter("expectedProfit");
		double expectedProfit = 0;
		if (expectedProfitStr != null) {
			expectedProfit = Double.valueOf(expectedProfitStr);
			req.setAttribute("expectedProfitVal", expectedProfitStr);
		}
		
		String limitStr = req.getParameter("limitTo");
		Set<String> limit = limitStr == null ? null : new HashSet<>(Arrays.asList(limitStr.split(",")));
		List<Coin> coins = null; 
		try {
			coins = getBPCReducedPrices(reductionPercenr, limit);
		} catch (ParseException e) {			
			e.printStackTrace();
			return;
		}
		if (highBeepStr != null && coins.get(0).getPrice() >= highBeep) {
			req.setAttribute("highBeep", "true");
		}
		if (lowBeepStr != null && coins.get(0).getPrice() <= lowBeep) {
			req.setAttribute("lowBeep", "true");
		}
		
		req.setAttribute("percent", reductionPercentStr);
		req.setAttribute("coins", coins);
        req.getRequestDispatcher("/data.jsp").forward(req, resp);
	}
	
	
	

}
