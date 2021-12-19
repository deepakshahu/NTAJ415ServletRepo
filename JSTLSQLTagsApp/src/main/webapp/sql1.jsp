<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SQL Tags App</title>
</head>
<body>
	<!-- Setup data source -->
	<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:xe" user="system"
		password="manager" />

	<!-- Send and execute the SELECT sql query -->
	<sql:update var="count" dataSource="${ds}"
		sql="UPDATE EMP SET SAL=SAL+? WHERE JOB=?">
		<sql:param value="500" />
		<sql:param>CLERK</sql:param>
	</sql:update>
    <b>${count} no of records are updated</b>
</body>
</html>