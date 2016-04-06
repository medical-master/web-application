package com.medicalmaster.common;

import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

import com.xross.tools.xunit.Context;

/**
 * 请求基础类 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class Request implements Context {
	@FormParam("action")
	@QueryParam("action")
	protected String action;

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

}
