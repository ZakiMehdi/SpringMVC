<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    	<div align="center">
	        <h1>Employee List</h1>
	        <h3><a href="newEmployee">Add New Employee</a></h3>
	        <table border="1">
	        	<th>ID</th>
	        	<th>NAME</th>
	        	<th>EMAIL</th>
	        	<th>DOB</th>
	        	<th>PHONE NUMBER</th>
	        	<th>BLOOD GROUP</th>
	        	<th>Action</th>
				<c:forEach var="employee" items="${employeeList}" varStatus="status">
	        	<tr>
	        		<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td>${employee.email}</td>
					<td>${employee.dateOfBirth}</td>
					<td>${employee.phoneNumber}</td>
					<td>${employee.bloodGroup}</td>
					
					<td>
						<a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="deleteEmployee?id=${employee.id}">Delete</a>
					</td>
							
	        	</tr>
				</c:forEach>	        	
			</table>
    	</div>
    </body>
</html>
