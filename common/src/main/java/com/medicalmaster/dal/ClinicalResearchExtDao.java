package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class ClinicalResearchExtDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;



	public ClinicalResearchExtDao() throws SQLException {
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * findAllCnt
	**/
	public Long findAllCnt(DalHints hints) throws SQLException {
		String sql = "select count(*) from clinical_research";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByWorkstationIdCnt
	**/
	public Long findByWorkstationIdCnt(Integer workstationId, DalHints hints) throws SQLException {
		String sql = "select count(*) from clinical_research where workstationid = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}

}
