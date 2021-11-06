package com.nit.listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestAnalyzerListener implements ServletRequestListener {

	private long start,end;

	public RequestAnalyzerListener() {
		System.out.println("RequestAnalyzerListener :: 0-param constructor");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListener.requestInitialized()");
		start=System.currentTimeMillis();
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestAnalyzerListener.requestDestroyed()");
		end=System.currentTimeMillis();
		
		//Get HttpServletRequest object
		HttpServletRequest req = (HttpServletRequest) sre.getServletRequest();
		
		//Get ServletContext object
		ServletContext sc = req.getServletContext();
		sc.log(req.getRequestURI()+" has taken "+(end-start)+" ms time to process the request");
		System.out.println(req.getRequestURI()+" has taken "+(end-start)+" ms time to process the request");
	}//method
}//class
