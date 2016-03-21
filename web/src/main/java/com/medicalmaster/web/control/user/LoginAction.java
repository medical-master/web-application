package com.medicalmaster.web.control.user;

import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class LoginAction implements Processor {
	private String userResource = "users";
	
	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
		GetUserInfoResponse guir = ResourceProxy.get(context, context.getBaseServiceUrl() + userResource, LoginRequest.class, GetUserInfoResponse.class);

		context.setSessionAttr("user", guir.getUser());
		context.setResult(guir.getMessage());
		context.setTargetPage("status.jsp");
	}
}
