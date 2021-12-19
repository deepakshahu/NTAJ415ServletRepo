<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${!empty empDetails }">
		<h1 style="color:blue;text-align:center">Employees Details belonging to ${param.job}</h1>
		<table border="1" align="center" bgcolor="cyan">
		<tr><th>EMPNO</th><th>EMP NAME</th><th>DESIGNATION</th><th>SALARY</th><th>GROSS SALARY</th><th>NET SALARY</th>
			<c:forEach var="emp" items="${empDetails}">
				<tr>
					<td>${emp.eno}</td>
					<td>${emp.ename}</td>
					<td>${emp.desg}</td>
					<td>${emp.salary}</td>
					<td>${emp.grossSalary}</td>
					<td>${emp.netSalary}</td>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:red;text-align:center">Employees Not Found</h1>
	</c:otherwise>
</c:choose>
<br>
<br>
<center>
	<a href="JavaScript:showPrint()">Print this page</a>
</center>
<script language="JavaScript">
	function showPrint() {
		frames.focus();
		frames.print();
	}
</script>
</body>
</html>