package com.medicalmaster.web.control.user;

import javax.servlet.http.HttpSession;

import com.medicalmaster.common.CommonResponse;
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
		CommonResponse cr = ResourceProxy.get(context, context.getBaseServiceUrl() + userResource, LoginRequest.class, CommonResponse.class);

		HttpSession s = context.getRequest().getSession();
		s.setAttribute("userName", cr.getResult("userName"));
		s.setAttribute("userId", cr.getResult("userId"));
		context.setResult(cr.getMessage());
		context.setTargetPage("status.jsp");
	}
}
