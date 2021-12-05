<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search JSP Page</title>
</head>
<body>
	<%
	//Read request param values
	String ss = request.getParameter("ss");

	//Perform SendRedirection
	response.sendRedirect("https://www.google.com/search?q=" + ss);
	%>
</body>
</html>