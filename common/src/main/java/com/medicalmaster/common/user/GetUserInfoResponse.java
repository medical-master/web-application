package com.medicalmaster.common.user;

import com.medicalmaster.dal.EdsUser;
import com.xross.tools.xunit.Context;

public class GetUserInfoResponse implements Context {
	private EdsUser user;
	private boolean success;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public EdsUser getUser() {
		return user;
	}

	public void setUser(EdsUser user) {
		this.user = user;
	}
	
}
