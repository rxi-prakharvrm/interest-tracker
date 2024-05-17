<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status")%>">

	<form method="post" action="login">
		<div class="form-group">
			<label for="phone_no">Phone Number</label>
			<input type="text" id="phone_no" name="phone_no" placeholder="Enter your phone number...">
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" id="password" name="password" placeholder="Enter your password...">
		</div>
		<div class="form-group">
			<input type="submit" id="submit" name="submit" value="Submit">
		</div>
	</form>
	<a href="signup.jsp">Signup</a>
	
	<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function() {
        var status = document.getElementById("status").value;
        if (status === "success") {
            swal("Congrats", "Logged in successfully!", "success");
        } else if (status === "loginError") {
            swal("Sorry", "Wrong credentials!", "error");
        }
    });
	</script>
</body>
</html>