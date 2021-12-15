<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Data</title>
</head>
<body>
	attr1(page scope) value :: ${pageScope.attr1}
	<br> attr2(request scope) value :: ${requestScope.attr2}
	<br> attr3(session scope) value :: ${sessionScope.attr3}
	<br> attr4(application scope) value :: ${applicationScope.attr4}
	<br>
</body>
</html>