package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Read form data
		int country=Integer.parseInt(req.getParameter("country"));
		//get Capital city name
		String capitals[] = new String[] {"New Delhi","Islamabad","Washington D.C","Beijing"};
		String countries[] = new String[] {"India","Pakistan","USA","China"};
		pw.println("<h1 style='color:red;text-align:center'>Capital name of country "+countries[country]+ " is :"+capitals[country]+"</h1>");

		//Add home hyperlink
		pw.println("<a href='page.html'>Home</a>");

		//Close stream
		pw.close();
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}