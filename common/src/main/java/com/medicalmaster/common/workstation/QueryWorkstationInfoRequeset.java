package com.medicalmaster.common.workstation;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.Request;

public class QueryWorkstationInfoRequeset extends Request
{
	@QueryParam("workstationId") 
	private Integer workstationId;
	public Integer getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}
}
