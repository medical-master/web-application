package com.medicalmaster.web.control;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Locator;

public class ActionLocator implements Locator {

	@Override
	public String locate(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		return rpc.getRequest().getParameter("action");
	}

	@Override
	public void setDefaultKey(String key) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDefaultKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
