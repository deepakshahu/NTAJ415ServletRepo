<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page</title>
</head>
<body>
	<%!Connection con = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	private static final String INSERT_QUERY = "INSERT INTO JSP_PERSON_INFO VALUES(PID1_SEQ.NEXTVAL,?,?,?,?)";
	private static final String SELECT_QUERY = "SELECT PID,PNAME,PAGE,PADDRS,EMAILID FROM JSP_PERSON_INFO";

	public void jspInit() {
		//Get ServletConfig object directly
		ServletConfig cg = getServletConfig();

		//Read Init param values(jdbc properties)
		String driver = cg.getInitParameter("driverClass");
		String url = cg.getInitParameter("jdbcurl");
		String user = cg.getInitParameter("dbuser");
		String pwd = cg.getInitParameter("dbpwd");
		try {
			//Load JDBC driver class
			Class.forName(driver);
			//Establish the Connection
			con = DriverManager.getConnection(url, user, pwd);
			//Create PreparedStatement object
			ps1 = con.prepareStatement(SELECT_QUERY);
			ps2 = con.prepareStatement(INSERT_QUERY);
		} //try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>

	<%
	//Read additional request param value
	String pval = request.getParameter("p1");
	if (pval.equalsIgnoreCase("register")) { //for submit button
		//Read form data
		String name = request.getParameter("pname");
		int age = Integer.parseInt(request.getParameter("page"));
		String addrs = request.getParameter("paddrs");
		String mail = request.getParameter("mailid");

		//Set values to query params
		ps2.setString(1, name);
		ps2.setInt(2, age);
		ps2.setString(3, addrs);
		ps2.setString(4, mail);

		//Execute the query
		int result = ps2.executeUpdate();

		//Process the Result
		if (result == 0) {
	%>
	<h1 style="color: red; text-align: center">Record Not Inserted</h1>
	<%
	} else {
	%>
	<h1 style="color: green; text-align: center">Record Inserted</h1>
	<%
	}
	} else {
	//Execute the query
	ResultSet rs = ps1.executeQuery();
	%>
	<table border="1" align="center" bgcolor="cyan">
		<tr>
			<th>PID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>ADDRESS</th>
			<th>EMAIL ID</th>
		</tr>

		<%
		//Process the Result
		while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getInt(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
		</tr>
		<%
		} //while
		%>
	</table>
	<%
	} //else
	%>
	<br>
	<h2 style="text-align: center">
		<a href="person_form.html">Home</a>
	</h2>
	<%!public void jspDestroy() {
		//Close jdbc objects
		try {
			if (ps1 != null)
				ps1.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (ps2 != null)
				ps2.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (con != null)
				con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}%>
</body>
</html>