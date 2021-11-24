<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Implicit Object Test</title>
</head>
<body>
	<h1 style="color: red; text-align: center">JSP Implicit Objects</h1>
	<br> Out object class name ::
	<%=out.getClass()%>
	<br> Request object class name ::
	<%=request.getClass()%>
	<br> Response object class name ::
	<%=response.getClass()%>
	<br> Config object class name ::
	<%=config.getClass()%>
	<br> Application object class name ::
	<%=application.getClass()%>
	<br> Session object class name ::
	<%=session.getClass()%>
	<br> Page object class name ::
	<%=page.getClass()%>
	<br> PageContext object class name ::
	<%=pageContext.getClass()%>
	<br>

	<%!public void jspInit() {
		//System.out.println("Application object class name : "+application.getClass());
		//System.out.println("Config object class name : "+config.getClass());
		ServletContext sc = getServletContext();
		ServletConfig cg = getServletConfig();
		System.out.println("Application object class name : " + sc.getClass() + " " + sc.hashCode());
		System.out.println("Config object class name : " + cg.getClass() + " " + cg.hashCode());
	}%>
	<b>Driver Loaded</b> <br>
	Application object class name : <%=application.getClass() %> <%=application.hashCode() %> <br>
	Config object class name : <%=config.getClass() %> <%=config.hashCode() %>
</body>
</html>