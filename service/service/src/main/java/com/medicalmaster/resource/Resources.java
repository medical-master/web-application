package com.medicalmaster.resource;

import com.medicalmaster.common.ExceptionWraper;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.XunitFactory;

/**
 * 
 * Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class Resources {
	protected String converterId = null;
	protected static String xunitName = null;
	protected static XunitFactory factory;

	static {
		try {
			factory = XunitFactory.load(xunitName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> T handle(Context ctx, String message) {
		try {
			return (T) factory.getConverter(converterId).convert(ctx);
		} catch (Throwable e) {
			ExceptionWraper.wrap(message, e);
			return null;
		}
	}
}
