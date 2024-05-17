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
				<li class="function"><a href="add-entry">ADD ENTRY</a></li>
				<li class="function"><a href="update-entry">UPDATE ENTRY</a></li>
				<li class="function"><a href="delete-entry">DELETE ENTRY</a></li>
				<li class="function"><a href="activity-log">ACTIVITY LOG</a></li>
			</ul>
		</div>
	</aside>
	
	<section class="main-section">
		<div class="customer-entries">
			<div class="customer-entry">
				<table>
					<thead>
						<tr>
							<th colspan="4"><%= name %> <%= phone_no %></th>
							<th colspan="3"><%= address %></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Item Name</td>
							<td>Total Cost</td>
							<td>Paid Amount</td>
							<td>Remaining Amount</td>
							<td>At Interest</td>
							<td>Time</td>
							<td>Interest Type</td>
						</tr>
						<tr>
							<td><%= itemName %></td>
							<td><%= totalCost %></td>
							<td><%= paidAmount %></td>
							<td><%= remainingAmount %></td>
							<td><%= atInterest %></td>
							<td><%= time %></td>
							<td><%= interestType %></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</body>
</html>