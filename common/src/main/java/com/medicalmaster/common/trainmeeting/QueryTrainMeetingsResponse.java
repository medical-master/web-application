package com.medicalmaster.common.trainmeeting;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.TrainMeeting;

/**
 * 培训会议列表查询响应
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryTrainMeetingsResponse extends PageResponse {
	private List<TrainMeeting> trainMeetings;

	/**
	 * @return the trainMeetings
	 */
	public List<TrainMeeting> getTrainMeetings() {
		return trainMeetings;
	}

	/**
	 * @param trainMeetings
	 *            the trainMeetings to set
	 */
	public void setTrainMeetings(List<TrainMeeting> trainMeetings) {
		this.trainMeetings = trainMeetings;
	}

}
