package com.medicalmaster.web.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.web.resource.resquest.CreateUserRequest;

@Resource
@Path("/")
public class WebFacade {
//	@GET
//	@Path("resources")
//	@Produces("text/plain")
//    public String getUser(@PathParam("username") String userName) {
//		return userName;
//	}
//
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//    public CreateUserRequest createUser(@BeanParam CreateUserRequest userReq) {
//		return userReq;
//	}
//	
//	@PUT
//	@Produces(MediaType.APPLICATION_JSON)
//    public CreateUserRequest createUser(@BeanParam CreateUserRequest userReq) {
//		return userReq;
//	}
//	
//	@DELETE
//	@Produces(MediaType.APPLICATION_JSON)
//    public CreateUserRequest createUser(@BeanParam CreateUserRequest userReq) {
//		return userReq;
//	}
}