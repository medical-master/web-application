package com.medicalmaster.common.workstation;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.WorkstationViewPojoPojo;

public class QueryWorkstationResponse extends PageResponse
{
	private List<WorkstationViewPojoPojo> pojos;
	
	public QueryWorkstationResponse(){}
	public List<WorkstationViewPojoPojo> getPojos() 
	{
		return pojos;
	}
	
	public void setPojos(List<WorkstationViewPojoPojo> pojos) 
	{
		this.pojos = pojos;
	}
}
