package com.medicalmaster.resource.control.trainmaterial;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.PageHelper;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialRequest;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialResponse;
import com.medicalmaster.dal.TrainMaterialViewPojoPojo;
import com.medicalmaster.dal.WorkstationViewPojoPojo;
import com.medicalmaster.resource.control.workstation.ShowWorkstation;
import com.xross.tools.xunit.Context;

public class QueryTrainMaterial extends TrainMaterialCoverter
{
	protected static Logger logger = LoggerFactory.getLogger(QueryTrainMaterial.class);
	@Override
	public Context convert(Context inputCtx) 
	{
		QueryTrainMaterialRequest request = (QueryTrainMaterialRequest)inputCtx;
		QueryTrainMaterialResponse response = new QueryTrainMaterialResponse();
		try 
		{
			Integer recordCnt = manager.countTrainMaterial(request);
			Integer pageCnt = PageHelper.calcPageCnt(recordCnt, request.getPageSize());

			List<TrainMaterialViewPojoPojo> trainMaterialView = manager.queryTrainMaterial(request);

			response.setSuccess(true);
			response.setRecordCnt(recordCnt);
			response.setPageCnt(pageCnt);
			response.setPageNo(request.getPageNo());
			response.setPageSize(request.getPageSize());
			response.setTrainMaterial(trainMaterialView);
		} 
		catch (SQLException e) 
		{
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
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-14        	js        	  	    查询培训资料
 */