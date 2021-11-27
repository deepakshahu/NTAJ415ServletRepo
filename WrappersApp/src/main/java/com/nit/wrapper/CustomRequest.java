package com.nit.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public CustomRequest(HttpServletRequest request) {
		super(request);
		System.out.println("CustomRequest :: 1-param constructor");
		this.request=request;
	}

	@Override
	public String getParameter(String name) {
		System.out.println("CustomRequest.getParameter()");
		String paramValue = request.getParameter(name);
		if(name.equals("email")) {
			if(!paramValue.endsWith("@gmail.com"))
				paramValue=paramValue+"@gmail.com";
		}
		return paramValue;
	}
}