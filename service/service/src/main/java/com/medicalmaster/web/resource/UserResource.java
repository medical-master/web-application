package com.medicalmaster.web.resource;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.domain.user.UserManager;
import com.medicalmaster.web.resource.response.Status;
import com.medicalmaster.web.resource.resquest.CreateUserRequest;
import com.xross.tools.xunit.XunitFactory;

@Resource
@Path("/users")
public class UserResource {
	//TODO create common artifact and store constants
	public static final String INVITE_MASTER = "inviteMaster";
	public static final String ACTIVATE_MASTER = "activateMaster";
	public static final String REGISTER = "register";
	
	private static UserManager manager; 

	// TODO shall we optimize here?
	static {
		try {
			manager = new UserManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("{username}")
	@Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
		return userName;
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
    public Status createUser(@BeanParam CreateUserRequest createUser) {
		String message = "undefined";
		try {
			XunitFactory factory = XunitFactory.load("user.xunit");
			return (Status)factory.getConverter("register user").convert(createUser);
		} catch (Throwable e) {
			e.printStackTrace();
			return Status.fail(message);
		}
	}
/*
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
    public Status updateUser(
    		@FormParam("action") String action, 
    		@FormParam("inviteCode") String inviteCode, 
    		@FormParam("authentication") String authentication,
    		@FormParam("mobilePhoneNumber") String mobilePhoneNumber) {

		try {
			manager.activateMaster(inviteCode, authentication, mobilePhoneNumber);
			return Status.success("Activate master");
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.fail("Activate master");
		}
	}
	*/
}
