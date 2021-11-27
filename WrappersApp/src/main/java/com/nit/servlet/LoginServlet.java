package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("LoginServlet.doGet()");
		System.out.println("Request object type :: "+req.getClass()+"  "+res.getClass());
		
		//Get PrintWriter
		PrintWriter pw = res.getWriter();
		
		//Set response content type
		res.setContentType("text/html");
		
		//Read form data
		String mail = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		System.out.println(mail+"  "+pwd);
		
		//Write business logic
		if(mail.equalsIgnoreCase("deepakshahu1996@gmail.com") && pwd.equalsIgnoreCase("deepak123")) {
			pw.println("<h1 style='color:green;text-align:center'>Valid Credentials</h1>");
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>InValid Credentials</h1>");
		}
		
		//Add Home Hyperlink
		pw.println("<br><h1 style='text-align:center'><a href='login.html'>Home</a></h1>");
		
		//Close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
