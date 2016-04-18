package com.medicalmaster.resource.control.user;

import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月15日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class UserConverter implements Converter {
	protected static UserManager manager;

	static {
		try {
			manager = new UserManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	/* (non-Javadoc)
	 * @see com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public abstract Context convert(Context inputCtx) ;

}
