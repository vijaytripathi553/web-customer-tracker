<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/MyCss/CSS/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		<!--  Adding Button -->
		
		
		<input type="button" value="Add Customer" 
		onclick="window.location.href='showFormForAdd'; return false"
		class="add-button"  />
		
		
		
		
			<!--  add our html table here -->
		
			<table>
				<tr>
				    <th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				
				
				<c:forEach var="tempCustomer" items="${customers}">
				
				
				
				<!--  Updation part starts from here-->
				<!-- Construct the "update" link through customer id -->
				<c:url var="updateLink" value="/showFormForUpdate">
			 	     <c:param name="cusid" value="${tempCustomer.id}" />
					</c:url>
					<!-- Updation link ends here..... -->
					
					
					
					
					
					
					<!--  Deletion part starts from here-->
				<!-- Construct the "update" link through customer id -->
				<c:url var="deleteLink" value="/showFormForDelete">
			 	     <c:param name="cusid" value="${tempCustomer.id}" />
					</c:url>
					<!-- deletion link ends here..... -->
					
				
					<tr>
					    <td> ${tempCustomer.id} </td>
						<td> ${tempCustomer.firstName} </td>
						<td> ${tempCustomer.lastName} </td>
						<td> ${tempCustomer.email} </td>
						<td>
						
						<!--  Creating an Update link -->
						<a href="${updateLink}">Update</a>
						
						<!--  Creating a Delete link  -->
						<a href="${deleteLink}"
						onclick=" if(!(confirm('Do you really want to delete the record? '))) return false">Delete</a>
		
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









