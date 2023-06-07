<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>


<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<title>Employee List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body style="background: pink">



	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: 	green">
			<div>
				<a href="http://www.fullstackjavadeveloper.in" class="navbar-brand"> User
					Employee Mgnt App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employee</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="signup.jsp" class="btn btn-success">Add
					New Employee Data</a>
			</div>
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="filterbysalary">
			<input type="text" name="empsalary">
			<input type="submit" value="Filter by Salary"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbyid">
			<input type="text" name="empid">
			<input type="submit" value="Search By Id"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="searchbyname">
			<input type="text" name="empname">
			<input type="submit" value="Search By Name"> 
			</form>
			
			<form action="EmployeeController" method="get">
			<input type="hidden" name="action" value="filterbyemail">
			<input type="text" name="empemailid">
			<input type="submit" value="Search By Email"> 
			</form>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><a href="EmployeeController?action=sortbyid">Id</a></th>
						<th><a href="EmployeeController?action=sortbyname">Name</a></th>
						<th>Address</th>
						<th>Contact Number</a></th>
						
						<th> <a href="EmployeeController?action=sortbysalary">Salary</a></th>
						
						<th>Gender</th>
						<th> <a href="EmployeeController?action=sortbyage">Age</a></th>
						<th><a href="EmployeeController?action=sortbydob">DOB</a></th>
						
						<th>Email</th>
						<th>Password</th>
						
						
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="employee" items="${empList}">

						<tr>
							<td><c:out value="${employee.empId}" /></td>
							<td><c:out value="${employee.empName}" /></td>
							<td><c:out value="${employee.empAddress}" /></td>
							<td><c:out value="${employee.empContactNumber}" /></td>
							
							<td><c:out value="${employee.empSalary}"/></td>
							<td><c:out value="${employee.empAge}" /></td>
							<td><c:out value="${employee.empGender}"/></td>
							<td><fmt:formatDate value = "${employee.empDOB}"  type = "date"  pattern = "dd-MM-yyyy" /></td>
							
							
							<td><c:out value="${employee.empEmailId}" /></td>
							<td><c:out value="${employee.empPassword}" /></td>
							<td><a href="EmployeeController?action=edit_form&empid=<c:out value='${employee.empId}' />">Update</a>
								 <a
								href="EmployeeController?action=deletedatabyid&empid=<c:out value='${employee.empId}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
			
			
			
			<a href="EmployeeController?action=deletealldata">Delete All Employee Data</a>
		</div>
	</div>
</body>
</html>
