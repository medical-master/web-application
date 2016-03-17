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

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.ActivateMasterRequest;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.dal.User;
import com.medicalmaster.domain.user.UserManager;
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
    public User getUser(@PathParam("userid") int userId) throws SQLException {
		return new UserManager().getUser(userId);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
    public User login(@BeanParam LoginRequest loginRequest) {
		return null;
//		return new UserManager().getUser(loginRequest.getName(), loginRequest.getPassword());
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

	private Status handle(Context ctx, String message) {
		try {
			return (Status)factory.getConverter("user management").convert(ctx);
		} catch (Throwable e) {
			e.printStackTrace();
			return Status.fail(message, e);
		}
	}
}
