package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.sysproperty.QuerySysPropertyResponse;
import com.medicalmaster.resource.control.sysproperty.QuerySysPropertyRequest;
import com.xross.tools.xunit.XunitFactory;

/**
 * 
 * Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
@Resource
@Path("/sysproperty")
public class SysPropertyResource extends Resources {
	static {
		try {
			factory = XunitFactory.load("sys_property.xunit");
			converterId = "sys property branch";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("{categoryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public QuerySysPropertyResponse querySysProperties(@PathParam("categoryId") Integer categoryId) {
		QuerySysPropertyRequest request = new QuerySysPropertyRequest();
		request.setAction("query");
		request.setCategoryId(categoryId);
		request.setParentId(null);

		return handle(request, request.getAction());
	}

	
	@GET
	@Path("{categoryId}/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public QuerySysPropertyResponse querySysProperties(@PathParam("categoryId") Integer categoryId,
			@PathParam("parentId") Integer parentId) {
		QuerySysPropertyRequest request = new QuerySysPropertyRequest();
		request.setAction("query");
		request.setCategoryId(categoryId);
		request.setParentId(parentId);

		return handle(request, request.getAction());
	}

}
