package com.medicalmaster.resource.control.notice;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.common.notice.QueryNoticesResponse;
import com.medicalmaster.dal.Notice;
import com.xross.tools.xunit.Context;

/**
 * 获取公告通知列表
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryNotices extends NoticeCoverter {
	static Logger logger = LoggerFactory.getLogger(QueryNotices.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryNoticesRequest request = (QueryNoticesRequest) inputCtx;

		QueryNoticesResponse response = new QueryNoticesResponse();
		try {
			Integer recordCnt = manager.countNotices(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);
			
			List<Notice> notices = manager.queryNotices(request);
			
			response.setNotices(notices);
			
			response.setSuccess(true);
		} catch (SQLException e) {
			logger.error("QueryNotices failed! ", e);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
