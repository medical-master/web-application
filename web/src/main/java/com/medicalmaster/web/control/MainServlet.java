package com.medicalmaster.web.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xross.tools.xunit.XunitFactory;

@WebServlet(name="MainServlet", urlPatterns="/action")  
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  
	   
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
	    XunitFactory f;
		try {
			f = XunitFactory.load("main.xunit");
		    ResourceProxyContext ctx = new ResourceProxyContext();
		    ctx.setRequest(request);
		    ctx.setResponse(response);
		    f.getProcessor("main").process(ctx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write("Hello User.");  
	}
}
