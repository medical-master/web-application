package com.medicalmaster.resource.control.notice;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.notice.QueryNoticeInfoResponse;
import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.dal.Notice;
import com.xross.tools.xunit.Context;

/**
 * 查询公告通知内容
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryNoticeInfo extends NoticeCoverter {
	static Logger logger = LoggerFactory.getLogger(QueryNoticeInfo.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		IdRequest context = (IdRequest) inputCtx;
		Integer id = context.getId();
		QueryNoticeInfoResponse response = new QueryNoticeInfoResponse();

		try {
			Notice notice = manager.queryNoticeInfo(id);
			response.setSuccess(true);
			response.setNotice(notice);

		} catch (SQLException exception) {
			logger.error("QueryNoticeInfo failed!", exception);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}
		return response;
	}

}
