package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reporturl")
public class EmployeeReportServlet extends HttpServlet {
	private static final String GET_ALL_EMPS_QUERY="SELECT EID,ENAME,EADD,RESUME_PATH,PHOTO_PATH FROM UPLOAD_EMPLOYEE";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");
		
		//Load the JDBC driver class
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}

		//Write JDBC code to get DB table record as report content
		try(Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				PreparedStatement ps = con.prepareStatement(GET_ALL_EMPS_QUERY);
				ResultSet rs = ps.executeQuery();
				){
			//Process the ResultSet and display the content as HTML table content
			pw.println("<table border='1' align='center' bgcolor='cyan'>");
			pw.println("<tr><th>EMPNO</th><th>ENAME</th><th>EADD</th><th>RESUME</th><th>PHOTO</th>");
			while(rs.next()) {
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt(1)+"</td>");
				pw.println("<td>"+rs.getString(2)+"</td>");
				pw.println("<td>"+rs.getString(3)+"</td>");
				pw.println("<td><a href='downloadurl?resumeid="+rs.getInt(1)+"'>Download Resume</a></td>");
				pw.println("<td><a href='downloadurl?photoid="+rs.getInt(1)+"'>Download Photo</a></td>");
				pw.println("</tr>");
			}
			pw.println("</table>");
			
			//Add home hyperlink
			pw.println("<br><h1 style='text-align:center'><a href='index.html'>Home</a></h1>");
			
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//doGet(-,-)

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}//doPost(-,-)
}//class
