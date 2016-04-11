package com.medicalmaster.resource.control.diagnosticplan;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.diagnosticplan.QueryDiagPlansRequest;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlansResponse;
import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.dal.DiagnosticPlan;
import com.xross.tools.xunit.Context;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlans extends DiagPlanConverter {
	static Logger log = LoggerFactory.getLogger(QueryDiagPlans.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.diagnosticplan.DiagPlanConverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryDiagPlansResponse response = new QueryDiagPlansResponse();
		try {
			QueryDiagPlansRequest request = (QueryDiagPlansRequest) inputCtx;
			Integer recordCnt = manager.findDiagnosticPlansCnt(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);

			List<DiagnosticPlan> plans = manager.findDiagnosticPlans(request);
			response.setPlans(plans);
			response.covert(request);

			response.setSuccess(true);

		} catch (SQLException exception) {
			log.error("查询失败", exception);
			response.setSuccess(false);
			response.setMessage("查询失败");
		}

		return response;
	}

}
