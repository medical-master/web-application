package com.medicalmaster.resource.control.sysresource;

import com.medicalmaster.domain.sysresource.SysResourceManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class SysResourceConverter implements Converter {
	protected static SysResourceManager manager;

	static {
		try {
			manager = new SysResourceManager();
		} catch (Exception e) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public abstract Context convert(Context inputCtx);
}
