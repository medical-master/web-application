package com.medicalmaster.resource;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.RequestByIdContext;
import com.medicalmaster.common.Status;
import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.user.ActivateMasterRequest;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.UpdateUserRequest;

@Resource
@Path(ResourceConstants.PATH_USER)
public class UserResource extends Resources {
	
	public UserResource() {
		super("user.xunit", "user management");
	}

	@GET
	@Path("{userid}")
	@Produces("text/plain")
	public GetUserInfoResponse getUser(@PathParam("userid") int userId) throws SQLException {
		RequestByIdContext req = new RequestByIdContext();
		req.setId(userId);
		req.setAction("get user");
		return handle(req, req.getAction());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public GetUserInfoResponse login(@BeanParam LoginRequest loginRequest) {
		return handle(loginRequest, loginRequest.getAction());
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Status createUser(@BeanParam CreateUserRequest createUserRequest) {
		return handle(createUserRequest, createUserRequest.getAction());
	}

	@DELETE
	@Path("{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Status deleteUser(@PathParam("userid") int userId) {
		RequestByIdContext req = new RequestByIdContext();
		req.setId(userId);
		req.setAction("remove");
		return handle(req, req.getAction());
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Status activateMaster(@BeanParam ActivateMasterRequest activateMasterRequest) {
		return handle(activateMasterRequest, activateMasterRequest.getAction());
	}

	@PUT
	@Path("{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public GetUserInfoResponse updateInfomation(@BeanParam UpdateUserRequest updateUserRequest) {
		return handle(updateUserRequest, updateUserRequest.getAction());
	}
}
