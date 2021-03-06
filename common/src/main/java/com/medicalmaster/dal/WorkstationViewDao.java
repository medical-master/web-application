package com.medicalmaster.dal;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.DalHints;
import com.ctrip.platform.dal.dao.DalQueryDao;
import com.ctrip.platform.dal.dao.DalRowMapper;
import com.ctrip.platform.dal.dao.StatementParameters;
import com.ctrip.platform.dal.dao.helper.DalDefaultJpaMapper;

public class WorkstationViewDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;

	private DalRowMapper<ResearchStageRecordPojo> researchStageRecordPojoRowMapper = null;

	private DalRowMapper<WorkstationViewPojoPojo> workstationViewPojoPojoRowMapper = null;





	public WorkstationViewDao() throws SQLException {
		this.researchStageRecordPojoRowMapper = new DalDefaultJpaMapper(ResearchStageRecordPojo.class);
		this.workstationViewPojoPojoRowMapper = new DalDefaultJpaMapper(WorkstationViewPojoPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * 获取总页数
	**/
	public Long count(DalHints hints) throws SQLException {
		String sql = "SELECT count(*) FROM workstation wks, USER us, sys_resource re where wks.userId = us.userId and us.iconResourceId=re.id and wks.status=1";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
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
	public List<WorkstationViewPojoPojo> showWorkstation(int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT wks.workstationId, wks.userId, wks.subLink, wks.`name` AS wksName, wks.summery, wks.description, wks.keywords, wks.domains, wks.illCode, wks.members, wks.attends, wks.visitCnt, wks.status AS wksStatus, us.name AS usName, us.nickName, us.sex, us.email, us.professionalRank, us.title, us.educationLevel, us.status usStatus, us.hosptialId, us.doctorNumber, us.department, us.expertArea, us.expertType, re.fileUrl FROM workstation wks, USER us, sys_resource re WHERE wks.userId = us.userId AND us.iconResourceId = re.id AND wks.status = 1 limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<WorkstationViewPojoPojo>)queryDao.query(sql, parameters, hints, workstationViewPojoPojoRowMapper);
	}
	/**
	 * 根据用户ID查询对应的工作站信息
	**/
	public List<WorkstationViewPojoPojo> findByUserWorkstation(Integer status, Integer userId, DalHints hints) throws SQLException {
		String sql = "SELECT wks.workstationId, wks.userId, wks.subLink, wks.`name` as wksName, wks.summery, wks.description, wks.keywords, wks.domains, wks.illCode, wks.members, wks.attends, wks.visitCnt, wks.status as wksStatus, us.name as usName, us.nickName, us.sex, us.email, us.professionalRank, us.title, us.educationLevel, us.status usStatus, us.hosptialId, us.doctorNumber, us.department, us.expertArea, us.expertType, re.fileUrl FROM workstation wks, USER us, sys_resource re where wks.userId = us.userId and us.iconResourceId=re.id and wks.status=? and wks.userId=?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "status", Types.INTEGER, status);
		parameters.setSensitive(i++, "userId", Types.INTEGER, userId);
		return (List<WorkstationViewPojoPojo>)queryDao.query(sql, parameters, hints, workstationViewPojoPojoRowMapper);
	}
	/**
	 * 工作站详细信息查询
	**/
	public WorkstationViewPojoPojo showWorkstationInfo(Integer workstationId, DalHints hints) throws SQLException {
		String sql = "SELECT wks.workstationId, wks.userId, wks.subLink, wks.`name` as wksName, wks.summery, wks.description, wks.keywords, wks.domains, wks.illCode, wks.members, wks.attends, wks.status as wksStatus, wks.visitCnt, us.name as usName, us.nickName, us.sex, us.email, us.professionalRank, us.title, us.educationLevel, us.status usStatus, us.hosptialId, us.doctorNumber, us.department, us.expertArea, us.expertType, re.fileUrl FROM workstation wks, USER us, sys_resource re where wks.userId = us.userId and us.iconResourceId=re.id and wks.status=1 and wks.workstationId=?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		return (WorkstationViewPojoPojo)queryDao.queryForObjectNullable(sql, parameters, hints, workstationViewPojoPojoRowMapper);
	}
	/**
	 * 根据用户ID查询对应的工作站信息总数
	**/
	public WorkstationViewPojoPojo findByUserWorkstationCnt(Integer status, Integer userId, DalHints hints) throws SQLException {
		String sql = "SELECT count(*) FROM workstation wks, USER us, sys_resource re where wks.userId = us.userId and us.iconResourceId=re.id and wks.status=? and wks.userId=?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "status", Types.INTEGER, status);
		parameters.setSensitive(i++, "userId", Types.INTEGER, userId);
		return (WorkstationViewPojoPojo)queryDao.queryForObjectNullable(sql, parameters, hints, workstationViewPojoPojoRowMapper);
	}
}
