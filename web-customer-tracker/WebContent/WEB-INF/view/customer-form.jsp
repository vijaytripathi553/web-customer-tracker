<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Save Customer</title>
	<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath }/MyCss/CSS/style.css">
			
			<link 	type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath }/MyCss/CSS/add-customer-style.css">

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		</div>
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
		
			<!-- need to associate this data with customer id -->
			<form:hidden path="id"></form:hidden>			
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName"></form:input></td>
					</tr>
					
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"></form:input></td>
					</tr>
					
					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"></form:input></td>
					</tr>	
					
					
						
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>																			
				</tbody>
			</table>
			
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath }/list">Back to List</a>
		</p>

</body>
</html>