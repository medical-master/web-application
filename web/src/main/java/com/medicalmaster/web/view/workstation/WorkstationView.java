package com.medicalmaster.web.view.workstation;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.workstation.QueryWorkstationInfoRequeset;
import com.medicalmaster.common.workstation.QueryWorkstationInfoResponse;
import com.medicalmaster.common.workstation.QueryWorkstationRequest;
import com.medicalmaster.common.workstation.QueryWorkstationResponse;
import com.medicalmaster.dal.WorkstationViewPojoPojo;
import com.medicalmaster.web.helper.ResourceProxy;
import com.medicalmaster.web.view.BaseView;

public class WorkstationView extends BaseView
{
	protected static Logger log = LoggerFactory.getLogger(WorkstationView.class);
	
	public WorkstationView(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super(request, response);
	}
	
	public List<WorkstationViewPojoPojo> displayWorkstations() throws SQLException, IllegalArgumentException, IllegalAccessException 
	{
		QueryWorkstationRequest req = new QueryWorkstationRequest();
		QueryWorkstationResponse response = ResourceProxy.get(webContext.getBaseServiceUrl() 
				+ ResourceConstants.PATH_WORKSTATION,req,QueryWorkstationResponse.class);
		
		if (response.isSuccess()) 
		{
			List<WorkstationViewPojoPojo> workstationList = response.getWorkstationView();
			if (workstationList.size() > 0)
			{
				return workstationList;
			}
			else 
			{
				return null;
			}
		}
		else 
		{
			return null;
		}
	}
	
	public WorkstationViewPojoPojo getWorkstationInfo(String id) throws IllegalArgumentException, IllegalAccessException 
	{
		QueryWorkstationInfoRequeset req = new QueryWorkstationInfoRequeset();
		req.setAction("showDtlInfo");
		req.setWorkstationId(Integer.parseInt(id.toString()));
		QueryWorkstationInfoResponse response = ResourceProxy.get(webContext.getBaseServiceUrl() 
				+ ResourceConstants.PATH_WORKSTATION,req,QueryWorkstationInfoResponse.class);
		
		if (response.isSuccess()) 
		{
			WorkstationViewPojoPojo workstationViewPojoPojo = response.getWorkstationInfo();
			return workstationViewPojoPojo;
		}
		else 
		{
			return null;
		}
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站信息显示
 */
