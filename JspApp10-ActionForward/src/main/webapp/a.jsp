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
	<%
	float price = 500 + 500 * 0.1f;
	%>
	<jsp:forward page="b.jsp">
		<jsp:param name="bookName" value="CRJ" />
		<jsp:param name="cost" value="<%=price %>" />
	</jsp:forward>
	<br>
	<b>End of a.jsp</b>
	<br>
</body>
</html>