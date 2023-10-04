package com.auca.studentPortal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet("\login")
public class LoggingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	    	
	    	   PrintWriter out=response.getWriter();  
	    	    out.print("Filter is invoked before");  
	      
	        out.print("");  
	        
	        System.out.println("Request received at " + System.currentTimeMillis());
	        
	        
	        chain.doFilter(request, response);
	        
	        
	        System.out.println("Response sent at " + System.currentTimeMillis());
	    }

		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
