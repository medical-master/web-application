package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class ActivateMasterRequest implements Context {
	@FormParam("action") 
	private String action;

	@FormParam("invitionCode") 
	private String invitionCode;
	
	@FormParam("mobilePhoneNumber")
	private String mobilePhoneNumber;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	public String getInvitionCode() {
		return invitionCode;
	}

	public void setInvitionCode(String invitionCode) {
		this.invitionCode = invitionCode;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
}
