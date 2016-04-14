package com.medicalmaster.common.user;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.Request;
import com.medicalmaster.common.request.get.PageRequest;

public class QueryUserMienRequest extends PageRequest
{
	@QueryParam("userId") 
	private Integer userId;

	public Integer getUserId() 
	{
		return userId;
	}

	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}
}
