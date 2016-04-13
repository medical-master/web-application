package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class DiagnosticPlanExtDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;





	private DalRowMapper<DiagPlanViewPojo> diagPlanViewPojoRowMapper = null;


	public DiagnosticPlanExtDao() throws SQLException {
		this.diagPlanViewPojoRowMapper = new DalDefaultJpaMapper(DiagPlanViewPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * findAllCnt
	**/
	public Long findAllCnt(DalHints hints) throws SQLException {
		String sql = "select count(*) from diagnostic_plan";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByWorkstationCnt
	**/
	public Long findByWorkstationCnt(Integer workstationId, DalHints hints) throws SQLException {
		String sql = "select count(*) from diagnostic_plan where workstationId = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByPublishStatusCnt
	**/
	public Long findByPublishStatusCnt(Integer publishStatus, DalHints hints) throws SQLException {
		String sql = "select count(*) from diagnostic_plan where publishStatus = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "publishStatus", Types.INTEGER, publishStatus);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByWorkstationAndStatusCnt
	**/
	public Long findByWorkstationAndStatusCnt(Integer workstationId, Integer publishStatus, DalHints hints) throws SQLException {
		String sql = "select count(*) from diagnostic_plan where workstationId = ? and publishStatus = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		parameters.setSensitive(i++, "publishStatus", Types.INTEGER, publishStatus);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findDiagPlanViewCnt
	**/
	public Long findDiagPlanViewCnt(DalHints hints) throws SQLException {
		String sql = "select count(*) from diagnostic_plan a, workstation b, `user` c where a.workstationId = b.workstationId and b.userId = c.userId and a.publishStatus = 40";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findDiagPlanView
	**/
	public List<DiagPlanViewPojo> findDiagPlanView(int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT a.id, a.title, c.`name`, c.hosptialId, a.publishTime, a.visitCnt FROM diagnostic_plan a, workstation b, `user` c WHERE a.workstationId = b.workstationId AND b.userId = c.userId AND a.publishStatus = 40 limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<DiagPlanViewPojo>)queryDao.query(sql, parameters, hints, diagPlanViewPojoRowMapper);
	}

}
