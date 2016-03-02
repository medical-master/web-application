package com.medicalmaster.web.control;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Validator;

public class AccessCheckValidator implements Validator {

	@Override
	public boolean validate(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		return "Jerry".equals(rpc.getUserName());
	}
}
