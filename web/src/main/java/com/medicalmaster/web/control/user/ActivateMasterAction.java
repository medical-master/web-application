package com.medicalmaster.web.control.user;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class ActivateMasterAction implements Processor{
	private String userResourceUrl = "http://localhost:8081/service/resources/users";
	
	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
		Status s = ResourceProxy.put(context, userResourceUrl, CreateUserRequest.class, Status.class);
		context.setResult(s.getMessage());
	}
}
