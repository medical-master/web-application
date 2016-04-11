package com.medicalmaster.common.workstation;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.Workstation;

public class QueryWorkstationInfoResponse extends PageResponse
{
	private Workstation workstation;

	public QueryWorkstationInfoResponse(){}
	
	public Workstation getWorkstation() 
	{
		return workstation;
	}

	public void setWorkstation(Workstation workstation) 
	{
		this.workstation = workstation;
	}
}
