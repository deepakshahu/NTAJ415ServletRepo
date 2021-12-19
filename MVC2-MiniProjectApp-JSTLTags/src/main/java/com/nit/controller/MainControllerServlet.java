package com.nit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.model.Employee;
import com.nit.service.EmployeeMgmtServiceImpl;
import com.nit.service.IEmployeeMgmtService;

@WebServlet(urlPatterns="/controllerurl",loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet{
	private IEmployeeMgmtService service;
	
	@Override
	public void init() throws ServletException {
		service = new EmployeeMgmtServiceImpl();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Read form data
		String desg = req.getParameter("job");
		String action = req.getParameter("s1");
		
		//Invoke business method on service class object
		try {
			//Invoke business method on service class object
			List<Employee> list = service.fetchEmpsByDesg(desg);
			//Keep the results in request scope to send to view component
			req.setAttribute("empDetails", list);
			//Forward the request to result page based on the button that is clicked
			String resultPage = null;
			if(action.equalsIgnoreCase("HtmlOutput"))
				resultPage = "/html_screen.jsp";
			else
				resultPage = "/excel_screen.jsp";
			//Forward the request to result page
			RequestDispatcher rd = req.getRequestDispatcher(resultPage);
			rd.forward(req, res);
		}//try
		catch(SQLException se) {
			se.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
		catch(Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}		
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost(-,-)
}//class