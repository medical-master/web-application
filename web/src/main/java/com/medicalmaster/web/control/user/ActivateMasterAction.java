package com.medicalmaster.web.control.user;

import com.medicalmaster.common.user.CreateUserRequest;
import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class ActivateMasterAction implements Processor{

	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
	}
	
	private CreateUserRequest normalize(WebContext context) {
		CreateUserRequest req = new CreateUserRequest();
		return req;
	}
	
	private <T> T normalize(WebContext context, Class<T> clazz) {
		T value =null;
		try {
			value = clazz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
}
