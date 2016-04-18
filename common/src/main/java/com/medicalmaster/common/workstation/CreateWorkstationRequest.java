package com.medicalmaster.common.workstation;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class CreateWorkstationRequest implements Context
{
	@FormParam("action") 
	private String action;
	
	@FormParam("name")
	private String name;
	
	@FormParam("keywords")
	private String keywords;
	
	@FormParam("userId")
	private String userId;
	
	@FormParam("summery")
	private String summery;
	
	@FormParam("description")
	private String description;
	
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getSummery() {
		return summery;
	}

	public void setSummery(String summery) {
		this.summery = summery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
