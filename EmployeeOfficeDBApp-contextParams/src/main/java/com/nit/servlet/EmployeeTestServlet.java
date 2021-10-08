package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeTestServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Get access to ServletContext Object
		ServletContext sc = getServletContext();
		System.out.println("EmployeeTestServlet ServletContext obj HashCode : "+sc.hashCode());
		pw.println("<br> ServletContext Object Class Name : "+sc.getClass());
		pw.println("<br> Server Info : "+sc.getServerInfo());
		pw.println("<br> Servlet API version : "+sc.getMajorVersion()+"."+sc.getMinorVersion());
		pw.println("<br> MIME Type of search.html : "+sc.getMimeType("/search.html"));
		pw.println("<br> Path of web application : "+sc.getRealPath("/"));
		pw.println("<br> Path of search.html : "+sc.getRealPath("/search.html"));
		pw.println("<br> Name of the web application : "+sc.getContextPath());
		pw.println("<br> Virtual Host Name : "+sc.getVirtualServerName());
		
		//Get access to ServletConfig Object
		ServletConfig cg = getServletConfig();
		pw.println("<br> DB password init param values : "+cg.getInitParameter("dbPassword"));

		//Read Servlet Context parameter values
		pw.println("<br> DB password context param values : "+sc.getInitParameter("dbPassword"));
		pw.println("<br> DB user context param values : "+sc.getInitParameter("dbUsername"));

		//Close Stream
		pw.close();
	}//doGet(-,-)
}//class