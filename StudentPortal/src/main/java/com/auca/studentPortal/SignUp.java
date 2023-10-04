package com.auca.studentPortal;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signup")
public class SignUp extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            PrintWriter out = res.getWriter();
            HttpSession session = req.getSession();

            if (email != null && password != null) {
                // Perform the signup process here
                // ...

                // After successful signup, set session messages
                String successMessage = "Sign up successful!";
                session.setAttribute("sessionMessages", successMessage);
                res.sendRedirect("Register.html");
            } else {
                out.println("Please provide both email and password.");
            }

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
