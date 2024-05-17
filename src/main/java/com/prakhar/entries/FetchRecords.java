package com.prakhar.entries;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fetchRecords")
public class FetchRecords extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");

        // Get PrintWriter object to write HTML response
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/interest_tracker?useSSL=false", "root", "bOLt$4$2002@");
            
            // Prepare SQL query to fetch all records
            String sql = "SELECT * FROM entry";
            stmt = conn.prepareStatement(sql);

            // Execute the query
            rs = stmt.executeQuery();

            // Open the table
            out.println("<table border='1'>");

            // Print the table header
            out.println("<tr>");
            out.println("<th>Name</th>");
            out.println("<th>Phone Number</th>");
            out.println("<th>Address</th>");
            out.println("<th>Item Name</th>");
            out.println("<th>Total Cost</th>");
            out.println("<th>Paid Amount</th>");
            out.println("<th>Remaining Amount</th>");
            out.println("<th>Interest Rate</th>");
            out.println("<th>Interest Type</th>");
            out.println("<th>Time Duration</th>");
            out.println("<th>To Be Paid</th>");
            out.println("</tr>");

            // Iterate through the result set and print each record as a table row
            while (rs.next()) {
                out.println("<tr>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("phoneNo") + "</td>");
                out.println("<td>" + rs.getString("address") + "</td>");
                out.println("<td>" + rs.getString("itemName") + "</td>");
                out.println("<td>" + rs.getInt("totalCost") + "</td>");
                out.println("<td>" + rs.getInt("paidAmount") + "</td>");
                out.println("<td>" + rs.getInt("remainingAmount") + "</td>");
                out.println("<td>" + rs.getInt("interestRate") + "</td>");
                out.println("<td>" + rs.getString("interestType") + "</td>");
                out.println("<td>" + rs.getInt("timeDuration") + "</td>");
                out.println("<td>" + rs.getInt("toBePaid") + "</td>");
                out.println("</tr>");
            }

            // Close the table
            out.println("</table>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
