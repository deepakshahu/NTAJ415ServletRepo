package com.nit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.wrapper.CustomRequest;
import com.nit.wrapper.CustomResponse;

@WebFilter("/loginurl")
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		//Create custom request object
		CustomRequest creq = new CustomRequest(req);

		//Create custom response object
		CustomResponse cres = new CustomResponse(res);

		chain.doFilter(creq, cres);  //Calls next filter or destination component

		//Collect content from custom response object
		String output = cres.toString();

		//Modify the content
		output = output +"<br><b>Naresh IT</b>";

		//Get PrintWriter pointing to container created response object
		PrintWriter pw = res.getWriter();
		pw.println(output);  //Writes to container created response object -->container-->server-->browser window
		
		//Close stream
		pw.close();
	}
}
