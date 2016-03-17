package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;

public class ActivateMasterRequest extends ActionContext {
	@FormParam("invitionCode") 
	private String invitionCode;
	
	@FormParam("mobilePhoneNumber")
	private String mobilePhoneNumber;

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
