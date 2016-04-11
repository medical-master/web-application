package com.medicalmaster.common.sysresource;

import java.util.List;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.SysResource;

/**
 * 系统资源上传响应
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SysResourceUploadResponse extends Response {
	/**
	 * 上传后的系统资源
	 */
	private List<SysResource> resources;

	/**
	 * @return the resources
	 */
	public List<SysResource> getResources() {
		return resources;
	}

	/**
	 * @param resources
	 *            the resources to set
	 */
	public void setResources(List<SysResource> resources) {
		this.resources = resources;
	}

}
