package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class CreateUserRequest implements Context {
	@FormParam("action") 
	private String action;
	
	@FormParam("name") 
	private String name;
	
	@FormParam("email") 
	private String email; 
	
	@FormParam("password") 
	private String password;
	
	@FormParam("type") 
	private String type;
	
	@FormParam("mobilePhoneNumber")
	private String mobilePhoneNumber;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
}
