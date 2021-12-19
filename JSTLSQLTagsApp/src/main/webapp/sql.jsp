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
	<sql:query var="rs" dataSource="${ds}"
		sql="SELECT EMPNO,ENAME,JOB,SAL FROM EMP" />

	<!-- Process the ResultSet object -->
	<h1 style="color: red; text-align: center">The Records are as
		below.</h1>
	<table border="1" bgcolor="cyan" align="center">
		<tr>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>JOB</th>
			<th>SALARY</th>
		</tr>

		<c:forEach var="e" items="${rs.rows}">
			<tr>
				<td>${e.empno}</td>
				<td>${e.ename}</td>
				<td>${e.job}</td>
				<td>${e.sal}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>