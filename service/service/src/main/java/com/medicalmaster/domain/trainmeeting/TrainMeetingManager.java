package com.medicalmaster.domain.trainmeeting;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.helper.ParseHelper;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.dal.TrainMeeting;
import com.medicalmaster.dal.TrainMeetingDao;

/**
 * 培训会议
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class TrainMeetingManager {
	TrainMeetingDao dao;

	/**
	 * 
	 */
	public TrainMeetingManager() throws SQLException {
		dao = new TrainMeetingDao();
	}

	public List<TrainMeeting> queryTrainMeetins(QueryTrainMeetingsRequest request) throws SQLException {
		return dao.findTrainMeeting(ParseHelper.parseInt(request.getWorkstationId()),
				ParseHelper.parseInt(request.getPublishStatu()), request.getPageNo(), request.getPageSize(), null);
	}

	public Integer countTrainMeetings(QueryTrainMeetingsRequest request) throws SQLException {
		List<Integer> list = dao.findTrainMeetingCnt(ParseHelper.parseInt(request.getWorkstationId()),
				ParseHelper.parseInt(request.getPublishStatu()), null);
		if (list != null) {
			return list.size();
		}

		return 0;
	}
}
