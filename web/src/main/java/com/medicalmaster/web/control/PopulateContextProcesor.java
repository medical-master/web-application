package com.medicalmaster.web.control;

import javax.servlet.http.HttpSession;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class PopulateContextProcesor implements Processor{

	@Override
	public void process(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		
		rpc.setModule(rpc.getRequest().getParameter("module"));
		rpc.setMethod(HttpMethod.GET);
		
		populateUserInfo(rpc);
		
		String port = "8081";
		rpc.setBaseServiceUrl(String.format("http://localhost:%s/service/resources/", port));
		
	}

	private void populateUserInfo(WebContext ctx) {
		if(ctx.getRequest().getSession() == null)
			return;
		
		HttpSession session = ctx.getRequest().getSession();
		ctx.setUserId((String)session.getAttribute("userId"));
		ctx.setUserName((String)session.getAttribute("userName"));
	}
}
