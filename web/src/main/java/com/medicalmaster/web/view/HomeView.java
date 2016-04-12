package com.medicalmaster.web.view;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsRequest;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsResponse;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlansRequest;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlansResponse;
import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.common.notice.QueryNoticesResponse;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsResponse;
import com.medicalmaster.dal.ClinicalResearch;
import com.medicalmaster.dal.DiagnosticPlan;
import com.medicalmaster.dal.Notice;
import com.medicalmaster.dal.TrainMeeting;
import com.medicalmaster.web.helper.ResourceProxy;

/**
 * 主页View
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class HomeView extends BaseView {
	static Logger logger = LoggerFactory.getLogger(HomeView.class);

	/**
	 * @throws Exception
	 * 
	 */
	public HomeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super(request, response);
	}

	/**
	 * 查询最新的通知
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws UnsupportedEncodingException
	 */
	public Notice getLastedNotice()
			throws IllegalArgumentException, IllegalAccessException, UnsupportedEncodingException {
		QueryNoticesRequest req = new QueryNoticesRequest();
		req.setStatus(40);

		QueryNoticesResponse response = ResourceProxy
				.get(webContext.getBaseServiceUrl() + ResourceConstants.PATH_NOTICE, req, QueryNoticesResponse.class);

		if (response.isSuccess()) {
			List<Notice> notices = response.getNotices();
			if (notices.size() > 0) {
				return notices.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
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

	public List<ClinicalResearch> getClinicalResearchs() throws IllegalArgumentException, IllegalAccessException {
		QueryClinicalResearchsRequest request = new QueryClinicalResearchsRequest();
		request.setPageSize(7);
		QueryClinicalResearchsResponse response = ResourceProxy.get(
				webContext.getBaseServiceUrl() + ResourceConstants.PATH_CLINICAL_RESEARCH, request,
				QueryClinicalResearchsResponse.class);

		if (response.isSuccess()) {
			return response.getResearchs();
		}

		return null;
	}

	public List<DiagnosticPlan> getDiagnosticPlans() throws IllegalArgumentException, IllegalAccessException {
		QueryDiagPlansRequest request = new QueryDiagPlansRequest();
		request.setPublishStatus(40);
		request.setPageSize(12);
		QueryDiagPlansResponse response = ResourceProxy.get(
				webContext.getBaseServiceUrl() + ResourceConstants.PATH_DIAGNOSTIC_PLAN, request,
				QueryDiagPlansResponse.class);

		if (response.isSuccess()) {
			return response.getPlans();
		}

		return null;
	}
}
