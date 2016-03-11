package com.medicalmaster.web.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xross.tools.xunit.Context;

public class WebContext implements Context {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Object result;
	private String targetPage;
	private boolean redirect;
	
	public WebContext(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	private String resource;
	private HttpMethod method;
	private String userId;
	private String userName;

	public void wrapException(Throwable e) {
		new RuntimeException(e);
	}
	
	public String getTargetPage() {
		return targetPage;
	}
	public void setResponseSection(String targetPage) {
		this.targetPage = targetPage;
		request.setAttribute("responseSection", targetPage);
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
		request.setAttribute("result", result);
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
