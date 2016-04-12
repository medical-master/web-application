package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class WorkstationExtDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;


	public WorkstationExtDao() throws SQLException {
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * findWorkstationsCnt
	**/
	public Long findWorkstationsCnt(Integer status, DalHints hints) throws SQLException {
		String sql = "select count(*) from workstation a where a.`status` = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "status", Types.INTEGER, status);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}

}
