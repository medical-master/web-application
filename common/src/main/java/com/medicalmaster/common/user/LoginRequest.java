package com.medicalmaster.common.user;

import javax.ws.rs.QueryParam;

import com.xross.tools.xunit.Context;

public class LoginRequest implements Context {
	@QueryParam("action") 
	private String action;

	@QueryParam("name") 
	private String name;
	
	@QueryParam("password") 
	private String password;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	} 
	
}
