package com.medicalmaster.common.workstation;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

public class QueryWorkstationRequest extends PageRequest
{
	/** 状态 */
	@QueryParam("status")
	private Integer status;

	/**
	 * @return the status
	 */
	public Integer getStatus() 
	{
		return status;
	}

	/**
	 * @param status  the status to set
	 */
	public void setStatus(Integer status) 
	{
		this.status = status;
	}
}
