package victor.ppool.site.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

// @WebFilter(urlPatterns = {"*"})
public class AuthFilter extends HttpFilter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        if (req.getSession().getAttribute("user") == null 
        		&& !(req.getRequestURI().startsWith("/css/"))
        		&& !(req.getRequestURI().startsWith("/ttf/"))
        		&& !(req.getRequestURI().startsWith("/sounds/"))
        		&& !(req.getRequestURI().startsWith("/img/"))
        		&& !(req.getRequestURI().startsWith("/login.jsp"))
        		&& !(req.getRequestURI().startsWith("/data.jsp"))) {
 
        	
            req.getSession().setAttribute("from", req.getRequestURI());
            res.sendRedirect("/login.jsp");
        } else {
            chain.doFilter(request, response);
        }

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
