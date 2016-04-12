package com.medicalmaster.resource.control.workstation;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.common.workstation.QueryWorkstationRequest;
import com.medicalmaster.common.workstation.QueryWorkstationResponse;
import com.medicalmaster.dal.Workstation;
import com.xross.tools.xunit.Context;

public class ShowWorkstation extends WorkstationCoverter {
	protected static Logger logger = LoggerFactory.getLogger(ShowWorkstation.class);

	public Context convert(Context inputCtx) {
		QueryWorkstationRequest request = (QueryWorkstationRequest) inputCtx;
		QueryWorkstationResponse response = new QueryWorkstationResponse();

		try {
			Integer recordCnt = manager.countWorkstation(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());

			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);

			List<Workstation> workstation = manager.getAllWorkstation(request);
			response.setWorkstation(workstation);

			response.setSuccess(true);
		} catch (SQLException e) {
			logger.error("QueryWorksation failed! ", e);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version Date Author Note
 * ------------------------------------------------------------------------- 1.0
 * 2016-04-01 js 工作站信息显示
 */
