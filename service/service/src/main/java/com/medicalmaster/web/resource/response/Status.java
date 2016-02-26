package com.medicalmaster.web.resource.response;

import com.xross.tools.xunit.Context;

public class Status implements Context {
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	
	private String code;
	private String message;

	public Status(){}
	
	public Status(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public static Status success(String message) {
		return new Status(SUCCESS, message);
	}

	public static Status fail(String message) {
		return new Status(FAIL, message);
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
