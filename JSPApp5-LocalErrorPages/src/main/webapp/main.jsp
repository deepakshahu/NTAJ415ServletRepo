<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main JSP</title>
</head>
<body>
	<h1 style="color: red; text-align: center">Main JSP Page</h1>
	<%
	int a = Integer.parseInt("10");
	%>
	<br>value ::
	<%=a%>
</body>
</html>