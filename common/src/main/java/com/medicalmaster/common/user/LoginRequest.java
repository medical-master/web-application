package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class LoginRequest implements Context {
	@FormParam("action") 
	private String action;
	
	@FormParam("name") 
	private String name;
	
	@FormParam("password") 
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
