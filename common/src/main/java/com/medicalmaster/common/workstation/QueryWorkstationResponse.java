package com.medicalmaster.common.workstation;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.Workstation;

public class QueryWorkstationResponse extends PageResponse
{
	private List<Workstation> workstation;
	
	public QueryWorkstationResponse(){}

	public List<Workstation> getWorkstation() 
	{
		return workstation;
	}

	public void setWorkstation(List<Workstation> workstation) 
	{
		this.workstation = workstation;
	}
}
