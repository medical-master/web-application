package com.medicalmaster.web.resource.proxy;

import com.medicalmaster.web.resource.HttpMethod;
import com.xross.tools.xunit.Context;

public class ResourceProxyContext implements Context {
	private String resource;
	private HttpMethod method;
	private String userId;
	private String userName;

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
