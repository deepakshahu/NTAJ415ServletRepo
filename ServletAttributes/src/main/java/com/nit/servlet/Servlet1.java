package com.nit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Create request attribute
		req.setAttribute("attr1","val1");
		
		//Create session attribute
		HttpSession ses = req.getSession();
		ses.setAttribute("attr2","val2");
		
		//Create ServletContext attribute
		ServletContext sc = getServletContext();
		sc.setAttribute("attr3","val3");
		
		//Forward request to servlet2 component
		RequestDispatcher rd = req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class
