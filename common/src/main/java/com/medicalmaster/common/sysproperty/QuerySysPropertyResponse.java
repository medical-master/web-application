package com.medicalmaster.common.sysproperty;

import java.util.List;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.SysProperty;

/**
 * 系统代码查询响应 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class QuerySysPropertyResponse extends Response {
	/** 系统代码集 */
	private List<SysProperty> properties;

	/**
	 * @return the properties
	 */
	public List<SysProperty> getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(List<SysProperty> properties) {
		this.properties = properties;
	}

}
