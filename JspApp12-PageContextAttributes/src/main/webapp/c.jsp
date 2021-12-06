<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>C JSP Page</title>
</head>
<body>
	<b>From c.jsp</b>
	<!-- Read and display pageContext attribute value -->
	<b>attr1(page scope) value :: <%=pageContext.findAttribute("attr1")%></b>
	<br>
	<b>attr2(request scope) value :: <%=pageContext.findAttribute("attr2")%></b>
	<br>
	<b>attr3(session scope) value :: <%=pageContext.findAttribute("attr3")%></b>
	<br>
	<b>attr4(application scope) value :: <%=pageContext.findAttribute("attr4")%></b>
	<br>
</body>
</html>