package com.medicalmaster.web.control;

import java.sql.SQLException;

import com.medicalmaster.domain.user.UserManager;
import com.medicalmaster.web.resource.response.Status;
import com.medicalmaster.web.resource.resquest.CreateUserRequest;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class InviteMaster implements Converter{
	private static UserManager manager; 
	static {
		try {
			manager = new UserManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Context convert(Context context) {
		CreateUserRequest ctx = (CreateUserRequest)context;
		String message = "undefined";
		
		try{
			message = "The generated invite code for master %s is %s";
			String inviteCode = manager.inviteMaster(ctx.getName(), ctx.getEmail(), ctx.getMobilePhoneNumber());
			return Status.success(String.format(message, ctx.getName(), inviteCode));
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.fail(message);
		}
	}
}
