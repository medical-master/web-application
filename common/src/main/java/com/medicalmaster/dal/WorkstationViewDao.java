package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class WorkstationViewDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;

	private DalRowMapper<TrainMaterialRecorderPojo> trainMaterialRecorderPojoRowMapper = null;

	private DalRowMapper<ResearchStageRecordPojo> researchStageRecordPojoRowMapper = null;

	public WorkstationViewDao() throws SQLException {
		this.trainMaterialRecorderPojoRowMapper = new DalDefaultJpaMapper(TrainMaterialRecorderPojo.class);
		this.researchStageRecordPojoRowMapper = new DalDefaultJpaMapper(ResearchStageRecordPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * a
	**/
	public List<TrainMaterialRecorderPojo> findTrainMaterial(Integer materialId, DalHints hints) throws SQLException {
		String sql = "SELECT a.title, a.description, b.resourceName, b.resourceType, b.fileUrl, b.allowDownload, b.downloadCnt FROM train_material a LEFT JOIN sys_resource b ON a.materialFile = b.id AND a.id = ? WHERE b.`status` = 1;";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "materialId", Types.INTEGER, materialId);
		return (List<TrainMaterialRecorderPojo>)queryDao.query(sql, parameters, hints, trainMaterialRecorderPojoRowMapper);
	}
	/**
	 * a
	**/
	public List<ResearchStageRecordPojo> findResearchStage(Integer workstationId, int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT stage.clinicalResearchId, stage.title AS stageTitle, stage.description AS stage, stage.resourceId AS stageResourceId, stage.viewStatus AS stageViewStatus, stage.`status` AS stageStatus, stage.publishTime AS stagePublishTime, stage.createTime AS stageCreateTime, stage.createUser AS stageCreateUser, stage.lastUpdateTime AS stageLastUpdateTime, stage.lastUpdateUser AS stageLastUpdateUser, research.title, research.description, research.resourceId, research.viewStatus, research.currentStatus, research.publishTime, research.createTime, research.createUser, research.lastUpdateTime, research.lastUpdateUser FROM clinical_research_stage stage, clinical_research research WHERE stage.clinicalResearchId = research.id AND research.workstationId = ? limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.set(i++, "workstationId", Types.INTEGER, workstationId);
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<ResearchStageRecordPojo>)queryDao.query(sql, parameters, hints, researchStageRecordPojoRowMapper);
	}

}
