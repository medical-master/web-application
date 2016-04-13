package com.medicalmaster.domain.trainmeeting;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.dal.TrainMeeting;
import com.medicalmaster.dal.TrainMeetingDao;
import com.medicalmaster.dal.TrainMeetingExtDao;

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
	TrainMeetingExtDao extDao;

	/**
	 * 
	 */
	public TrainMeetingManager() throws SQLException {
		dao = new TrainMeetingDao();
		extDao = new TrainMeetingExtDao();
	}

	public List<TrainMeeting> queryTrainMeetins(QueryTrainMeetingsRequest request) throws SQLException {
		return dao.findTrainMeetings(request.getWorkstationId(), request.getPublishStatu(), request.getPageNo(),
				request.getPageSize(), null);
	}

	public Integer countTrainMeetings(QueryTrainMeetingsRequest request) throws SQLException {

		if (request.getWorkstationId() != null && request.getPublishStatu() == null) {
			return extDao.findByWorkstationCnt(request.getWorkstationId(), null).intValue();
		}

		if (request.getWorkstationId() == null && request.getPublishStatu() != null) {
			return extDao.findByPublishStatusCnt(request.getPublishStatu(), null).intValue();
		}

		if (request.getWorkstationId() != null && request.getPublishStatu() != null) {
			return extDao.findByWorkstationAndStatusCnt(request.getWorkstationId(), request.getPublishStatu(), null)
					.intValue();
		}

		return extDao.findAllCnt(null).intValue();
	}
}
