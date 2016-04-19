package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.request.get.PageRequest;
import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.common.workstation.CreateWorkstationRequest;
import com.medicalmaster.common.workstation.QueryWorkstationInfoRequeset;
import com.medicalmaster.common.workstation.QueryWorkstationInfoResponse;
import com.medicalmaster.common.workstation.QueryWorkstationListRequest;
import com.medicalmaster.common.workstation.QueryWorkstationListResponse;
import com.medicalmaster.common.workstation.QueryWorkstationResponse;
import com.medicalmaster.common.workstation.UpdateWorkstationRequest;

@Resource
@Path(ResourceConstants.PATH_WORKSTATION)
public class WorkstationResource extends Resources 
{
	public WorkstationResource() 
	{
		super("workstation.xunit", "workstation management");
	}

	/**
	 * 查询工作站信息
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public QueryWorkstationResponse showInfo(@BeanParam PageRequest request) 
	{
		request.setAction("showInfo");
		return handle(request, request.getAction());
	}

	/***
	 * 查询工作站列表
	 * @param request
	 * @return
	 */
	@GET
	@Path("/list")
	@Consumes(MediaType.APPLICATION_JSON)
	public QueryWorkstationListResponse queryWorkstationList(@BeanParam QueryWorkstationListRequest request) 
	{
		request.setAction("queryWorkstationList");
		return handle(request, request.getAction());
	}

	/**
	 * 查询工作站详细信息
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dtlInfo")
	public QueryWorkstationInfoResponse showDtlInfo(@BeanParam QueryWorkstationInfoRequeset request) 
	{
		request.setAction("showDtlInfo");
		return handle(request, request.getAction());
	}
	
	/**
	 * 创建工作站
	 * @param request
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/createWorkstation")
	public Status createWorkstation(@BeanParam CreateWorkstationRequest request)
	{
		request.setAction("create");
		return handle(request, request.getAction());
	}
	
	/**
	 * 修改工作站信息
	 */
	@PUT
	@Path("{workstationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status updateInfomation(@BeanParam UpdateWorkstationRequest request)
	{
		request.setAction("create");
		return handle(request, request.getAction());
	}
	
	/**
	 * 根据用户ID获取自己对应的工作站信息
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/dtlInfo")
	public QueryWorkstationInfoResponse query(@BeanParam QueryWorkstationInfoRequeset request) 
	{
		request.setAction("showDtlInfo");
		return handle(request, request.getAction());
	}
	
}
