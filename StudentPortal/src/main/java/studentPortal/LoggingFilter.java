package studentPortal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LoggingFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        System.out.println("Request received at " + System.currentTimeMillis());
        
        
        chain.doFilter(request, response);
        
        
        System.out.println("Response sent at " + System.currentTimeMillis());
    }

    public void destroy() {
        
    }
}
