package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.CommonResponse;
import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.dal.User;
import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class UpdateInfo implements Converter{
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
		CommonResponse crc = new CommonResponse();
		try{
			message = "Update infomation for user %s is success.";
			User user = new User();
			
			manager.updateInfo(user);;
			Status.success(String.format(message, ctx.getName()));
			return crc;
		} catch (SQLException e) {
			return Status.fail(ctx.getAction(), e);
		}
	}
}
