package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.LoginResponse;
import com.medicalmaster.dal.User;
import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class LoginUser implements Converter{
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
		LoginRequest ctx = (LoginRequest)context;
		String message = "undefined";
		LoginResponse lr = new LoginResponse();
		try{
			message = "Login for user %s is success.";
			User user = manager.getUser(ctx.getName(), ctx.getPassword());
			lr.setUser(user);
			lr.setMessage(String.format(message, user.getName()));
			return lr;
		} catch (SQLException e) {
			lr.setSuccess(false);
			return lr;
		}
	}
}
