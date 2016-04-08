package com.medicalmaster.common.control;

import com.medicalmaster.common.request.Request;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Locator;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class RequestLocator implements Locator {
	private String defaultKey;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xross.tools.xunit.Locator#locate(com.xross.tools.xunit.Context)
	 */
	@Override
	public String locate(Context ctx) {
		Request request = (Request) ctx;
		return request.getAction();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xross.tools.xunit.Locator#setDefaultKey(java.lang.String)
	 */
	@Override
	public void setDefaultKey(String key) {
		this.defaultKey = key;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xross.tools.xunit.Locator#getDefaultKey()
	 */
	@Override
	public String getDefaultKey() {
		return this.defaultKey;
	}

}
