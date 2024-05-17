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
<title>Entry</title>
</head>
<body>
	
	<div class="customer-entry">
		<table>
			<thead>
				<tr>
					<th colspan="4"><%= request.getAttribute("name") %> <%= request.getAttribute("phone_no") %></th>
					<th colspan="4"><%= request.getAttribute("address") %></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Date of Purchase</td>
					<td>Item Name</td>
					<td>Total Cost</td>
					<td>Paid Amount</td>
					<td>Remaining Amount</td>
					<td>At Interest</td>
					<td>Time</td>
					<td>Interest Type</td>
					<td>To Be Paid</td>
				</tr>
				<tr>
					<td><%= request.getAttribute("dateOfPurchase") %></td>
					<td><%= request.getAttribute("itemName") %></td>
					<td><%= request.getAttribute("totalCost") %></td>
					<td><%= request.getAttribute("paidAmount") %></td>
					<td><%= request.getAttribute("remainingAmount") %></td>
					<td><%= request.getAttribute("interestRate") %></td>
					<td><%= request.getAttribute("interestType") %></td>
					<td><%= request.getAttribute("timeDuration") %></td>
					<td><%= request.getAttribute("toBePaid") %></td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>