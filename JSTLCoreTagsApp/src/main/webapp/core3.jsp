<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.p lt 0}">
			<h1 style="color: red; text-align: center">${param.p} is Negative</h1>
		</c:when>
		<c:when test="${param.p gt 0}">
			<h1 style="color: red; text-align: center">${param.p} is Positive</h1>
		</c:when>
		<c:otherwise>
			<h1 style="color: red; text-align: center">${param.p} is Zero</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>