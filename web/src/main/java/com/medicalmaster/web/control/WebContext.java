package com.medicalmaster.web.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xross.tools.xunit.Context;

public class WebContext implements Context {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Object result;
	/** 目标页面，跳转到index.jsp */
	private String targetPage;
	/** 直接跳转页面 */
	private String forwardPage;
	/** 是否为redirect方式 */
	private boolean redirect = false;
	private String baseServiceUrl;
	private String module;
	private HttpMethod method;
	private String userId;
	private String userName;

	public WebContext(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public String getBaseServiceUrl() {
		return baseServiceUrl;
	}

	public void setBaseServiceUrl(String baseServiceUrl) {
		this.baseServiceUrl = baseServiceUrl;
	}

	public String getTargetPage() {
		return targetPage;
	}

	public void setTargetPage(String targetPage) {
		this.targetPage = targetPage;
		setRequestAttr("responseSection", targetPage);
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
		setRequestAttr("result", result);
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

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getParameter(String name) {
		return request.getParameter(name);
	}

	public void setRequestAttr(String name, Object value) {
		request.setAttribute(name, value);
	}

	@SuppressWarnings("unchecked")
	public <T> T getRequestAttr(String name) {
		return (T) request.getAttribute(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T getSessionAttr(String name) {
		return (T) request.getSession().getAttribute(name);
	}

	public void setSessionAttr(String name, Object value) {
		request.getSession().setAttribute(name, value);
	}

	/**
	 * @return the forwardPage
	 */
	public String getForwardPage() {
		return forwardPage;
	}

	/**
	 * @param forwardPage
	 *            the forwardPage to set
	 */
	public void setForwardPage(String forwardPage) {
		this.forwardPage = forwardPage;
	}

}
