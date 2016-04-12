package com.medicalmaster.common.workstation;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.WorkstationViewPojoPojo;

public class QueryWorkstationInfoResponse extends PageResponse
{
	private WorkstationViewPojoPojo workstationInfo;
	public WorkstationViewPojoPojo getWorkstationInfo() {
		return workstationInfo;
	}
	public void setWorkstationInfo(WorkstationViewPojoPojo workstationInfo) {
		this.workstationInfo = workstationInfo;
	}
	public QueryWorkstationInfoResponse(){}
	
}
