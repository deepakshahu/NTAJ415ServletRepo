<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>B JSP Page</title>
</head>
<body>
	<b>Start of b.jsp</b>
	<br>
	<br>
	<%=new java.util.Date()%><br>
	<br>
	<b>The request param values <%=request.getParameter("bookName")%>,
		<%=request.getParameter("cost")%>
	</b>
	<br><br>
	<b>End of b.jsp</b>
</body>
</html>