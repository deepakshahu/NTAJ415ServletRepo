<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main JSP</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Main1 JSP Page</h1>
	<%
	java.util.Date d = null;
	int year = d.getYear();
	%>
	<br>Year ::
	<%=year%>
</body>
</html>