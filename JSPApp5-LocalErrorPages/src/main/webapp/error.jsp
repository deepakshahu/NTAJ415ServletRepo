<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error JSP Page</title>
</head>
<body>
<h1 style="color:red;text-align:center">Internal Problem - Try again !!</h1>
<br>Problem is :: <%=exception.toString() %>
</body>
</html>