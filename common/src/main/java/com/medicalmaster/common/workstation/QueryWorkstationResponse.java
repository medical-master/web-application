package com.medicalmaster.common.workstation;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.dal.Notice;
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
