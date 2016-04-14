package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class TrainMaterialViewDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;

	private DalRowMapper<TrainMaterialViewPojoPojo> trainMaterialViewPojoPojoRowMapper = null;


	public TrainMaterialViewDao() throws SQLException {
		this.trainMaterialViewPojoPojoRowMapper = new DalDefaultJpaMapper(TrainMaterialViewPojoPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * 查询工作站指定的培训资料总数
	**/
	public Long countTrainMaterial(Integer workstationId, DalHints hints) throws SQLException {
		String sql = "SELECT count(*) FROM train_material material where material.publishStatus=1 and material.workstationId=?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * 查询工作站指定的培训资料
	**/
	public List<TrainMaterialViewPojoPojo> queryTrainMaterial(Integer workstationId, int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT material.id, material.title, material.workstationId, material.description, material.materialFile, material.visitCnt FROM train_material material WHERE material.publishStatus = 1 AND material.workstationId = ? limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<TrainMaterialViewPojoPojo>)queryDao.query(sql, parameters, hints, trainMaterialViewPojoPojoRowMapper);
	}

}
