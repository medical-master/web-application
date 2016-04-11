package com.medicalmaster.web.view.workstation;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.common.notice.QueryNoticesResponse;
import com.medicalmaster.common.workstation.QueryWorkstationInfoResponse;
import com.medicalmaster.common.workstation.QueryWorkstationResponse;
import com.medicalmaster.dal.Notice;
import com.medicalmaster.dal.Workstation;
import com.medicalmaster.web.helper.ResourceProxy;
import com.medicalmaster.web.view.BaseView;

public class WorkstationView extends BaseView
{
	protected static Logger log = LoggerFactory.getLogger(WorkstationView.class);
	
	public WorkstationView(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		super(request, response);
	}
	
	public List<Workstation> displayWorkstations() throws SQLException 
	{
		return null;
	}
	
	public Workstation getWorkstation(int workStationId) throws IllegalArgumentException, IllegalAccessException 
	{
		QueryWorkstationResponse req = new QueryWorkstationResponse();
		QueryWorkstationResponse response = ResourceProxy.get(webContext.getBaseServiceUrl() 
				+ ResourceConstants.PATH_WORKSTATION,req,QueryWorkstationResponse.class);
		
		if (response.isSuccess()) 
		{
			List<Workstation> workstationList = response.getWorkstation();
			if (workstationList.size() > 0)
			{
				log.info("title{}", workstationList.get(0).getActivateTime());
				return workstationList.get(0);
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
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站信息显示
 */
