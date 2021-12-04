<%@ page language="java" info="This is test page"
	import="java.util.*, java.net.*" contentType="text/html"
	pageEncoding="UTF-8" session="false" buffer="0kb" autoFlush="true" isELIgnored="false" isThreadSafe="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
	<b>Hello</b>
	<br>
	<b>नमस्ते</b><br>
	result : ${4+5}<br>
	<%
	for(int i = 1; i <= 10; i++) {
		out.print("raja"+i+"<br>");
	}
	%>


	<%-- <% response.setContentType("text/plain"); --%>
</body>
</html>