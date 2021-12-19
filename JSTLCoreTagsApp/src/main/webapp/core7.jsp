<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<b>from core7.jsp(start)</b><br>
	<c:url var="file" value="core4.jsp" scope="request" />
	<c:import url="${file}" />
	<b>from core7.jsp(End)</b>
</body>
</html>