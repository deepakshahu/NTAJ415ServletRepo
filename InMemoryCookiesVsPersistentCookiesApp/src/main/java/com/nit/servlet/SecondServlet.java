package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();

		//Set response content type
		res.setContentType("text/html");

		//Read cookies
		Cookie cookies[] = req.getCookies();

		//Display cookie details as HTML table content
		if(cookies!=null) {
			pw.println("<table border='1' align='center' bgcolor='cyan'>");
			for(Cookie ck:cookies) {
				pw.println("<tr><td>"+ck.getName()+"</td><td>"+ck.getValue()+"</td></tr>");
			}
			pw.println("</table>");
		}
		else {
			pw.println("<h1 style='color:blue;text-align:center'>No Cookies Present</h1>");
		}

		//Close stream
		pw.close();
	}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class