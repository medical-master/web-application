package com.medicalmaster.common.trainmaterial;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

public class QueryTrainMaterialRequest extends PageRequest
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
