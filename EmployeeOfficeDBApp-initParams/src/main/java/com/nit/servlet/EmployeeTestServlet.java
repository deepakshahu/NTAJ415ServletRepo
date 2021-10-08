package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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

		//Get access to ServletConfig Object
		ServletConfig cg = getServletConfig();
		System.out.println("EmployeeTestServlet ServletConfig obj HashCode : "+cg.hashCode());
		pw.println("Servlet Name : "+cg.getServletName());
		pw.println("<br> ServletConfig Object Class Name : "+cg.getClass());

		//Read Servlet int parameter values
		pw.println("<br> DB user name : "+cg.getInitParameter("dbUsername"));
		
		//Close Stream
		pw.close();
	}//doGet(-,-)
}//class