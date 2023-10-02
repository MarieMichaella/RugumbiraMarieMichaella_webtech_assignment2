package studentPortal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;


public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
    	   PrintWriter out=response.getWriter();  
    	    out.print("filter is invoked before");  
      
        out.print("<br>welcome to servlet<br>");  
        
        System.out.println("Request received at " + System.currentTimeMillis());
        
        
        chain.doFilter(request, response);
        
        
        System.out.println("Response sent at " + System.currentTimeMillis());
    }

    public void destroy() {
        
    }
}
