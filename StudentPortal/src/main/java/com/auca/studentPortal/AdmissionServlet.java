package com.auca.studentPortal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.auca.email.SendEmail;

//@WebServlet("/admissionServlet")
public class AdmissionServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the session associated with the current user
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String sender = "mariemichaellarug1@gmail.com";

        // Check if the email is provided and not empty
        if (email != null && !email.isEmpty()) {
            SendEmail sendEmail = new SendEmail(sender, "ppbdqkcuthdfqzst");
            String recipient = email;
            String subject = "CONFIRMATION Email";
            String message = "Hello, your form was successfully submitted.";

            try {
                sendEmail.sendEmail(recipient, subject, message);
                System.out.println("Email sent successfully");

              
                session.setAttribute("userEmail", email);

              //session.getId()
                response.setContentType("text/html");

                
                PrintWriter out = response.getWriter();

                
                String userEmail = (String) session.getAttribute("userEmail");
                if (userEmail != null) {
                    out.println("<html><body>");
                    out.println("<h3>Session is working. User email: " + userEmail + "</h3>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><body>");
                    out.println("<h1>Session is not working. User email is not found in the session.</h1>");
                    out.println("</body></html>");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error sending email");
            }
        } else {
            // Handle the case where the email address is missing or empty
            System.err.println("Invalid or missing email address");
        }
    }
}
