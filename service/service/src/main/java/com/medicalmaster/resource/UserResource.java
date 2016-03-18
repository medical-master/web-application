package com.medicalmaster.resource;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.CommonResponse;
import com.medicalmaster.common.ExceptionWraper;
import com.medicalmaster.common.RequestByIdContext;
import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.ActivateMasterRequest;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.XunitFactory;

@Resource
@Path("/users")
public class UserResource {
	//TODO create common artifact and store constants
	public static final String INVITE_MASTER = "inviteMaster";
	public static final String ACTIVATE_MASTER = "activateMaster";
	public static final String REGISTER = "register";
	
	private static XunitFactory factory;
	static {
		try {
			factory = XunitFactory.load("user.xunit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("{userid}")
	@Produces("text/plain")
    public CommonResponse getUser(@PathParam("userid") int userId) throws SQLException {
		RequestByIdContext req = new RequestByIdContext();
		req.setId(userId);
		req.setAction("get user");
		return handle(req, req.getAction());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public CommonResponse login(@BeanParam LoginRequest loginRequest) {
		return handle(loginRequest, loginRequest.getAction());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
    public Status createUser(@BeanParam CreateUserRequest createUserRequest) {
		return handle(createUserRequest, createUserRequest.getAction());
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
    public Status activateMaster(
    		@BeanParam ActivateMasterRequest activateMasterRequest) {
		return handle(activateMasterRequest, activateMasterRequest.getAction());
	}

	@PUT
	@Path("{userid}")
	@Produces(MediaType.APPLICATION_JSON)
    public Status updateInfomation(
    		@BeanParam UpdateUserRequest updateUserRequest) {
		return handle(updateUserRequest, updateUserRequest.getAction());
	}

	private <T> T handle(Context ctx, String message) {
		try {
			return (T)factory.getConverter("user management").convert(ctx);
		} catch (Throwable e) {
			ExceptionWraper.wrap(message, e);
			return null;
		}
	}
}
