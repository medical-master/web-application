package com.medicalmaster.dal;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.DalHints;
import com.ctrip.platform.dal.dao.DalQueryDao;
import com.ctrip.platform.dal.dao.DalRowMapper;
import com.ctrip.platform.dal.dao.StatementParameters;
import com.ctrip.platform.dal.dao.helper.DalDefaultJpaMapper;

public class DiagnosticPlanExtDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;


	private DalRowMapper<DiagnosticPlanListPojo> diagnosticPlanListPojoRowMapper = null;

	public DiagnosticPlanExtDao() throws SQLException {
		this.diagnosticPlanListPojoRowMapper = new DalDefaultJpaMapper(DiagnosticPlanListPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * findDiagnosticPlansCnt
	**/
	public Long findDiagnosticPlansCnt(Integer planStatus, Integer workstatStatus, DalHints hints) throws SQLException {
		String sql = "select count(*) from diagnostic_plan a, workstation b, expert_user c where a.workstationId = b.workstationId and b.expertId = c.expertId and a.publishStatus = ? and b.`status` = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "planStatus", Types.INTEGER, planStatus);
		parameters.setSensitive(i++, "workstatStatus", Types.INTEGER, workstatStatus);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findDiagnosticPlans
	**/
	public List<DiagnosticPlanListPojo> findDiagnosticPlans(Integer planStatus, Integer workstatStatus, int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT a.id AS planId, a.title, c.name, c.hospitalName, a.publishTime, a.visitCnt FROM diagnostic_plan a, workstation b, expert_user c WHERE a.workstationId = b.workstationId AND b.expertId = c.expertId AND a.publishStatus = ? AND b.`status` = ? limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "planStatus", Types.INTEGER, planStatus);
		parameters.setSensitive(i++, "workstatStatus", Types.INTEGER, workstatStatus);
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<DiagnosticPlanListPojo>)queryDao.query(sql, parameters, hints, diagnosticPlanListPojoRowMapper);
	}

}
