package com.medicalmaster.dal;

import com.ctrip.platform.dal.dao.*;
import com.ctrip.platform.dal.dao.helper.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.ctrip.platform.dal.dao.helper.*;

public class UserMienExtDao {

	private static final String DATA_BASE = "medical-master";
	
	private DalQueryDao queryDao = null;

	private DalRowMapper<UserMienViewPojo> userMienViewPojoRowMapper = null;

	public UserMienExtDao() throws SQLException {
		this.userMienViewPojoRowMapper = new DalDefaultJpaMapper(UserMienViewPojo.class);
		this.queryDao = new DalQueryDao(DATA_BASE);
	}
	/**
	 * 个人风采信息
	**/
	public List<UserMienViewPojo> queryUserMien(Integer userId, int pageNo, int pageSize, DalHints hints) throws SQLException {
		String sql = "SELECT um.mienType, um.begYear, um.endYear, um.description, um.publishStatu FROM User_MIEN um WHERE um.userId = ? AND um.publishStatu = 1 limit ?, ?";
		StatementParameters parameters = new StatementParameters();
		hints = DalHints.createIfAbsent(hints);
		int i = 1;
		parameters.setSensitive(i++, "userId", Types.INTEGER, userId);
		parameters.set(i++, Types.INTEGER, (pageNo - 1) * pageSize);
		parameters.set(i++, Types.INTEGER, pageSize);
		return (List<UserMienViewPojo>)queryDao.query(sql, parameters, hints, userMienViewPojoRowMapper);
	}

}
