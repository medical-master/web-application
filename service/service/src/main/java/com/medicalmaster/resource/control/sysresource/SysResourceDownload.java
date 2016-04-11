package com.medicalmaster.resource.control.sysresource;

import java.sql.SQLException;

import com.medicalmaster.bean.request.HttpServletContext;
import com.medicalmaster.common.ExceptionWraper;
import com.xross.tools.xunit.Context;

/**
 * 系统资源下载
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月10日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SysResourceDownload extends SysResourceProcessor {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.sysresource.SysResourceProcessor#
	 * process(com.xross.tools.xunit.Context)
	 */
	@Override
	public void process(Context ctx) {
		HttpServletContext context = (HttpServletContext) ctx;
		try {
			manager.download(context);
		} catch (SQLException exception) {
			ExceptionWraper.wrap(exception);
		}
	}

}
