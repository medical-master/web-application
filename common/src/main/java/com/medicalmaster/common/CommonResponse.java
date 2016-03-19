package com.medicalmaster.common;

import java.util.HashMap;
import java.util.Map;

import com.xross.tools.xunit.Context;

public class CommonResponse implements Context {
	private boolean success;
	private int statusCode;
	private String message;
	private Throwable exception;
	private Map<String, String> result;
	
	public CommonResponse(){}
	
	public static CommonResponse success(int statusCode, String message, Map<String, String> result) {
		CommonResponse crc = new CommonResponse();
		crc.success = true;
		crc.statusCode = statusCode;
		crc.message = message;
		crc.result = result;
		return crc;
	}

	public static CommonResponse success(int statusCode, String message) {
		CommonResponse crc = new CommonResponse();
		crc.success = true;
		crc.statusCode = statusCode;
		crc.message = message;
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
	public Map<String, String> getResult() {
		return result;
	}
	public void setResult(Map<String, String> result) {
		this.result = result;
	}
	public void setResult(String name, String value) {
		if(result == null)
			result = new HashMap<String, String>();
		result.put(name, value);
	}
	public String getResult(String name) {
		return result.get(name);
	}
}
