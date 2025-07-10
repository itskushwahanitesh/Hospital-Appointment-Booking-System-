package com.hospital;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AppointmentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String department = request.getParameter("department");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Appointment Confirmed</h2>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Date: " + date + "</p>");
        out.println("<p>Department: " + department + "</p>");
    }
}