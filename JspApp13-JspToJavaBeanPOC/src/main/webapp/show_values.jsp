<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.nit.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Values</title>
</head>
<body>
	<!-- Locate/Create Java Bean class object -->
	<jsp:useBean id="st" class="com.nit.beans.StudentInfo" scope="session" />

	<!-- Read and display values -->
	<b>sno =</b><jsp:getProperty name="st" property="sno" /><br>
	<b>sname =</b><jsp:getProperty name="st" property="sname" /><br>
	<b>sadd =</b><jsp:getProperty name="st" property="sadd" /><br>
	<b>avg =</b><jsp:getProperty name="st" property="avg" /><br>

	<b>Values are read from java bean class object and displayed</b>
</body>
</html>