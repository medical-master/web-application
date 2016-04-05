package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.dal.EdsUser;
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
		GetUserInfoResponse lr = new GetUserInfoResponse();
		try{
			message = "Login for user %s is success.";
			EdsUser user = manager.getUser(ctx.getName(), ctx.getPassword());
			if(user == null) {
				lr.setSuccess(false);
				lr.setMessage("The user name or password is incorrect");
				return lr;
			}
				
			lr.setUser(user);
			lr.setMessage(String.format(message, user.getName()));
			return lr;
		} catch (SQLException e) {
			lr.setSuccess(false);
			return lr;
		}
	}
}
