package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Set Response content type
		res.setContentType("text/html");
		
		//Read form1/request1 data
		String name = req.getParameter("pname");
		String fname = req.getParameter("fname");
		String address = req.getParameter("addrs");
		String ms = req.getParameter("ms");
		
		//Generate form2 based on marital status value
		if(ms.equalsIgnoreCase("married")) {
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table border='1' bgcolor='pink' align='center'>");
			pw.println("<tr><td>Spouse Name: </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No of Kids: </td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='Register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='haddrs' value="+address+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
			pw.println("</table></form>");
		}
		else {
			pw.println("<form action='secondurl' method='POST'>");
			pw.println("<table border='1' bgcolor='pink' align='center'>");
			pw.println("<tr><td>Why do you want to marry: </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>When do you want to marry: </td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' value='Register'></td><td><input type='reset' value='cancel'></td></tr>");
			pw.println("<input type='hidden' name='hname' value="+name+">");
			pw.println("<input type='hidden' name='hfname' value="+fname+">");
			pw.println("<input type='hidden' name='haddrs' value="+address+">");
			pw.println("<input type='hidden' name='hms' value="+ms+">");
			pw.println("</table></form>");
		}
		
		//close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
