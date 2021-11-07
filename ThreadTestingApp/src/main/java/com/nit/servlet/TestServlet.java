package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet implements SingleThreadModel{
	
	public TestServlet() {
		System.out.println("TestServlet :: 0-param constructor :: "+this.hashCode());
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Get PrintWriter object
		PrintWriter pw = res.getWriter();
		
		//Set Response content type
		res.setContentType("text/html");
		
		//Write response
		pw.println("<h1>Date and Time :: "+new Date()+"</h1>");
		try {
			Thread.sleep(30000);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//Close stream
		pw.close();
	}//doGet(-,-)
}//class