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

	private DalRowMapper<WorkstationViewPojoPojo> workstationViewPojoPojoRowMapper = null;


	public WorkstationViewDao() throws SQLException {
		this.trainMaterialRecorderPojoRowMapper = new DalDefaultJpaMapper(TrainMaterialRecorderPojo.class);
		this.researchStageRecordPojoRowMapper = new DalDefaultJpaMapper(ResearchStageRecordPojo.class);
		this.workstationViewPojoPojoRowMapper = new DalDefaultJpaMapper(WorkstationViewPojoPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * findTrainMaterial
	**/
	public List<TrainMaterialRecorderPojo> findTrainMaterial(Integer materialId, DalHints hints) throws SQLException {
		String sql = "SELECT a.title, a.description, b.resourceName, b.resourceType, b.fileUrl, b.allowDownload, b.downloadCnt FROM train_material a LEFT JOIN sys_resource b ON a.materialFile = b.id AND a.id = ? WHERE b.`status` = 1";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "materialId", Types.INTEGER, materialId);
		return (List<TrainMaterialRecorderPojo>)queryDao.query(sql, parameters, hints, trainMaterialRecorderPojoRowMapper);
	}
	/**
	 * findResearchStage
	**/
	public List<ResearchStageRecordPojo> findResearchStage(Integer workstationId, int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT stage.clinicalResearchId, stage.title AS stageTitle, stage.description AS stage, stage.resourceId AS stageResourceId, stage.viewStatus AS stageViewStatus, stage.`status` AS stageStatus, stage.publishTime AS stagePublishTime, stage.createTime AS stageCreateTime, stage.createUser AS stageCreateUser, stage.lastUpdateTime AS stageLastUpdateTime, stage.lastUpdateUser AS stageLastUpdateUser, research.title, research.description, research.resourceId, research.viewStatus, research.currentStatus, research.publishTime, research.createTime, research.createUser, research.lastUpdateTime, research.lastUpdateUser FROM clinical_research_stage stage, clinical_research research WHERE stage.clinicalResearchId = research.id AND research.workstationId = ? limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<ResearchStageRecordPojo>)queryDao.query(sql, parameters, hints, researchStageRecordPojoRowMapper);
	}
	/**
	 * 工作站信息查询
	**/
	public List<WorkstationViewPojoPojo> showWorkstation(Integer workstationId, DalHints hints) throws SQLException {
		String sql = "SELECT wks.`name` as wksName, wks.description, wks.domains, wks.illCode, wks.members, wks.attends, wks.status as wksStatus, ex.expertArea, ex.honorHtml, ex.academicHtml, us.name as usName, us.nickName, us.sex, us.email, concat(us.professionalRank,"，",us.title,"，",us.educationLevel) as pte, us.status usStatus, us.doctorNumber, us.department, ho.name as hospitalName, ho.level, ho.proviceId, ho.cityId, ho.districtId, ho.address, re.fileUrl FROM workstation wks, expert ex, USER us, sys_hospital ho, sys_resource re where wks.expertId=ex.id and ex.userId=us.userId and us.hosptialId=ho.hospitalId and us.iconResourceId=re.id and wks.status=1 and wks.workstationId=?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		return (List<WorkstationViewPojoPojo>)queryDao.query(sql, parameters, hints, workstationViewPojoPojoRowMapper);
	}
	/**
	 * 获取总页数
	**/
	public WorkstationViewPojoPojo count(DalHints hints) throws SQLException {
		String sql = "SELECT wks.`name` as wksName, wks.description, wks.domains, wks.illCode, wks.members, wks.attends, wks.status as wksStatus, ex.expertArea, ex.honorHtml, ex.academicHtml, us.name as usName, us.nickName, us.sex, us.email, concat(us.professionalRank,"，",us.title,"，",us.educationLevel) as pte, us.status usStatus, us.doctorNumber, us.department, ho.name as hospitalName, ho.level, ho.proviceId, ho.cityId, ho.districtId, ho.address, re.fileUrl FROM workstation wks, expert ex, USER us, sys_hospital ho, sys_resource re where wks.expertId=ex.id and ex.userId=us.userId and us.hosptialId=ho.hospitalId and us.iconResourceId=re.id and wks.status=1";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		return (WorkstationViewPojoPojo)queryDao.queryForObjectNullable(sql, parameters, hints, workstationViewPojoPojoRowMapper);
	}

}
