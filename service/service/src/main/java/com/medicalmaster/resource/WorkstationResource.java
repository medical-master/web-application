package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.workstation.QueryWorkstationRequest;
import com.medicalmaster.common.workstation.QueryWorkstationResponse;
import com.xross.tools.xunit.XunitFactory;

@Resource
@Path("/workstation")
public class WorkstationResource extends Resources
{
	static 
	{
		try
		{
			factory = XunitFactory.load("workstation.xunit");
			converterId = "workstation management";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 查询工作站信息
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public QueryWorkstationResponse showInfo(@BeanParam QueryWorkstationRequest request) 
	{
		request.setAction("showInfo");
		return handle(request, request.getAction());
	}
}
