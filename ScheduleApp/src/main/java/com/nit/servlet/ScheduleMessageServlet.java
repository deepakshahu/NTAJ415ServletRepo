package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ScheduleMessageServlet extends HttpServlet {
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Set resposne content type
		res.setContentType("text/html");
		
		//Write b.logic to generate the wish message
		LocalDateTime ldt=LocalDateTime.now();  //give current date and time
		int hour = ldt.getHour();  //gives current hour of the day 0 to 23
		pw.println("<h1 style='color:red;text-align:center'>"+ldt.toString()+"</h1>");
		if(hour<7)
			pw.println("<h1 style='color:orange;text-align:center'>Workout Time : Go for Your Workout</h1>");
		else if(hour<10)
			pw.println("<h1 style='color:green;text-align:center'>Study Time : Complete Your Assignments</h1>");
		else if(hour<11)
			pw.println("<h1 style='color:pink;text-align:center'>Breakfast Time : Eat Your Breakfast</h1>");
		else if(hour<15)
			pw.println("<h1 style='color:red;text-align:center'>Lunch Time : Eat Your Lunch</h1>");
		else if(hour<18)
			pw.println("<h1 style='color:blue;text-align:center'>Tea Time : Eat Your Snacks</h1>");
		else if(hour<22)
			pw.println("<h1 style='color:red;text-align:center'>Dinner Time : Eat Your Delicious Dinner</h1>");
		else
			pw.println("<h1 style='color:red;text-align:center'>Study Time : Do Your Assignements and go for sleep once complete.</h1>");
		
		//Add home hyperlink
		pw.println("<br><a href='http://localhost:3030/ScheduleApp/home.html'>Home</a>");
		
		//Close Stream
		pw.close();
		
	}//service
}//close