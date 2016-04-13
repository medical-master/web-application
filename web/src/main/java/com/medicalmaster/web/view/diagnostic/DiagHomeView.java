package com.medicalmaster.web.view.diagnostic;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfosRequest;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfosResponse;
import com.medicalmaster.dal.DiagnosticPlanListPojo;
import com.medicalmaster.web.helper.ResourceProxy;
import com.medicalmaster.web.view.BaseView;

/**
 * 诊疗方案
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class DiagHomeView extends BaseView {
	static Logger logger = LoggerFactory.getLogger(DiagHomeView.class);

	/**
	 * @throws Exception
	 * 
	 */
	public DiagHomeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super(request, response);
	}

	public List<DiagnosticPlanListPojo> getDiagPlanInfos(Integer pageNo, Integer pageSize)
			throws IllegalArgumentException, IllegalAccessException {
		QueryDiagPlanInfosRequest request = new QueryDiagPlanInfosRequest();
		request.setPageNo(pageNo);
		request.setPageSize(pageSize);

		QueryDiagPlanInfosResponse response = ResourceProxy.get(
				webContext.getBaseServiceUrl() + ResourceConstants.PATH_DIAGNOSTIC_PLAN + "/infos", request,
				QueryDiagPlanInfosResponse.class);

		if (response.isSuccess()) {
			return response.getPojos();
		}

		return null;
	}
}
