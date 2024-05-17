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

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone_no = request.getParameter("phone_no");
		String shop_name = request.getParameter("shop_name");
		
		// create dispatcher object
		RequestDispatcher dispatcher = null;
		
		// create connection
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/interest_tracker?useSSL=false", "root", "bOLt$4$2002@");
			
			// check if the admin has already registered
			PreparedStatement checkSignupPst = conn.prepareStatement("SELECT * FROM admin WHERE phone_no=?");
			
			checkSignupPst.setString(1, phone_no);
	        ResultSet rsCheck = checkSignupPst.executeQuery();

	        if (rsCheck.next()) {
	            // User already exists, redirect to login.jsp
	        	request.setAttribute("status", "alreadyRegisteredError");
	        	request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
			
			
			PreparedStatement signupPst = conn.prepareStatement("INSERT INTO admin VALUES(?,?,?,?,?)");
			
			signupPst.setString(1, phone_no);
			signupPst.setString(2, name);
			signupPst.setString(3, email);
			signupPst.setString(4, password);
			signupPst.setString(5, shop_name);
			
			int rowCount = signupPst.executeUpdate();
			dispatcher = request.getRequestDispatcher("signup.jsp");
			
			if(rowCount > 0) {
				request.setAttribute("status", "success");
			} else {
				request.setAttribute("status", "signupError");
			}
			
			dispatcher.forward(request, response);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
