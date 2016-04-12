package com.medicalmaster.common.workstation;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryWorkstationListRequest extends PageRequest {
	@QueryParam("status")
	private Integer status;

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
