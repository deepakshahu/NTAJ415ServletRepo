//PlainServlet.java
package com.nit.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class PlainServlet extends HttpServlet{
	
	static {
		System.out.println("PlainServlet :: static block");
	}
	
	public PlainServlet() {
		System.out.println("PlainServlet :: 0-param constructor");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("PlainServlet :: init(ServletConfig cg)");
	}
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("PlainServlet:: service(req,res)");
		//Set response content type
		res.setContentType("text/plain");
		
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