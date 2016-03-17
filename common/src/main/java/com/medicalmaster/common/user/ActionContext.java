package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class ActionContext implements Context {
	@FormParam("action") 
	private String action;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
}
