package com.medicalmaster.web.view.training;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListRequest;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListResponse;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsResponse;
import com.medicalmaster.dal.TrainMaterial;
import com.medicalmaster.dal.TrainMeeting;
import com.medicalmaster.web.helper.ResourceProxy;
import com.medicalmaster.web.view.BaseView;

/**
 * 培训主页
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月14日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class TrainHomeView extends BaseView {
	/**
	 * @throws Exception
	 * 
	 */
	public TrainHomeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super(request, response);
	}

	public List<TrainMeeting> getTrainMeetings() throws IllegalArgumentException, IllegalAccessException {
		QueryTrainMeetingsRequest request = new QueryTrainMeetingsRequest();
		request.setPublishStatu(40);
		request.setPageNo(1);
		request.setPageSize(35);
		QueryTrainMeetingsResponse response = ResourceProxy.get(
				webContext.getBaseServiceUrl() + ResourceConstants.PATH_TRAIN_MEETING, request,
				QueryTrainMeetingsResponse.class);

		if (response.isSuccess()) {
			return response.getTrainMeetings();
		} else {
			return null;
		}
	}

	public List<TrainMaterial> getTrainMaterial() throws IllegalArgumentException, IllegalAccessException {
		QueryTrainMaterialListRequest request = new QueryTrainMaterialListRequest();
		request.setPageNo(1);
		request.setPageSize(20);

		QueryTrainMaterialListResponse response = ResourceProxy.get(
				webContext.getBaseServiceUrl() + ResourceConstants.PATH_TRAIN_MATERIAL, request,
				QueryTrainMaterialListResponse.class);

		if (response.isSuccess()) {
			return response.getMaterials();
		} else {
			return null;
		}
	}
}
