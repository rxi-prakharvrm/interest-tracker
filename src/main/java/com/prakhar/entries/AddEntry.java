package com.prakhar.entries;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEntry
 */
@WebServlet("/add-entry")
public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// Retrieve parameters from the request
	    String name = request.getParameter("name");
	    String phoneNo = request.getParameter("phone_no");
	    String address = request.getParameter("address");
	    String itemName = request.getParameter("item-name");
	    
	    // Convert parameters to appropriate data types
	    int totalCost = Integer.parseInt(request.getParameter("total-cost"));
	    int paidAmount = Integer.parseInt(request.getParameter("paid-amount"));
	    int remainingAmount = totalCost - paidAmount;
	    int interestRate = Integer.parseInt(request.getParameter("interest-rate"));
	    String interestType = request.getParameter("interest-type");
	    int timeDuration = Integer.parseInt(request.getParameter("time-duration"));
	    int toBePaid = remainingAmount + (remainingAmount * interestRate * timeDuration) / 100;

	    // create dispatcher object
	    RequestDispatcher dispatcher = null;
	    
	    // create connection
	    Connection conn = null;
	    
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/interest_tracker?useSSL=false", "root", "bOLt$4$2002@");
	        
	        PreparedStatement pst = conn.prepareStatement("INSERT INTO entry (dateOfPurchase, name, phoneNo, address, itemName, totalCost, paidAmount, remainingAmount, interestRate, interestType, timeDuration, toBePaid) VALUES(?,?,?,?,?,?,?,?,?,?,?,?);");
	        
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        Timestamp dateOfPurchase = Timestamp.valueOf(currentDateTime);
	        pst.setTimestamp(1, dateOfPurchase);
	        pst.setString(2, name);
	        pst.setString(3, phoneNo);
	        pst.setString(4, address);
	        pst.setString(5, itemName);
	        pst.setInt(6, totalCost);
	        pst.setInt(7, paidAmount);
	        pst.setInt(8, remainingAmount);
	        pst.setInt(9, interestRate);
	        pst.setString(10, interestType);
	        pst.setInt(11, timeDuration);
	        pst.setInt(12, toBePaid);
	        
	        int rowsAffected = pst.executeUpdate();
	        
	        // Check if the insertion was successful
	        if (rowsAffected > 0) {
	            // Set attributes to be sent to entry.jsp
	            request.setAttribute("dateOfPurchase", dateOfPurchase);
	            request.setAttribute("name", name);
	            request.setAttribute("phoneNo", phoneNo);
	            request.setAttribute("address", address);
	            request.setAttribute("itemName", itemName);
	            request.setAttribute("totalCost", totalCost);
	            request.setAttribute("paidAmount", paidAmount);
	            request.setAttribute("remainingAmount", remainingAmount);
	            request.setAttribute("interestRate", interestRate);
	            request.setAttribute("interestType", interestType);
	            request.setAttribute("timeDuration", timeDuration);
	            request.setAttribute("toBePaid", toBePaid);
	            
	            // Forward the request to entry.jsp
	            dispatcher = request.getRequestDispatcher("index.jsp");
	            dispatcher.forward(request, response);
	        } else {
	            // Handle the case when insertion fails
	            // This could include displaying an error message or redirecting to an error page
	        }
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close database connection
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
		
	}

}
