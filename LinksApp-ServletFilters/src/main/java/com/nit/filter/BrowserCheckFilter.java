package com.nit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BrowserCheckFilter extends HttpFilter {
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("BrowserCheckFilter.doFilter()");
		
		//Set Response Content type
		res.setContentType("text/html");
		
		//Get PrintWriter object
		PrintWriter pw = res.getWriter();
		
		//Get Browser name
		String browser = req.getHeader("user-agent");
		System.out.println(browser);
		
		if(browser.contains("Chrome")) {
			chain.doFilter(req, res);  //Execute next filter or destination web comp
		}
		else {
			pw.println("<h1 style='color:red;text-align:center'>Request must be given from chrome browser</h1>");
			return;
		}
		
		//close the stream
		pw.close();
	}//doFilter(-,-)
}//class
