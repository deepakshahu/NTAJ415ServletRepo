<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>A JSP page</title>
</head>
<body>
	<b>From a.jsp</b>
	<%
	//Create all 4 scopes of attributes
	//Page scope
	pageContext.setAttribute("attr1", "val1");
	//Request scope
	pageContext.setAttribute("attr2", "val2", pageContext.REQUEST_SCOPE);
	//Session scope
	pageContext.setAttribute("attr3", "val3", pageContext.SESSION_SCOPE);
	//Application scope
	pageContext.setAttribute("attr4", "val4", pageContext.APPLICATION_SCOPE);
	%>
	<jsp:forward page="b.jsp" />
</body>
</html>