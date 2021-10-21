package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet{
	private static final String GET_EMP_BY_ENO="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EmployeeSearchServlet.doGet()");
		PrintWriter pw = null;
		try {
			//Get PrintWriter
			pw = res.getWriter();

			//Set response content type
			res.setContentType("text/html");

			//Get access to ServletConfig Object
			ServletConfig cg = getServletConfig();

			//Read Servlet int parameter values
			String driver = cg.getInitParameter("driverClass");
			String url = cg.getInitParameter("dbUrl");
			String username = cg.getInitParameter("dbUsername");
			String password = cg.getInitParameter("dbPassword");

			//Read form data
			int no = Integer.parseInt(req.getParameter("eno"));

			try {
				Class.forName(driver);
			}catch(ClassNotFoundException cnf) {
				cnf.printStackTrace();
			}

			//Write JDBC code
			try(Connection con = DriverManager.getConnection(url,username,password);
					PreparedStatement ps = con.prepareStatement(GET_EMP_BY_ENO)){
				if(ps!=null)
					ps.setInt(1, no);
				try(ResultSet rs = ps.executeQuery()){
					if(rs!=null) {
						if(rs.next()) {
							pw.println("<h1 style='color:blue;text-align:center'>Employee Details are</h1>");
							pw.println("<table border='1' bgcolor='cyan' align='center'><tr><td>Employee Number :</td><td>"+rs.getInt(1)+"</td></tr>");
							pw.println("<tr><td>Employee Name :</td><td>"+rs.getString(2)+"</td></tr>");
							pw.println("<tr><td>Employee Salary :</td><td>"+rs.getFloat(3)+"</td></tr>");
							pw.println("<tr><td>Employee Job :</td><td>"+rs.getString(4)+"</td></tr>");
							pw.println("<tr><td>Employee Dept No :</td><td>"+rs.getInt(5)+"</td></tr></table>");
						}
						else {
							pw.println("<h1 style='color:red;text-align:center'>Employee not found</h1>");
						}//else
					}//if
					pw.println("<br><br><p style='text-align:center'><a href='search.html'>Home</a>");

					//Close Stream
					pw.close();
				}//try3
			}//try2
		}//try1
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<b>Before rd.forward(-,-)</b>");
			System.out.println("Main :: Before rd.forward(-,-)");
			//RequestDispatcher rd = req.getRequestDispatcher("/errorurl");
			/*ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher("/errorurl");*/
			RequestDispatcher rd1 = req.getRequestDispatcher("/error.html");
			rd1.forward(req, res);
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getNamedDispatcher("err");
			rd.forward(req, res);
			
			pw.println("<b>After rd.forward(-,-)</b>");
			System.out.println("Main :: After rd.forward(-,-)");
		}
	}//doGet(-,-)

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class