package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.domain.user.UserManager;
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
			return Status.fail(ctx.getAction(), e);
		}
	}

}
