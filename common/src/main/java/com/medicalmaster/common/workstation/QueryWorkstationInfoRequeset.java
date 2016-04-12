package com.medicalmaster.common.workstation;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.Request;

public class QueryWorkstationInfoRequeset extends Request
{
	@PathParam("action")
	private String action;
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@QueryParam("workstationId") 
	private Integer workstationId;
	public Integer getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}
}
