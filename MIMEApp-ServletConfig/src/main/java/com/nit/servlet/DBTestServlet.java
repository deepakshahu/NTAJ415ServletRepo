package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBTestServlet extends HttpServlet {

	static {
		System.out.println("DBTestServlet :: static block");
	}
	
	public DBTestServlet() {
		System.out.println("DBTestServlet :: 0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("DBTestServlet.init()");
		ServletConfig cg = getServletConfig();
		System.out.println("Driver Class name:: "+cg.getInitParameter("driverClass"));
		System.out.println("JDBC Url:: "+cg.getInitParameter("url"));
	}
	
	/*//private ServletConfig cg;
	@Override
	public void init(ServletConfig cg) throws ServletException {
		//this.cg=cg;
		//super.init(cg);
		System.out.println("DBTestServlet :: init(ServletConfig cg)");
		//Read init param values from ServletConfig obj
		System.out.println("Driver Class name:: "+cg.getInitParameter("driverClass"));
		System.out.println("JDBC Url:: "+cg.getInitParameter("url"));
		System.out.println("JDBC User:: "+cg.getInitParameter("dbuser"));
		System.out.println("DB Password:: "+cg.getInitParameter("dbpwd"));
		//Write JDBC code here..using the jdbc properties available in ServletConfig obj
		
	}*/
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DBTestServlet:: service(req,res)");
		ServletConfig cg = getServletConfig();
		System.out.println("Driver Class name:: "+cg.getInitParameter("driverClass"));
		System.out.println("JDBC Url:: "+cg.getInitParameter("url"));
		//destroy();
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		//Set response content type
		res.setContentType("text/html");
		//Write messages to response object using PrintWriter
		pw.println("<h1 style='color:red;text-align:center'>Date and time :"+new java.util.Date()+"</h1>");
		//Close stream
		pw.close();
	}
	
	public static void main(String[] args) {
		System.out.println("DBTestServlet :: Main Method");
	}
	
	@Override
	public void destroy() {
		System.out.println("DBTestServlet :: destroy");
	}
}//class
