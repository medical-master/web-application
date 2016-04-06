package com.medicalmaster.common;

import com.xross.tools.xunit.Context;

/**
 * 响应
 * 
 * Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class Response implements Context {
	/** 处理结果-是否成功 */
	private boolean success;

	/** 提示信息 */
	private String message;

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success
	 *            the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
