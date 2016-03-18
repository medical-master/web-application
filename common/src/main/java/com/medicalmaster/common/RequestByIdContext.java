package com.medicalmaster.common;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class RequestByIdContext implements Context {
	@FormParam("action") 
	private String action;

	@FormParam("action") 
	private Integer id;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
