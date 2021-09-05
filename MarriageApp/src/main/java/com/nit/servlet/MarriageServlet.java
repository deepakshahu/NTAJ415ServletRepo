package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MarriageServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("VaccineEligibilityCheckServlet.doPost(-,-)");

		//Set response content type
		res.setContentType("text/html");

		//Get PrintWriter obj
		PrintWriter pw = res.getWriter();

		//Read form data(req param values)
		String name=req.getParameter("pname");
		String tage=req.getParameter("page");
		String gender=req.getParameter("pgender");
		String csvStatus=req.getParameter("vflag");

		int age=0;
		if(csvStatus.equalsIgnoreCase("no")) {
			//Form validation logic(server side)
			System.out.println("Server side form validations");
			List<String> errorsList=new ArrayList();

			if(name==null || name.length()==0 || name.equalsIgnoreCase(""))  //Required rule on person name
				errorsList.add("Person name is required");


			if(tage==null || tage.length()==0 || tage.equalsIgnoreCase(""))  //Required rule on person age
				errorsList.add("Person age is required");
			else {
				try {
					age=Integer.parseInt(tage);
					if(age<=0 || age>125)
						errorsList.add("Person age must be in the range of 1 through 125"); //age range rule
				}
				catch(NumberFormatException nfe) {
					errorsList.add("Person age must be numeric value");
				}//catch
			}//else
			
			if(gender==null || gender.length()==0 || gender.equalsIgnoreCase(""))  //Required rule on person gender
				errorsList.add("Person gender is required");

			if(errorsList.size()>0) {
				pw.println("<ul style='color:red'>");
				for(String errMsg:errorsList)
					pw.println("<li>"+ errMsg +"</li>");
				pw.println("</ul>");
				return;  //block control going further
			}
		}
		else
			age=Integer.parseInt(tage);
		//Write b.logic or request processing logic
		if(gender.equalsIgnoreCase("M")) {
			if(age<21)
				pw.println("<h1 style='color:red;text-align:center'>Mr."+name+" you are not eligible for marriage, enjoy life !!</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Mr."+name+" you are eligible for marriage, but think once.</h1>");
		}
		else {
			if(age<18)
				pw.println("<h1 style='color:red;text-align:center'>Mrs."+name+" you are not eligible for marriage, be happy.</h1>");
			else
				pw.println("<h1 style='color:red;text-align:center'>Mrs."+name+" you are eligible for marriage, but think thrice.</h1>");
		}

		//Add graphical hyperlink for home navigation
		pw.println("<br><a href='inputurl'><img src='images/home.png' width='100' height='150'></a>");

		//Close Stream
		pw.close();
	}//doPost(-,-)
}//class