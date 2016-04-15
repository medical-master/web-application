package com.medicalmaster.domain.trainmaterial;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListRequest;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialRequest;
import com.medicalmaster.dal.TrainMaterial;
import com.medicalmaster.dal.TrainMaterialDao;
import com.medicalmaster.dal.TrainMaterialViewDao;
import com.medicalmaster.dal.TrainMaterialViewPojoPojo;

/**
 * 培训资料
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class TrainmaterialManager {
	private TrainMaterialViewDao dao;
	private TrainMaterialDao materialDao;

	public TrainmaterialManager() throws SQLException {
		dao = new TrainMaterialViewDao();

		materialDao = new TrainMaterialDao();
	}

	/**
	 * 获取工作站对应的指定培训资料
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<TrainMaterialViewPojoPojo> queryTrainMaterial(QueryTrainMaterialRequest request) throws SQLException {
		return dao.queryTrainMaterial(request.getWorkstationId(), request.getPageNo(), request.getPageSize(), null);
	}

	/**
	 * 获取工作站对应的指定培训资料总数
	 */
	public Integer countTrainMaterial(QueryTrainMaterialRequest request) throws SQLException {
		Long count = dao.countTrainMaterial(request.getWorkstationId(), null);
		return count.intValue();
	}

	/**
	 * 获取列表总数
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public Integer queryTrainMaterialListCnt(QueryTrainMaterialListRequest request) throws SQLException {
		if (request.getWorkstationId() != null && request.getPublishStatus() == null) {
			return dao.findByWorkstationIdCnt(request.getWorkstationId(), null).intValue();
		}

		if (request.getWorkstationId() == null && request.getPublishStatus() != null) {
			return dao.findByPublishStatusCnt(request.getPublishStatus(), null).intValue();
		}

		if (request.getWorkstationId() != null && request.getPublishStatus() != null) {
			return dao.findByWorkstationAndStatusCnt(request.getWorkstationId(), request.getPublishStatus(), null)
					.intValue();
		}

		return dao.findAllCnt(null).intValue();
	}

	/**
	 * 获取列表
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<TrainMaterial> queryTrainMaterialList(QueryTrainMaterialListRequest request) throws SQLException {
		return materialDao.findByWorkstationIdStatus(request.getWorkstationId(), request.getPublishStatus(), null);
	}

}
