package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.ActivateMasterRequest;
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
		ActivateMasterRequest ctx = (ActivateMasterRequest)context;
		String message = "undefined";
		
		try{
			message = "Activated by code %s. The default password is %s";
			manager.activateMaster(ctx.getInvitionCode(), "123456", ctx.getMobilePhoneNumber());
			return Status.success(String.format(message, ctx.getInvitionCode(), "123456"));
		} catch (SQLException e) {
			e.printStackTrace();
			return Status.fail(String.format("Activated by code %s is faild", ctx.getInvitionCode()), e);
		}
	}
}