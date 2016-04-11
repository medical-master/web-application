package com.medicalmaster.resource.control.workstation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.common.workstation.QueryWorkstationInfoResponse;
import com.medicalmaster.dal.Workstation;
import com.xross.tools.xunit.Context;

public class ShowWorkstationInfo extends WorkstationCoverter 
{
	protected static Logger log = LoggerFactory.getLogger(ShowWorkstationInfo.class);

	@Override
	public Context convert(Context inputCtx)
	{
		IdRequest context = (IdRequest) inputCtx;
		Integer id = context.getId();
		QueryWorkstationInfoResponse workstationInfoResponse = new QueryWorkstationInfoResponse();
		
		try
		{
			Workstation workstation = manager.queryWorkstationInfo(id);
			workstationInfoResponse.setSuccess(true);
			workstationInfoResponse.setWorkstation(workstation);
		}
		catch(Exception ex)
		{
			log.error("ShowInfoWorkstationInfo.convert Error:"+ex.getMessage());
		}
		return null;
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站详细信息显示
 */