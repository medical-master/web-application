package com.medicalmaster.web.resource.resquest;

import javax.ws.rs.FormParam;

public class CreateUserRequest {
	@FormParam("action")
	private String action;

	@FormParam("name")
	private String name;
	
	@FormParam("cityID")
	private String cityId;
	

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
	public String getCityId() {
		return cityId;
	}
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}
	
}
