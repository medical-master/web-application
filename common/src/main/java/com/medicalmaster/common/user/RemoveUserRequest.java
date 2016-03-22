package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

import com.xross.tools.xunit.Context;

public class RemoveUserRequest implements Context {
	@FormParam("action") 
	private String action;

	@PathParam("userId") 
	private String userId;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
