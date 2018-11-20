package victor.ppool.site.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MineHubConnector {
	
	public static class Coin {
		private String name;
		private double price;
		
		public Coin(String name, double price) {
			this.name = name;
			this.price = price;
		}
		
		@Override
		public String toString() {
			return String.format(name +":" + price);
		}
		
		public String getName() {
			return name;
		}
		
		public double getPrice() {
			return price;
		}
	}
	
	private static String getStringByURL(URL jsonURL) throws IOException {
		HttpURLConnection conn;
		String jsonText = null;
		InputStream httpIn = null;
		
		try {
			conn = (HttpURLConnection) jsonURL.openConnection();
			
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-Type", 
	                   "application/x-www-form-urlencoded");
	        conn.setRequestProperty("Content-Language", "en-US"); 
	        conn.setRequestProperty("User-Agent",
	                "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11");
	        conn.setUseCaches(false);
	        conn.setDoInput(true);
	        conn.setDoOutput(true);
			
			httpIn = new BufferedInputStream(conn.getInputStream());     
			jsonText = IOUtils.toString(httpIn);
		} finally {
			IOUtils.closeQuietly(httpIn);
		}
		
		return jsonText;
	}
	
	public static List<Coin> getBPCReducedPrices(double reductionPercent, Set<String> limit) throws IOException, ParseException {
		List<Coin> result = new ArrayList<>();
		
		String currData = getStringByURL(new URL("http://proxypool.info:8018/minehub?equihash=1000000&lbry=1000000&Lyra2REv2=121000000000000&key=123123123"));
		JSONObject topJson = (JSONObject)new JSONParser().parse(currData);
		for(Object node : topJson.entrySet()) {
			Map.Entry entry = (Map.Entry)node;
			String name = entry.getKey().toString();
			if (limit != null && !limit.contains(name)) {
				continue;
			}
			JSONArray vals = (JSONArray)entry.getValue();
			Double btcPrice = Double.valueOf(vals.get(1).toString()) * (1 - reductionPercent/100);
			result.add(new Coin(name, btcPrice));
		}
		
		Collections.sort(result, (a,b)->{
			return Double.valueOf(b.getPrice()).compareTo(Double.valueOf(a.getPrice()));
		});
		return result;
	}

}
