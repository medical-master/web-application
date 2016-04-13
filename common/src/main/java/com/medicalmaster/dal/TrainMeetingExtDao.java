package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class TrainMeetingExtDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;





	public TrainMeetingExtDao() throws SQLException {
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * findAllCnt
	**/
	public Long findAllCnt(DalHints hints) throws SQLException {
		String sql = "select count(*) from train_meeting";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByWorkstationCnt
	**/
	public Long findByWorkstationCnt(Integer workstationId, DalHints hints) throws SQLException {
		String sql = "select count(*) from train_meeting where workstationId = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByPublishStatusCnt
	**/
	public Long findByPublishStatusCnt(Integer publishstatus, DalHints hints) throws SQLException {
		String sql = "select count(*) from train_meeting where publishstatus = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "publishstatus", Types.INTEGER, publishstatus);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}
	/**
	 * findByWorkstationAndStatusCnt
	**/
	public Long findByWorkstationAndStatusCnt(Integer workstationId, Integer publishStatus, DalHints hints) throws SQLException {
		String sql = "select count(*) from train_meeting where workstationId = ? and publishStatus = ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "workstationId", Types.INTEGER, workstationId);
		parameters.setSensitive(i++, "publishStatus", Types.INTEGER, publishStatus);
		return queryDao.queryForObjectNullable(sql, parameters, hints, Long.class);
	}

}
