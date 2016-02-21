package com.medicalmaster.web.control;

import java.sql.SQLException;

import com.medicalmaster.domain.user.UserManager;
import com.medicalmaster.web.resource.response.Status;
import com.medicalmaster.web.resource.resquest.CreateUserRequest;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class CommonRegister implements Converter{
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
		
		try {
			String message = "Register user %s success";
			manager.register(ctx.getType(), ctx.getName(), ctx.getAuthentication(), ctx.getEmail(), ctx.getMobilePhoneNumber());
			return Status.success(String.format(message, ctx.getName()));
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.fail(e.getMessage());
		}
	}

}
