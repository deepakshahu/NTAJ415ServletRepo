<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<!-- To create data in scope -->
	<c:set var="msg" value="hello" scope="session" />
	<!-- To display data collecting from scope -->
	<b>msg value :: </b><c:out value="${msg}"/>
	<!-- To remove data from scope -->
	<c:remove var="msg"/>
	<!-- To display data collecting from scope -->
	<br><b>msg value :: </b><c:out value="${msg}"/>
</body>
</html>