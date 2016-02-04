package com.medicalmaster.web.resource.proxy;

import com.medicalmaster.web.resource.HttpMethod;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class PopulateContextProcesor implements Processor{

	@Override
	public void process(Context ctx) {
		ResourceProxyContext rpc = (ResourceProxyContext)ctx;
		rpc.setResource("users");
		rpc.setMethod(HttpMethod.GET);
		rpc.setUserId("111");
		rpc.setUserName("Jerry");
	}

}
