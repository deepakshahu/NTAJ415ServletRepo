package com.nit.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class PerformanceTestFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		long startTime=0L,endTime=0L;
		startTime = System.currentTimeMillis();  //request trapping time 
		chain.doFilter(req, res);  //goes to next filter or destination web comp
		endTime = System.currentTimeMillis();  //response trapping time
		
		System.out.println(req.getRequestURI()+" has taken "+(endTime-startTime)+" ms to process the request");
	}
}
