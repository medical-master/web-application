package com.medicalmaster.resource.control.sysresource;

import com.medicalmaster.domain.sysresource.SysResourceManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class SysResourceProcessor implements Processor {
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
	 * com.xross.tools.xunit.Processor#process(com.xross.tools.xunit.Context)
	 */
	@Override
	public abstract void process(Context ctx);

}
