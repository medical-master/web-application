package com.medicalmaster.common.control;

import java.util.Map;

import com.medicalmaster.common.ExceptionWraper;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Locator;
import com.xross.tools.xunit.UnitPropertiesAware;

public class FieldLocator implements Locator, UnitPropertiesAware {
	private String fieldName;
	private String defaultKey;
	
	@Override
	public String locate(Context ctx) {
		try {
			return ctx.getClass().getField(fieldName).get(ctx).toString();
		} catch (Exception e) {
			ExceptionWraper.wrap("Faild to locate field value for field" +fieldName, e);
		}
		return null;
	}

	@Override
	public void setDefaultKey(String key) {
		this.defaultKey = key;
	}

	@Override
	public String getDefaultKey() {
		return defaultKey;
	}

	@Override
	public void setUnitProperties(Map<String, String> properties) {
		this.fieldName = fieldName;		
	}

}
