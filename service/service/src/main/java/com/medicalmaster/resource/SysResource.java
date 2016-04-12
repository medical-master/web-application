package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.bean.request.HttpServletContext;
import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.common.sysproperty.QuerySysPropertyResponse;
import com.medicalmaster.common.sysresource.SysResourceUploadRequest;
import com.medicalmaster.common.sysresource.SysResourceUploadResponse;
import com.xross.tools.xunit.XunitFactory;

/**
 * 系统资源
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path(ResourceConstants.PATH_SYS_RESOURCE)
public class SysResource extends Resources {
	/**
	 * 
	 */
	public SysResource() {
		try {
			factory = XunitFactory.load("sysResource.xunit");
			converterId = "sysResource branch";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@POST
	@Path("/upload")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public SysResourceUploadResponse upload(@BeanParam SysResourceUploadRequest request,
			@Context HttpServletRequest httpServletRequest) {
		HttpServletContext context = new HttpServletContext();
		context.setAction("upload");
		context.setHttpServletRequest(httpServletRequest);
		context.setInputContext(request);

		return handle(context, context.getAction());
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getInfo/{resourceId}")
	public QuerySysPropertyResponse querySysProperty(@PathParam("resourceId") Integer id) {
		IdRequest request = new IdRequest();
		request.setAction("querySysProperty");
		request.setId(id);

		return handle(request, request.getAction());
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/download/{resourceId}")
	public void download(@PathParam("resourceId") Integer id, @Context HttpServletResponse response) {
		HttpServletContext context = new HttpServletContext();
		context.setAction("download");
		context.setHttpServletResponse(response);
		IdRequest request = new IdRequest();
		request.setId(id);
		context.setInputContext(request);

		handle(context, context.getAction());
	}
}
