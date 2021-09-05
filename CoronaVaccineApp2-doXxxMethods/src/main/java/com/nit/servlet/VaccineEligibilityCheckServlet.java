package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VaccineEligibilityCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("VaccineEligibilityCheckServlet.doPost(-,-)");

		//Get PrintWriter
		PrintWriter pw=res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Read form data(req parameters value)
		String name = req.getParameter("pname");
		String addrs = req.getParameter("paddrs");
		int age = Integer.parseInt(req.getParameter("page"));

		//Write b.logic (request processing logic)
		if(age<18)
			pw.println("<h1 style='color:red; text-align:center'> Mr/Miss/Mrs. "+name+" you are not eligible for Corona Vaccination</h1>");
		else
			pw.println("<h1 style='color:green; text-align:center'> Mr/Miss/Mrs. "+name+" you are eligible for Corona Vaccination, Make it happen</h1>");

		//Add graphical hyperlink for home
		pw.println("<a href='corona_vaccine.html'><img src='images/home.png' width='150px' height='150px'></a>");

		//Close Stream objs
		pw.close();
	}//doPost(-,-);

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("VaccineEligibilityCheckServlet.doGet(-,-)");

		//Get PrintWriter 
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//get System date and time
		LocalDateTime ldt = LocalDateTime.now();
		int hour=ldt.getHour();

		if(hour<12)
			pw.println("<h1 style='color:orange;text-align:center'>Good Morning</h1>");
		else if(hour<16)
			pw.println("<h1 style='color:yellow;text-align:center'>Good Afternoon</h1>");
		else if(hour<20)
			pw.println("<h1 style='color:blue;text-align:center'>Good Evening</h1>");
		else
			pw.println("<h1 style='color:Grey;text-align:center'>Good Night</h1>");

		//Close Stream
		pw.close();

	}//doGet(-,-);
}//class