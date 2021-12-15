<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Data</title>
</head>
<body>
	<%
	pageContext.setAttribute("attr1", "val1");
	pageContext.setAttribute("attr2", "val2", PageContext.REQUEST_SCOPE);
	pageContext.setAttribute("attr3", "val3", PageContext.SESSION_SCOPE);
	pageContext.setAttribute("attr4", "val4", PageContext.APPLICATION_SCOPE);
	%>
	<jsp:forward page="read_data.jsp" />
</body>
</html>