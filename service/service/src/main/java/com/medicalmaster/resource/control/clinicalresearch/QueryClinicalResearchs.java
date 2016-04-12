package com.medicalmaster.resource.control.clinicalresearch;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsRequest;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsResponse;
import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.dal.ClinicalResearch;
import com.xross.tools.xunit.Context;

/**
 * 列表查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryClinicalResearchs extends ClinicalResearchCoverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.clinicalresearch.
	 * ClinicalResearchCoverter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryClinicalResearchsResponse response = new QueryClinicalResearchsResponse();
		try {
			QueryClinicalResearchsRequest request = (QueryClinicalResearchsRequest) inputCtx;
			Integer recordCnt = manager.queryClinicalResearchsCnt(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);

			List<ClinicalResearch> researchs = manager.queryClinicalResearchs(request);
			response.setResearchs(researchs);
			response.setSuccess(true);
		} catch (SQLException exception) {
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
