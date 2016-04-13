package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsResponse;
import com.xross.tools.xunit.XunitFactory;

/**
 * 培训会议
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月6日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path(ResourceConstants.PATH_TRAIN_MEETING)
public class TrainMeetingResource extends Resources {

	/**
	 * 
	 */
	public TrainMeetingResource() {
		super("trainMeeting.xunit", "trainMeeting branch");
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public QueryTrainMeetingsResponse queryTrainMeetings(@BeanParam QueryTrainMeetingsRequest request) {
		request.setAction("queryList");
		return handle(request, request.getAction());
	}
}
