package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet{
	private static final String CUSTOMER_INSERT_QUERY = "INSERT INTO SERVLET_CUSTOMER VALUES(CUST_CNO.NEXTVAL,?,?,?,?)";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Set Response Content type
		res.setContentType("text/html");
		
		//Read form data
		String name = req.getParameter("cname");
		String addrs = req.getParameter("cadd");
		float billAmt = Float.parseFloat(req.getParameter("billAmt"));
		long mobileNo = Long.parseLong(req.getParameter("mobileNo"));
		
		//Get Pooled JDBC Connection object
		try(Connection con = getPooledConnection();
				PreparedStatement ps = con.prepareStatement(CUSTOMER_INSERT_QUERY);){
			//Set values to query params
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setFloat(3, billAmt);
			ps.setLong(4, mobileNo);
			
			//Execute the query
			int result = ps.executeUpdate();
			
			//Process the result
			if(result==1)
				pw.println("<h1 style='color:green;text-align:center'>Customer is registered</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Customer is not registered</h1>");
			
			//Add hyperlink
			pw.println("<h1 style='color:red;text-align:center'><a href='customer_register.html'>Home</a></h1>");
			
			//Close stream
			pw.close();
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem-Try Again</h1>"+se.getMessage());
			//Add hyperlink
			pw.println("<h1 style='color:red;text-align:center'><a href='customer_register.html'>Home</a></h1>");
		}//catch
		catch(Exception e) {
			e.printStackTrace();
			pw.println("<h1 style='color:red;text-align:center'>Internal Problem-Try Again</h1>"+e.getMessage());
			//Add hyperlink
			pw.println("<h1 style='color:red;text-align:center'><a href='customer_register.html'>Home</a></h1>");
		}//catch
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	//Helper Method
	private Connection getPooledConnection() throws Exception{
		//Create initial context object
		InitialContext ic = new InitialContext();
		
		//Get DataSource object reference through lookup operation
		//DataSource ds = (DataSource) ic.lookup("DsJndi");
		//DataSource ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
		//Get DsJndi name from servlet init param
		String jndiName = getServletConfig().getInitParameter("jndi");
		DataSource ds = (DataSource) ic.lookup(jndiName);
		
		//Get Pooled JDBC Connection
		Connection con = ds.getConnection();
		return con;
	}//method
}//class