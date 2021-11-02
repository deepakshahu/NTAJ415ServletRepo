package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Set response content type
		res.setContentType("text/html");
		
		//Create Cookies
		Cookie ck1 = new Cookie("AP","NoCapital");
		Cookie ck2 = new Cookie("TS","Hyd");
		Cookie ck3 = new Cookie("MH","Mumbai");
		Cookie ck4 = new Cookie("Odisha","BBSR");
		ck3.setMaxAge(3*60);
		ck4.setMaxAge(2*60);
		
		//Add cookies to response
		res.addCookie(ck1); res.addCookie(ck2); //InMemory Cookies
		res.addCookie(ck3); res.addCookie(ck4); //Persistent Cookies
		
		pw.println("<h1 style='color:red;text-align:center'>Cookies are added successfully</h1>");
		
		//Close stream
		pw.close();
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class