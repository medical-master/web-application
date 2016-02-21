package com.medicalmaster.web.resource.resquest;

import javax.ws.rs.FormParam;

import com.medicalmaster.domain.user.UserType;
import com.xross.tools.xunit.Context;

public class CreateUserRequest implements Context {
	@FormParam("action") 
	private String action;
	
	@FormParam("name") 
	private String name;
	
	@FormParam("email") 
	private String email; 
	
	@FormParam("authentication") 
	private String authentication;
	
	@FormParam("type") 
	private UserType type;
	
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

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
}
