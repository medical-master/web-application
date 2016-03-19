package com.medicalmaster.web.control.user;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class RegisterUserAction implements Processor {
	private String userResource = "users";
	
	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
		String errorMsg = validate(context);
		Status s;
		if(errorMsg == null)
			s = ResourceProxy.post(context, context.getBaseServiceUrl() + userResource, CreateUserRequest.class, Status.class);
		else
			s = Status.fail(errorMsg);
		context.setResult(s.getMessage());
		context.setTargetPage("status.jsp");
	}
	
	private String validate(WebContext ctx) {
		if(!ctx.getParameter("password").equals(ctx.getParameter("passwordConfirm")))
			return "The password values not same";
		return null;
	}
}
