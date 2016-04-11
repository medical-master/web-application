package com.medicalmaster.resource.control.clinicalresearch;

import java.sql.SQLException;

import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchInfoResponse;
import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.dal.ClinicalResearch;
import com.xross.tools.xunit.Context;

/**
 * 信息查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryClinicalResearchInfo extends ClinicalResearchCoverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.clinicalresearch.
	 * ClinicalResearchCoverter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		IdRequest request = (IdRequest) inputCtx;
		QueryClinicalResearchInfoResponse response = new QueryClinicalResearchInfoResponse();
		try {
			ClinicalResearch research = manager.queryInfo(request.getId());
			response.setResearch(research);
			response.setSuccess(true);
		} catch (SQLException exception) {
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
