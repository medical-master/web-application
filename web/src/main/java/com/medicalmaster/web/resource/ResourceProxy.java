package com.medicalmaster.web.resource;

import java.util.Map;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.medicalmaster.web.resource.resquest.CreateUserRequest;

@Resource
@Path("/resources")
public class ResourceProxy {
	@GET
	@Path("resources")
	@Produces("text/html")
	@Template("index.foo")
    public String getResource(@Context UriInfo ui, @Context HttpHeaders hh, @Context Request request) {
	    MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
	    MultivaluedMap<String, String> pathParams = ui.getPathParameters();
	    MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
	    Map<String, Cookie> cc = hh.getCookies();
	    return "jerry";
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes("application/x-www-form-urlencoded")
    public String postResource(MultivaluedMap<String, String> formParams) {
		return null;
	}
	
	@PUT
	@Produces(MediaType.TEXT_HTML)
    public String putResource(@BeanParam CreateUserRequest userReq) {
		return null;
	}
	
	@DELETE
	@Produces(MediaType.TEXT_HTML)
    public String deleteResource(@BeanParam CreateUserRequest userReq) {
		return null;
	}
	
//	@GET
//	@Path("resources")
//	@Produces("text/html")
//	public Response post(String content) {
//		URI createdUri = "";
//		create(content);
//		return Response.created(createdUri).build();
//	}
}