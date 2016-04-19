package com.medicalmaster.web.control.user;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.web.bean.WebConstants;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class UpdateUserInfoAction implements Processor {
	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext) ctx;
		GetUserInfoResponse guir = ResourceProxy.put(context, context.getBaseServiceUrl() + ResourceConstants.PATH_USER,
				UpdateUserRequest.class, GetUserInfoResponse.class);

		context.setSessionAttr(WebConstants.SESSION_USER, guir.getUser());
		context.setResult(guir.getMessage());
		context.setForwardPage("/user/updateInfo.jsp");
	}
}