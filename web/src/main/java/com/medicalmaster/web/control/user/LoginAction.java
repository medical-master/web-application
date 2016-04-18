package com.medicalmaster.web.control.user;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.LoginResponse;
import com.medicalmaster.web.bean.WebConstants;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class LoginAction implements Processor {

	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext) ctx;
		LoginResponse guir = ResourceProxy.get(context, context.getBaseServiceUrl() + ResourceConstants.PATH_USER,
				LoginRequest.class, LoginResponse.class);

		if (guir.isSuccess() && guir.getUser() != null) {
			context.setSessionAttr(WebConstants.SESSION_USER, guir.getUser());
			context.setResult(guir.getMessage());
			context.setTargetPage("home.jsp");
		} else {
			context.setResult(guir.getMessage());
			context.setForwardPage("user/login.jsp");
		}
	}
}
