package com.medicalmaster.resource.control.sysproperty;

import com.xross.tools.xunit.Context;

/**
 * 系统代码查询请求 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class QuerySysPropertyRequest implements Context {
	protected String action;

	private Integer categoryId;

	private Integer parentId;

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

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
