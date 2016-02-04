package com.medicalmaster.web.resource.proxy;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Validator;

public class AccessCheckValidator implements Validator {

	@Override
	public boolean validate(Context ctx) {
		ResourceProxyContext rpc = (ResourceProxyContext)ctx;
		return "Jerry".equals(rpc.getUserName());
	}
}
