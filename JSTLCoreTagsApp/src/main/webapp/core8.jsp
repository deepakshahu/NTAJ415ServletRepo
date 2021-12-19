<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<b>from core8.jsp(start)</b><br>
	<c:url var="googleUrl" value="https://google.com/search?q=java" scope="request" />
	<c:redirect url="${googleUrl}"/>
	<b>from core8.jsp(End)</b>
</body>
</html>