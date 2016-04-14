package com.medicalmaster.domain.trainmaterial;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.trainmaterial.QueryTrainMaterialRequest;
import com.medicalmaster.dal.TrainMaterialViewDao;
import com.medicalmaster.dal.TrainMaterialViewPojoPojo;

/**
 * 培训资料
 * 
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class TrainmaterialManager 
{
	private TrainMaterialViewDao dao;
	
	public TrainmaterialManager() throws SQLException
	{
		dao = new TrainMaterialViewDao();
	}
	
	/**
	 * 获取工作站对应的指定培训资料
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<TrainMaterialViewPojoPojo> queryTrainMaterial(QueryTrainMaterialRequest request) throws SQLException {
		return dao.queryTrainMaterial(request.getWorkstationId(),request.getPageNo(), request.getPageSize(), null);
	}
	
	/**
	 * 获取工作站对应的指定培训资料总数
	 */
	public Integer countTrainMaterial(QueryTrainMaterialRequest request) throws SQLException 
	{
		Long count = dao.countTrainMaterial(request.getWorkstationId(), null);
		return count.intValue();
	}
	
}
