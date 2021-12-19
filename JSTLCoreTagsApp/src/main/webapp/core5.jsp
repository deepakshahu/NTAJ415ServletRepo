<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<h1>Request param names and values</h1>
	<c:forEach var="p" items="${paramValues}">
		<b>request param name :: ${p.key}</b>
		<br>
		<b>request param value ::</b>
		<c:forEach var="pv" items="${p.value}">
			${pv},
		</c:forEach>
		<br>
	</c:forEach>
	<hr>
	<h1>Request header names and values</h1>
	<c:forEach var="h" items="${headerValues}">
		<b>request header name :: ${h.key}</b>
		<br>
		<b>request header values :: </b>
		<c:forEach var="hv" items="${h.value}">
	${hv}
	</c:forEach>
		<br>
	</c:forEach>
</body>
</html>