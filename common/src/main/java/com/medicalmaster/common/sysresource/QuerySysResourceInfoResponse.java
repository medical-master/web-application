package com.medicalmaster.common.sysresource;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.SysResource;

/**
 * 系统资源查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QuerySysResourceInfoResponse extends Response {
	/**
	 * 系统资源
	 */
	private SysResource resource;

	/**
	 * @return the resource
	 */
	public SysResource getResource() {
		return resource;
	}

	/**
	 * @param resource
	 *            the resource to set
	 */
	public void setResource(SysResource resource) {
		this.resource = resource;
	}

}
