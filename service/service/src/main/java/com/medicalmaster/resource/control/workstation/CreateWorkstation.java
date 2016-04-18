package com.medicalmaster.resource.control.workstation;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.workstation.CreateWorkstationRequest;
import com.medicalmaster.dal.Workstation;
import com.xross.tools.xunit.Context;

public class CreateWorkstation extends WorkstationCoverter
{
	protected static Logger logger = LoggerFactory.getLogger(CreateWorkstation.class);
	@Override
	public Context convert(Context inputCtx)
	{
		CreateWorkstationRequest ctx = (CreateWorkstationRequest)inputCtx;
		String message = "Register user %s success";
		
		try
		{
			Workstation workstation = extract(ctx);
			manager.insertWorkstation(workstation);
			return Status.success(String.format(message, ctx.getName()));
		}
		catch (SQLException e) 
		{
			return Status.fail(ctx.getAction(), e);
		}
	}
	
	private Workstation extract(CreateWorkstationRequest req) 
	{
		Workstation workstation = new Workstation();
		workstation.setName(req.getName());
		workstation.setKeywords(req.getKeywords());
		workstation.setUserId(Integer.parseInt(req.getUserId()));
		workstation.setSummery(req.getSummery());
		workstation.setDescription(req.getDescription());
		return workstation;
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    创建工作站信息
 */