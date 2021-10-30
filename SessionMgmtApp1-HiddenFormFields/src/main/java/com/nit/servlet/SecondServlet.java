package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set Response content type
		res.setContentType("text/html");

		//Read form1/request1 data from hidden box of form2
		String name = req.getParameter("hname");
		String fname = req.getParameter("hfname");
		String address = req.getParameter("haddrs");
		String ms = req.getParameter("hms");

		//Read form2/request2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");
		
		//Display form1/request1 data
		pw.println("<h1 style='color:red;text-align:center'>Two forms/requests data</h1>");
		pw.println("<table border='1' bgcolor='yellow' align='center'>");
		pw.println("<tr><td>Form1/Request1 Data:</td><td>"+name+"</td><td>"+fname+"</td><td>"+address+"</td><td>"+ms+"</td>");
		pw.println("<tr><td>Form2/Request2 Data:</td><td>"+f2val1+"</td><td>"+f2val2+"</td>");
		pw.println("</table>");
		
		//Add home hyperlink
		pw.println("<h1 style='text-align:center'><a href='person_details.html'>Home</a></h1>");
		
		//Close stream
		pw.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class