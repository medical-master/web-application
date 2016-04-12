package com.medicalmaster.resource.control.trainmeeting;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsResponse;
import com.medicalmaster.dal.TrainMeeting;
import com.xross.tools.xunit.Context;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryTrainMeetings extends TrainMeetingConverter {
	static Logger log = LoggerFactory.getLogger(QueryTrainMeetings.class);
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medicalmaster.resource.control.trainmeeting.TrainMeetingConverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryTrainMeetingsResponse response = new QueryTrainMeetingsResponse();
		QueryTrainMeetingsRequest request = (QueryTrainMeetingsRequest) inputCtx;
		try {
			
			Integer recordCnt = manager.countTrainMeetings(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);
			
			List<TrainMeeting> trainMeetings = manager.queryTrainMeetins(request);
			response.setTrainMeetings(trainMeetings);
			
			response.setSuccess(true);
		} catch (SQLException exception) {
			log.error("查询失败", exception);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
