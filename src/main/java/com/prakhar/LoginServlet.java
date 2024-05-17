package com.prakhar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String phone_no = request.getParameter("phone_no");
		String password = request.getParameter("password");
		
		// create dispatcher object
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		// create connection
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/interest_tracker?useSSL=false", "root", "bOLt$4$2002@");
			
			// check if the admin has already registered
			PreparedStatement checkLoginPst = conn.prepareStatement("SELECT * FROM admin WHERE phone_no=? AND password=?");
			
			checkLoginPst.setString(1, phone_no);
			checkLoginPst.setString(2, password);
			
	        ResultSet rsCheck = checkLoginPst.executeQuery();

	        
	        if (rsCheck.next()) {
	            // User already exists, redirect to login.jsp
	        	session.setAttribute("phone_no", rsCheck.getString("phone_no"));
	        	
	        	// Middleware
//	        	response.sendRedirect("fetchRecords");
	        	
	        	dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("status", "loginError");
	        	dispatcher = request.getRequestDispatcher("login.jsp");
			}
	        
	        dispatcher.forward(request, response);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
