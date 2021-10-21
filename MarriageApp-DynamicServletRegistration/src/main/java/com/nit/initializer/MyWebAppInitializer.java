package com.nit.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import com.nit.servlet.MarriageServlet;

public class MyWebAppInitializer implements ServletContainerInitializer {
	
	static {
		System.out.println("MyWebAppInitializer :: Static Block");
	}
	
	public MyWebAppInitializer() {
		System.out.println("MyWebAppInitializer :: 0-param constructor");
	}

	@Override
	public void onStartup(Set<Class<?>> set, ServletContext sc) throws ServletException {
		
		MarriageServlet servlet = null;
		ServletRegistration.Dynamic dyna = null;
		System.out.println("MyWebAppInitializer.onStartup()");
		
		//Create our Servlet class object
		servlet = new MarriageServlet();
		
		//Register Servlet comp
		dyna = sc.addServlet("ms", servlet);
		
		//Map with url/ url pattern
		dyna.addMapping("/marriageurl");
		
		//Enable load-on-startup
		dyna.setLoadOnStartup(1);
	}
}	