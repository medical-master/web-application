package com.medicalmaster.common.user;

import com.medicalmaster.dal.User;
import com.xross.tools.xunit.Context;

public class LoginResponse implements Context {
	private User user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
