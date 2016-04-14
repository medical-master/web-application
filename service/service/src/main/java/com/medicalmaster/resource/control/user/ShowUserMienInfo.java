package com.medicalmaster.resource.control.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.user.QueryUserMienRequest;
import com.medicalmaster.common.user.QueryUserMienResponse;
import com.medicalmaster.dal.UserMienViewPojo;
import com.xross.tools.xunit.Context;

public class ShowUserMienInfo extends UserMienCoverter
{
	protected static Logger log = LoggerFactory.getLogger(UserMienCoverter.class);
	@Override
	public Context convert(Context inputCtx) 
	{
		QueryUserMienRequest request = (QueryUserMienRequest) inputCtx;
		System.out.println(request.getUserId());
		QueryUserMienResponse response = new QueryUserMienResponse();
		
		try
		{
			List<UserMienViewPojo> userMienList = manager.queryUserMien(request);
			response.setSuccess(true);
			response.setUserMienList(userMienList);
			return response;
		}
		catch(Exception ex)
		{
			log.error("ShowInfoWorkstationInfo.convert Error:"+ex.getMessage());
			return null;
		}
	}

}
