package com.medicalmaster.resource;

import com.medicalmaster.common.ExceptionWraper;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.XunitFactory;

/**
 * 
 * Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public abstract class Resources {
	protected String converterId = null;
	protected XunitFactory factory;
	
	public Resources(String xunitFileName, String converterId) {
		try {
			factory = XunitFactory.load(xunitFileName);
			this.converterId = converterId;
		} catch (Throwable e) {
			throw new RuntimeException(e);
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
