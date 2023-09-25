package studentPortal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Signin extends HttpServlet {
	 String email, password;
	 
	 public void service(HttpServletRequest req, HttpServletResponse res) {
			email = req.getParameter("email");
			
			password = req.getParameter("password");
			
		
			
			try {
				
				PrintWriter out = res.getWriter();
				
				if(email != null && password != null ) {
					
					if(email.equalsIgnoreCase("michaellamarie@gmail.com") && password.equalsIgnoreCase("Michaella")) {
						out.println("Your Email is "+email+ "and Your Password is" + password );
						res.sendRedirect("welcome.html");

					}else {
						out.println("Invalid email");
						 res.sendRedirect("forgotpassword.html");
					}
				}
				
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
	 }

}
