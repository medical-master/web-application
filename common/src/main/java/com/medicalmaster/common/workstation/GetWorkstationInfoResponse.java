package com.medicalmaster.common.workstation;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.User;
import com.medicalmaster.dal.WorkstationViewDao;

public class GetWorkstationInfoResponse extends PageResponse
{
	private WorkstationViewDao workstationViewDao;
	private boolean success;
	private String message;
	
	public WorkstationViewDao getWorkstationViewDao() 
	{
		return workstationViewDao;
	}

	public void setWorkstationViewDao(WorkstationViewDao workstationViewDao) 
	{
		this.workstationViewDao = workstationViewDao;
	}

	public boolean isSuccess() 
	{
		return success;
	}
	
	public void setSuccess(boolean success) 
	{
		this.success = success;
	}
	
	public String getMessage() 
	{
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
