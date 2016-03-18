package com.medicalmaster.common;

import com.xross.tools.xunit.Context;

public class CommonResponse implements Context {
	private boolean success;
	private int statusCode;
	private String message;
	private Throwable exception;
	private Object result;
	
	public CommonResponse(){}
	
	public static CommonResponse success(int statusCode, String message, Object result) {
		CommonResponse crc = new CommonResponse();
		crc.success = true;
		crc.statusCode = statusCode;
		crc.message = message;
		crc.result = result;
		return crc;
	}
	
	public static CommonResponse fail(int statusCode, String message, Throwable exception) {
		CommonResponse crc = new CommonResponse();
		crc.success = false;
		crc.statusCode = statusCode;
		crc.message = message;
		crc.exception = exception;
		return crc;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Throwable getException() {
		return exception;
	}
	public void setException(Throwable exception) {
		this.exception = exception;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
