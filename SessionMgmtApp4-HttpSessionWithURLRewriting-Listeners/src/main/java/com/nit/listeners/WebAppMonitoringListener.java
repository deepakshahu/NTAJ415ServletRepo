package com.nit.listeners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebAppMonitoringListener implements ServletContextListener {

	private long start=0, end=0;

	public WebAppMonitoringListener() {
		System.out.println("enclosing_type :: 0-param constructor");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("WebAppMonitoringListener.contextInitialized()");
		start=System.currentTimeMillis();

		//Get ServletContext object
		ServletContext sc = sce.getServletContext();
		sc.log("Web Application is deployed/reloaded/redeployed at : "+new Date());
		System.out.println("Web Application is deployed/reloaded/redeployed at : "+new Date());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("WebAppMonitoringListener.contextDestroyed()");
		end=System.currentTimeMillis();

		//Get ServletContext object
		ServletContext sc = sce.getServletContext();
		sc.log("Web Application is undeployed/stopped at : "+new Date());
		System.out.println("Web Application is undeployed/stopped at : "+new Date());
	}
}//class