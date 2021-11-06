package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set Response content type
		res.setContentType("text/html");

		//Read form2/request2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");
		
		//Get Access to HttpSession object
		HttpSession ses = req.getSession(false);
		
		//Read form1/request1 data from session attributes(Session Tracking)
		String name = (String)ses.getAttribute("name");
		String fname = (String)ses.getAttribute("fname");
		String address = (String)ses.getAttribute("addrs");
		String ms = (String)ses.getAttribute("ms");
		
		//Display form1/request1 data
		pw.println("<h1 style='color:red;text-align:center'>Two forms/requests data</h1>");
		pw.println("<table border='1' bgcolor='yellow' align='center'>");
		pw.println("<tr><td>Form1/Request1 Data:</td><td>"+name+"</td><td>"+fname+"</td><td>"+address+"</td><td>"+ms+"</td>");
		pw.println("<tr><td>Form2/Request2 Data:</td><td>"+f2val1+"</td><td>"+f2val2+"</td>");
		pw.println("</table>");
		
		//Invalidate the session
		ses.invalidate();
		
		//Add home hyperlink
		pw.println("<h1 style='text-align:center'><a href='person_details.html'>Home</a></h1>");
		
		//Get Session id
		pw.println("<br><br><b>Session id :: "+ses.getId()+"</b>");
		
		//Close stream
		pw.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class