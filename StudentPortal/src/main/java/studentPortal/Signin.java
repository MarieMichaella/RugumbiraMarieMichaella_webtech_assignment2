package studentPortal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/signin")
public class Signin extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            PrintWriter out = res.getWriter();
            HttpSession session = req.getSession(); // Get or create a session

            if (email != null && password != null) {
                if (email.equalsIgnoreCase("michaellamarie@gmail.com") && password.equalsIgnoreCase("Michaella")) {
                    // Store user information in the session
                    session.setAttribute("userEmail", email);
                    out.println("Welcome, " + email);
                    res.sendRedirect("welcome.html"); // Redirect to a welcome page

                } else {
                    out.println("Invalid email or password");
                    res.sendRedirect("forgotpassword.html");
                }
            } else {
                out.println("Please provide both email and password.");
            }

         // Check if a session has been created
            if (session.isNew()) {
                out.println("A new session has been created with ID: " + session.getId());
            } else {
                out.println("Session ID: " + session.getId());
                out.println("Welcome back!");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
