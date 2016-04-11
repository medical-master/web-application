package com.medicalmaster.resource.control.trainmeeting;

import java.sql.SQLException;
import java.util.List;

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
		try {
			QueryTrainMeetingsRequest request = (QueryTrainMeetingsRequest) inputCtx;
			List<TrainMeeting> trainMeetings = manager.queryTrainMeetins(request);
			response.setTrainMeetings(trainMeetings);

			Integer recordCnt = manager.countTrainMeetings(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.setPageNo(request.getPageNo());
			response.setPageSize(request.getPageSize());

			response.setSuccess(true);
		} catch (SQLException exception) {
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
