package com.medicalmaster.web.control;

import java.util.Map;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Locator;
import com.xross.tools.xunit.UnitPropertiesAware;

public class RequestParameterLocator implements Locator, UnitPropertiesAware {
	private String parameterName;
	@Override
	public String locate(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		return rpc.getRequest().getParameter(parameterName);
	}

	@Override
	public void setDefaultKey(String key) {
	}

	@Override
	public String getDefaultKey() {
		return null;
	}

	@Override
	public void setUnitProperties(Map<String, String> properties) {
		this.parameterName = properties.get("parameterName");
	}
}
