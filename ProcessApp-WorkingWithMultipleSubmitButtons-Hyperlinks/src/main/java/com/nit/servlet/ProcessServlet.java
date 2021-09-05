package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//Get PrintWriter
		PrintWriter pw=res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Read additional req param value(s1)
		String s1val=req.getParameter("s1");

		int val1=0, val2=0;
		//read text box value only when request is not from hyperlinks
		if(!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) { 
			val1 = Integer.parseInt(req.getParameter("value1"));
			val2 = Integer.parseInt(req.getParameter("value2"));
		}

		//Differentiate logics for SubmitButtons and Hyperlinks
		if(s1val.equalsIgnoreCase("add")) {
			pw.println("<h1 style='color:red;text-align:center'>Addition of "+val1+" and "+val2+" is: "+(val1+val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("sub")) {
			pw.println("<h1 style='color:red;text-align:center'>Subtraction of "+val1+" and "+val2+" is: "+(val1-val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("mul")) {
			pw.println("<h1 style='color:red;text-align:center'>Multiplication of "+val1+" and "+val2+" is: "+(val1*val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("div")) {
			pw.println("<h1 style='color:red;text-align:center'>Division of "+val1+" and "+val2+" is: "+((float)val1/val2)+"</h1>");
		}
		else if(s1val.equalsIgnoreCase("link1")) {
			pw.println("<h1>System Properties are: </h1>");
			pw.println("<b>"+System.getProperties()+"</b>");
		}
		else
			pw.println("<h1>System Date and Time :"+LocalDateTime.now()+"</h1>");

		//Add home hyperlink
		pw.println("<br><a href='form.html'>Home</a>");

		//Close stream
		pw.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
