package com.medicalmaster.resource.control.notice;

import java.sql.SQLException;

import com.medicalmaster.domain.notice.NoticeManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 公告通知
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class NoticeCoverter implements Converter {
	protected static NoticeManager manager;

	static {
		try {
			manager = new NoticeManager();

		} catch (SQLException exception) {

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
