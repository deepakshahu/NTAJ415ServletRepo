<%@ page import="java.util.*,com.nit.model.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HTML Screen Page</title>
</head>
<body>
	<%
	//Read request scope data
	List<Employee> list = (List<Employee>) request.getAttribute("empDetails");
	String desg = request.getParameter("job");
	%>

	<%
	if (list != null && list.size() != 0) {
		int i = 1;
	%>

	<h1 style="color: red; text-align: center">
		Employees belonging to
		<%=desg%></h1>
	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<th>SNO</th>
			<th>EMPNO</th>
			<th>ENAME</th>
			<th>DESIGNATION</th>
			<th>SALARY</th>
			<th>GROSS SALARY</th>
			<th>NET SALARY</th>
		</tr>
		<%
		for (Employee emp : list) {
		%>
		<tr>
			<td><%=i++%></td>
			<td><%=emp.getEno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getDesg()%></td>
			<td><%=emp.getSalary()%></td>
			<td><%=emp.getGrossSalary()%></td>
			<td><%=emp.getNetSalary()%></td>
		</tr>
		<%
		} //for
		%>
	</table>
	<%
	} //if
	else {
	%>
	<h1 style="color: red; text-align: center">Records not found</h1>
	<%
	}
	%>
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