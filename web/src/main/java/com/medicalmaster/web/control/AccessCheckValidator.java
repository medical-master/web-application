package com.medicalmaster.web.control;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Validator;

public class AccessCheckValidator implements Validator {

	@Override
	public boolean validate(Context ctx) {
		WebContext context = (WebContext)ctx;
		//CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "CONSTANT_NAME")); // returns "constantName"
		return accessCheck(context);
	}
	
	private boolean accessCheck(WebContext ctx) {
		return "Jerry".equals(ctx.getUserName());
	}
}
