//ExcelServlet.java
package com.nit.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExcelServlet extends HttpServlet{
	
	static {
		System.out.println("ExcelServlet :: static block");
	}
	
	public ExcelServlet() {
		System.out.println("ExcelServlet :: 0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("ExcelServlet :: init(ServletConfig cg)");
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("ExcelServlet:: service(req,res)");
		//Set response content type
		res.setContentType("application/vnd.ms-excel");
		
		//Get PrintWriter Stream
		PrintWriter pw = res.getWriter();
		
		//Write output content to browser
		pw.println("<table border='1' align='center'>");
		pw.println("<tr><th>Player Name</th><th>Medal</th><th>Category</th></tr>");
		pw.println("<tr><td>Neeraj Chopra</td><td>Gold</td><td>Javaline throw</td></tr>");
		pw.println("<tr><td>Meera bhai chanu</td><td>Silver</td><td>Weight lifting</td></tr>");
		pw.println("<tr><td>RaviKumar Dhahiya</td><td>Gold</td><td>Wrestling</td></tr>");
		pw.println("<tr><td>P.V Sindhu</td><td>Bronze</td><td>Badminton</td></tr>");
		pw.println("<tr><td>Lovlina</td><td>Bronze</td><td>Boxing</td></tr>");
		pw.println("<tr><td>Hockey</td><td>Bronze</td><td>Mens Hockey</td></tr>");
		pw.println("<tr><td>Bajrang</td><td>Bronze</td><td>Wrestling</td></tr>");
		pw.println("</table>");
		
		//Close stream
		pw.close();
		
	}//service(-,-)
}//class