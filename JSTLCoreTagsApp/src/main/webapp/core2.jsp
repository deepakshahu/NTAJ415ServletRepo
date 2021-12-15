<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<c:set var="msg" value="Welcome" />

	<c:if test="${param.uname ne null}">
		<h1 style="color: red; text-align: center">
			<c:out value="${msg}" />
			<c:out value="${param.uname}" />
		</h1>
	</c:if>
	<h1 style="color: blue; text-align: center">Hi to every one</h1>
</body>
</html>