package com.medicalmaster.resource.control.workstation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.common.workstation.QueryWorkstationInfoRequeset;
import com.medicalmaster.common.workstation.QueryWorkstationInfoResponse;
import com.medicalmaster.dal.WorkstationViewPojoPojo;
import com.xross.tools.xunit.Context;

public class ShowWorkstationInfo extends WorkstationCoverter 
{
	protected static Logger log = LoggerFactory.getLogger(ShowWorkstationInfo.class);

	@Override
	public Context convert(Context inputCtx)
	{
		QueryWorkstationInfoRequeset request = (QueryWorkstationInfoRequeset) inputCtx;
		System.out.println(request.getWorkstationId());
		QueryWorkstationInfoResponse response = new QueryWorkstationInfoResponse();
		
		try
		{
			WorkstationViewPojoPojo workstation = manager.queryWorkstationInfo(request);
			response.setSuccess(true);
			response.setWorkstationInfo(workstation);
			return response;
		}
		catch(Exception ex)
		{
			log.error("ShowInfoWorkstationInfo.convert Error:"+ex.getMessage());
			return null;
		}
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站详细信息显示
 */