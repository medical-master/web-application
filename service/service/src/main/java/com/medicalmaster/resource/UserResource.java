package com.medicalmaster.resource;

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
import com.medicalmaster.common.user.UpdateUserRequest;
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
	
	private static UserManager manager; 
	private static XunitFactory factory;
	// TODO shall we optimize here?
	static {
		try {
			manager = new UserManager();
			factory = XunitFactory.load("user.xunit");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("{userid}")
	@Produces("text/plain")
    public String getUser(@PathParam("userid") String userId) {
		return userId;
	}

	@GET
	@Produces("text/plain")
    public String login(@PathParam("userid") String userId) {
		return userId;
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
    		@PathParam("userid") String userId,
    		@BeanParam UpdateUserRequest updateUserRequest) {
		return handle(updateUserRequest, updateUserRequest.getAction());
	}
	
	// TODO add common action to base context
	private Status handle(Context ctx, String message) {
		try {
			XunitFactory factory = XunitFactory.load("user.xunit");
			return (Status)factory.getConverter("user management").convert(ctx);
		} catch (Throwable e) {
			e.printStackTrace();
			return Status.fail(message, e);
		}
	}
}
