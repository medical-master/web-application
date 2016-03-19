package com.medicalmaster.web.control.user;

import com.medicalmaster.common.CommonResponse;
import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class LoginAction implements Processor {
	private String userResourceUrl = "http://localhost:8081/service/resources/users";
	
	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
		CommonResponse s = ResourceProxy.get(context, userResourceUrl, LoginRequest.class, CommonResponse.class);
		context.setResult(s.getMessage());
		context.setTargetPage("status.jsp");
	}
}
