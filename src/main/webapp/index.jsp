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

<style>
        #recordsContainer {
            margin-top: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
</style>

<script type="text/javascript">
	function fetchRecords() {
	    var xhr = new XMLHttpRequest();
	    xhr.open("GET", "fetchRecords", true);
	    xhr.onreadystatechange = function () {
	        if (xhr.readyState == 4 && xhr.status == 200) {
	        	console.log(xhr.responseText);
	            document.getElementById("recordsContainer").insertAdjacentHTML('beforeend', xhr.responseText);
	        }
	    };
	    xhr.send();
	}
	
	window.onload = function() {
	    fetchRecords();
	};
</script>

</head>
<body>
	<div class="demo"></div>
	<header>
		<div class="page-header">
			<h1 class="shop-name">Shop Name</h1>
			<a href="logout.jsp">Logout</a>
		</div>
	</header>
	
	<aside>
		<div class="left-sidebar">
			<ul class="functions-list">
				<li class="function"><a href="dashboard.jsp">DASHBOARD</a></li>
				<li class="function"><a href="add-entry.jsp">ADD ENTRY</a></li>
				<li class="function"><a href="update-entry.jsp">UPDATE ENTRY</a></li>
				<li class="function"><a href="delete-entry.jsp">DELETE ENTRY</a></li>
				<li class="function"><a href="activity-log.jsp">ACTIVITY LOG</a></li>
			</ul>
		</div>
	</aside>
	
	<section class="main" id="recordsContainer"></section>
	
	<a href="logout">Logout</a>
</body>
</html>