<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Core Tag</title>
</head>
<body>
	<c:catch var="e">
		<jsp:scriptlet>
			java.util.Date d = null;
			d.getYear();
		</jsp:scriptlet>
	</c:catch>
	<b>The Raised Exception is :: ${e}</b>
</body>
</html>