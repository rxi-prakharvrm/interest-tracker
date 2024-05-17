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
<title>Home Page</title>
</head>
<body>
	<a href="add-entry.jsp">ADD ENTRY</a>
	<section class="main">
		<jsp:include page="entry.jsp" />		
	</section>
	<a href="logout">Logout</a>
</body>
</html>