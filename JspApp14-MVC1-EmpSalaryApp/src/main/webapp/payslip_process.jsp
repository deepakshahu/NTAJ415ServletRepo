<%@ page import="com.nit.beans.*, com.nit.service.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PaySlip Process</title>
</head>
<body>
	<!-- Create/Locate Java bean class object -->
	<jsp:useBean id="emp" class="com.nit.beans.Employee" scope="request" />

	<!-- Write form data to have Java Bean class object -->
	<jsp:setProperty name="emp" property="*" />

	<!-- Create/Locate service class object -->
	<jsp:useBean id="service"
		class="com.nit.service.PaySlipGeneratorService" scope="application" />

	<!-- Invoke the business method -->
	<%
	service.generatePaySlip(emp);
	%>

	<!-- Read the inputs and results from Java bean class object and display on the browser -->
	<h1 style="color: red; text-align: center">Employee PaySlip Report</h1>
	<table border="1" bgcolor="cyan" align="center">
		<tr>
			<td>Employee Name:</td>
			<td><jsp:getProperty property="ename" name="emp" />
		</tr>
		<tr>
			<td>Employee Address:</td>
			<td><jsp:getProperty property="eadd" name="emp" />
		</tr>
		<tr>
			<td>Employee Basic Salary:</td>
			<td><jsp:getProperty property="basicSalary" name="emp" />
		</tr>
		<tr>
			<td>Employee Gross Salary:</td>
			<td><jsp:getProperty property="grossSalary" name="emp" />
		</tr>
		<tr>
			<td>Employee Net Salary:</td>
			<td><jsp:getProperty property="netSalary" name="emp" />
		</tr>
	</table>

	<br>
	<br>
	<h1 style="text-align: center">
		<a href="employee_details.html">Home</a>
	</h1>
</body>
</html>