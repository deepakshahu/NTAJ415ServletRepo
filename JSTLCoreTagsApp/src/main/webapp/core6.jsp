<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<c:set var="msg" value="hello, how are you ?" scope="request" />
	<c:forTokens var="token" items="${msg}" delims=" ">
			${token}<br>
		</c:forTokens>
</body>
</html>