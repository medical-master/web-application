package com.medicalmaster.resource.control.diagnostic;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfoResponse;
import com.medicalmaster.common.request.get.IdRequest;
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
public class QueryDiagPlanInfo extends DiagPlanConverter {
	static Logger log = LoggerFactory.getLogger(QueryDiagPlanInfo.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.diagnosticplan.DiagPlanConverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryDiagPlanInfoResponse response = new QueryDiagPlanInfoResponse();
		try {
			IdRequest request = (IdRequest) inputCtx;
			DiagnosticPlan plan = manager.queryInfo(request.getId());
			response.setPlan(plan);
			response.setSuccess(true);
		} catch (SQLException exception) {
			log.error("查询失败", exception);

			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
