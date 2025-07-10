package com.hospital;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AppointmentServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/hospital_db";
    private static final String DB_USER = "root"; // replace with your MySQL username
    private static final String DB_PASS = "password"; // replace with your MySQL password

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String date = request.getParameter("date");
        String department = request.getParameter("department");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            String sql = "INSERT INTO appointments (name, email, appointment_date, department) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDate(3, Date.valueOf(date));
            stmt.setString(4, department);

            int rowsInserted = stmt.executeUpdate();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            if (rowsInserted > 0) {
                out.println("<h2>Appointment Booked Successfully!</h2>");
            } else {
                out.println("<h2>Failed to book appointment.</h2>");
            }

            conn.close();
        } catch (Exception e) {
            throw new ServletException("DB Error: " + e.getMessage());
        }
    }
}