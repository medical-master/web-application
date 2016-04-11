package com.medicalmaster.web.control;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.medicalmaster.dal.User;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;
import com.xross.tools.xunit.UnitPropertiesAware;

public class PopulateContextProcesor implements Processor, UnitPropertiesAware {
	private String serviceUrl;
	
	@Override
	public void process(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		
		rpc.setModule(rpc.getRequest().getParameter("module"));
		rpc.setMethod(HttpMethod.GET);
		
		populateUserInfo(rpc);
		
		rpc.setBaseServiceUrl(serviceUrl);
	}

	private void populateUserInfo(WebContext ctx) {
		HttpSession session = ctx.getRequest().getSession(false);
		if(session == null || session.getAttribute("user") == null)
			return;
		
		User user = (User)session.getAttribute("user");
		ctx.setUserId(String.valueOf(user.getUserId()));
		ctx.setUserName(user.getName());
	}

	@Override
	public void setUnitProperties(Map<String, String> properties) {
		String serviceHost = properties.get("serviceHost");
		String servicePath = properties.get("servicePath");
		String servicePort = properties.get("servicePort");
		serviceUrl = serviceHost + ":" + servicePort + servicePath;
	}
}
