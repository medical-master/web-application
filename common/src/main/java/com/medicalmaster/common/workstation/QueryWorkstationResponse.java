package com.medicalmaster.common.workstation;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.WorkstationViewPojoPojo;

public class QueryWorkstationResponse extends PageResponse
{
	private List<WorkstationViewPojoPojo> workstationView;
	public QueryWorkstationResponse(){}
	
	public List<WorkstationViewPojoPojo> getWorkstationView() 
	{
		return workstationView;
	}

	public void setWorkstationView(List<WorkstationViewPojoPojo> workstationView) 
	{
		this.workstationView = workstationView;
	}
}
