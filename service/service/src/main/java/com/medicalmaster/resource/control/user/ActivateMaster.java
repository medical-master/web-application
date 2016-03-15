package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class ActivateMaster implements Converter{
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
		UpdateUserRequest ctx = (UpdateUserRequest)context;
		String message = "undefined";
		
		try{
			message = "Master %s is activated";
			manager.activateMaster(ctx.getInviteCode(), ctx.getAuthentication(), ctx.getMobilePhoneNumber());
			return Status.success(String.format(message, ctx.getName()));
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.fail(message);
		}
	}
}