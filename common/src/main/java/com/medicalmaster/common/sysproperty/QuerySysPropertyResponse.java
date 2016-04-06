package com.medicalmaster.common.sysproperty;

import java.util.List;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.SystemProperty;

/**
 * 系统代码查询响应 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class QuerySysPropertyResponse extends Response {
	/** 系统代码集 */
	private List<SystemProperty> properties;

	/**
	 * @return the properties
	 */
	public List<SystemProperty> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(List<SystemProperty> properties) {
		this.properties = properties;
	}

}
