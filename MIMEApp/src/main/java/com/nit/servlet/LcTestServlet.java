package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LcTestServlet extends HttpServlet {
	
	static {
		System.out.println("LcTestServlet :: static block");
	}
	
	public LcTestServlet() {
		System.out.println("LcTestServlet :: 0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("LcTestServlet :: init(ServletConfig cg)");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("LcTestServlet:: service(req,res)");
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
		System.out.println("LcTestServlet :: Main Method");
	}
	
	@Override
	public void destroy() {
		System.out.println("LcTestServlet :: destroy");
	}
}//class
