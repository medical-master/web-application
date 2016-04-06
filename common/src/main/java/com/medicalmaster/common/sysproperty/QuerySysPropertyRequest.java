package com.medicalmaster.common.sysproperty;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.Request;

/**
 * 系统代码查询请求 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class QuerySysPropertyRequest extends Request {
	@QueryParam("categoryId")
	private String categoryId;
	
	@QueryParam("parentId")
	private String parentId;

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	/**
	 * @param parentId
	 *            the parentId to set
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

}
