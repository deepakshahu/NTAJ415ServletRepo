<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A JSP Page</title>
</head>
<body>
	<b>Start of a.jsp</b>
	<br>
	<br>
	<jsp:include page="b.jsp" flush="true"/>
	<br>
	<b>End of a.jsp</b>
	<br>
</body>
</html>