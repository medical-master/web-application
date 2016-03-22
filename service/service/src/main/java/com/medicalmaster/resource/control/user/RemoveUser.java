package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.RequestByIdContext;
import com.medicalmaster.common.Status;
import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class RemoveUser implements Converter{
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
		RequestByIdContext ctx = (RequestByIdContext)context;
		
		try{
			String message = "Remove user %d is %s";
			int count = manager.removeUser(ctx.getId());
			if(count == 0)
				return Status.fail(String.format(message, ctx.getId(), "success"));
			else
				return Status.success(String.format(message, ctx.getId(), "fail"));
		} catch (SQLException e) {
			return Status.fail(ctx.getAction(), e);
		}
	}
}
