package com.medicalmaster.web.view.research;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsRequest;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsResponse;
import com.medicalmaster.web.helper.ResourceProxy;
import com.medicalmaster.web.view.BaseView;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月14日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class ResearchHomeView extends BaseView {
	/**
	 * @throws Exception
	 * 
	 */
	public ResearchHomeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super(request, response);
	}

	public QueryClinicalResearchsResponse getResearchsResponse()
			throws IllegalArgumentException, IllegalAccessException {
		QueryClinicalResearchsRequest request = new QueryClinicalResearchsRequest();
		getPageParameters(request);
		return ResourceProxy.get(webContext.getBaseServiceUrl() + ResourceConstants.PATH_CLINICAL_RESEARCH, request,
				QueryClinicalResearchsResponse.class);
	}
}
