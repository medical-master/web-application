package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.workstation.QueryWorkstationInfoRequeset;
import com.medicalmaster.common.workstation.QueryWorkstationInfoResponse;
import com.medicalmaster.common.workstation.QueryWorkstationRequest;
import com.medicalmaster.common.workstation.QueryWorkstationResponse;
import com.xross.tools.xunit.XunitFactory;

@Resource
@Path(ResourceConstants.PATH_WORKSTATION)
public class WorkstationResource extends Resources {
	/**
	 * 
	 */
	public WorkstationResource() {
		try {
			factory = XunitFactory.load("workstation.xunit");
			converterId = "workstation management";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询工作站信息
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public QueryWorkstationResponse showInfo(@BeanParam QueryWorkstationRequest request) 
	{
		request.setAction("showInfo");
		return handle(request, request.getAction());
	}
		
	/**
	 * 查询工作站详细信息
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{action}")
	public QueryWorkstationInfoResponse showDtlInfo(@BeanParam QueryWorkstationInfoRequeset request) 
	{
		request.setAction("showDtlInfo");
		return handle(request, request.getAction());
	}
}
