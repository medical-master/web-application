package com.medicalmaster.resource.control.trainmaterial;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListRequest;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListResponse;
import com.medicalmaster.dal.TrainMaterial;
import com.xross.tools.xunit.Context;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月15日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryTrainMaterialListConverter extends TrainMaterialCoverter {
	static Logger log = LoggerFactory.getLogger(QueryTrainMaterialListConverter.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.medicalmaster.resource.control.trainmeeting.TrainMeetingConverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QueryTrainMaterialListResponse response = new QueryTrainMaterialListResponse();

		try {
			QueryTrainMaterialListRequest request = (QueryTrainMaterialListRequest) inputCtx;
			Integer recordCnt = manager.queryTrainMaterialListCnt(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.covert(request);

			List<TrainMaterial> materials = manager.queryTrainMaterialList(request);
			response.setMaterials(materials);
			response.setSuccess(true);

		} catch (SQLException exception) {
			log.error("数据库查询失败!", exception);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
