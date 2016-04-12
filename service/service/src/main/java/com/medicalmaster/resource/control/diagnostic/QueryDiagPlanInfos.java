package com.medicalmaster.resource.control.diagnostic;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfosRequest;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfosResponse;
import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.dal.DiagnosticPlanListPojo;
import com.xross.tools.xunit.Context;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlanInfos extends DiagPlanConverter {
	static Logger log = LoggerFactory.getLogger(QueryDiagPlanInfos.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medicalmaster.resource.control.diagnostic.DiagPlanConverter#convert(
	 * com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryDiagPlanInfosRequest request = (QueryDiagPlanInfosRequest) inputCtx;
		QueryDiagPlanInfosResponse response = new QueryDiagPlanInfosResponse();

		try {
			Integer recordCnt = manager.findDiagPlanInfosCnt(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);

			List<DiagnosticPlanListPojo> diagnosticPlanListPojos = manager.findDiagPlanInfos(request);
			response.setPojos(diagnosticPlanListPojos);
			response.setSuccess(true);

		} catch (SQLException exception) {
			log.error("数据库查询失败 planStatus {}, workstationStatus {}", request.getPlanStatus(),
					request.getWorkstatStatus(), exception);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}
		return response;
	}

}
