package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="err", value="/errorurl")
public class ErrorServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doGet()");
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		//Set Response Content type
		res.setContentType("text/html");
		//Write error response
		pw.println("<h1 style='color:red;text-align:center'>Internal Problem-Please try again</h1>");
		//Close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("ErrorServlet.doPost()");
		doGet(req,res);
	}
}
