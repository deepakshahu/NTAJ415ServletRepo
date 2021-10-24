package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/searchurl")
public class SearchServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Set response content type
		res.setContentType("text/html");
		
		//Read form data
		String ss = req.getParameter("ss");
		String engine = req.getParameter("engine");
		
		//Send HyperLinks to browser having url to complete sendRedirection
		if(engine.equalsIgnoreCase("google"))
			pw.println("<h1 style='text-align:center'><a href='https://www.google.com/search?q="+ss+"'>Click here for Google Search</a></h1>");
		else if(engine.equalsIgnoreCase("bing"))
			pw.println("<h1 style='text-align:center'><a href='https://www.bing.com/search?q="+ss+"'>Click here for Bing Search</a></h1>");
		else
			pw.println("<h1 style='text-align:center'><a href='https://in.search.yahoo.com/search?p="+ss+"'>Click here for Yahoo Search</a></h1>");
		
		//Close Stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class