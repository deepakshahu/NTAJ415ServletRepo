package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowHomeServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Set response content type
		res.setContentType("text/html");
		
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Write output to response obj
		pw.println("<h1 style='color:red;text-align:center'>Welcome to Servlet</h1>");
		
		//Close Stream
		pw.close();
	}
}