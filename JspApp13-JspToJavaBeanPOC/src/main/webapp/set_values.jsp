<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" import="com.nit.beans.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Values</title>
</head>
<body>
	<!-- Create or locate java bean class object -->
	<jsp:useBean id="st" class="com.nit.beans.StudentInfo" scope="session" />

	<!-- Set values to bean properties -->
	<%-- <jsp:setProperty name="st" property="sno" value="1001" />
	<jsp:setProperty name="st" property="sname" value="rakesh" />
	<jsp:setProperty name="st" property="sadd" value="hyd" />
	<jsp:setProperty name="st" property="avg" value="90.77f" /> --%>
	<!-- <b>Values are set to java bean properties</b> -->
	
	<!-- Setting form data as java bean property values -->
	<%-- <jsp:setProperty name="st" property="sno" param="stno" />
	<jsp:setProperty name="st" property="sname" param="stname" />
	<jsp:setProperty name="st" property="sadd" param="stadd" />
	<jsp:setProperty name="st" property="avg" param="stavg" /> --%>
	<!-- <b>Values/request param values are set to java bean properties</b> -->
	
	<!-- Setting form data as the java bean property values use property="*" symbol
	if request param names are matching with java bean class object property name-->
	<jsp:setProperty name="st" property="*" />
	<b>Values/request param values are set to java bean properties</b>
</body>
</html>