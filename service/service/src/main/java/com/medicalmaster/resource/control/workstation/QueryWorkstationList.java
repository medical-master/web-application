package com.medicalmaster.resource.control.workstation;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.common.workstation.QueryWorkstationListRequest;
import com.medicalmaster.common.workstation.QueryWorkstationListResponse;
import com.medicalmaster.dal.Workstation;
import com.xross.tools.xunit.Context;

/**
 * 工作站列表查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryWorkstationList extends WorkstationCoverter {
	static Logger log = LoggerFactory.getLogger(QueryWorkstationList.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.workstation.WorkstationCoverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryWorkstationListResponse response = new QueryWorkstationListResponse();
		QueryWorkstationListRequest request = (QueryWorkstationListRequest) inputCtx;
		try {
			Integer recordCnt = manager.queryWorksationListCnt(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);

			List<Workstation> workstations = manager.queryWorkstationList(request);
			response.setWorkstations(workstations);
			response.setSuccess(true);

		} catch (SQLException exception) {
			log.error("status {} QueryWorkstationList failed!", request.getStatus(), exception);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
