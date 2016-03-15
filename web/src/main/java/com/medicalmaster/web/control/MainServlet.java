package com.medicalmaster.web.control;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xross.tools.xunit.Processor;
import com.xross.tools.xunit.XunitFactory;

@WebServlet(name="MainServlet", urlPatterns="/action")  
@MultipartConfig
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	private Processor main;
	
	public void init(ServletConfig config) throws ServletException {
	    try {
		    main = XunitFactory.load("main.xunit").getProcessor("main");
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	   
	@Override  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		process(request, response);  
	}  
	   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		process(request, response);  
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		process(request, response);  
	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		process(request, response);  
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		    WebContext ctx = new WebContext(request, response);
		    main.process(ctx);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
}
