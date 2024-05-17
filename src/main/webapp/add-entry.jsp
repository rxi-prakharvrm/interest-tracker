<%
	if(session.getAttribute("phone_no")==null) {
		response.sendRedirect("login.jsp");
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="add-entry">
		<div class="form-group">
			<label for="name">Name</label>
			<input type="text" id="name" name="name" placeholder="Enter customer's name...">
		</div>
		<div class="form-group">
			<label for="phone_no">Phone Number</label>
			<input type="text" id="phone_no" name="phone_no" placeholder="Enter your phone number...">
		</div>
		<div class="form-group">
			<label for="address">Address</label>
			<input type="text" id="address" name="address" placeholder="Enter customer's address...">
		</div>
		<div class="form-group">
			<label for="item-name">Item Name</label>
			<input type="text" id="item-name" name="item-name" placeholder="Enter item name...">
		</div>
		<div class="form-group">
			<label for="total-cost">Total Cost</label>
			<input type="number" id="total-cost" name="total-cost" placeholder="Enter total cost...">
		</div>
		<div class="form-group">
			<label for="paid-amount">Paid Amount</label>
			<input type="number" id="paid-amount" name="paid-amount" placeholder="Enter amount paid...">
		</div>
		<div class="form-group">
			<label for="interest-rate">Interest Rate</label>
			<input type="number" id="interest-rate" name="interest-rate" placeholder="Enter the interest rate...">
		</div>
		<div class="form-group">
			<label for="interest-type">Interest Type</label>
			<select name="interest-type" id="interest-type">
				<option value="simple">Simple</option>
				<option value="compound">Compound</option>
			</select>
		</div>
		<div class="form-group">
			<label for="time-duration">Time Duration</label>
			<input type="number" id="time-duration" name="time-duration" placeholder="Enter time duration...">
		</div>
		<div class="form-group">
			<input type="submit" id="submit" name="submit" value="Submit">
		</div>
	</form>
</body>
</html>