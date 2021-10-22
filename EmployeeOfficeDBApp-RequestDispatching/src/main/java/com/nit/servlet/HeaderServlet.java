package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/headurl")
public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException ,IOException {
		//Get PrintWriter object
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Write Header content
		pw.println("<marquee><h1 style='color:blue'>Naresh Technologies</h1></marquee>");

		//Do not close stream
		//pw.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
