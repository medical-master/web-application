package com.medicalmaster.domain.sysproperty;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.SystemProperty;
import com.medicalmaster.dal.SystemPropertyDao;

/**
 * 系统代码管理 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class SysPropertyManager {
	private SystemPropertyDao dao;

	/**
	 * 
	 */
	public SysPropertyManager() throws SQLException {
		dao = new SystemPropertyDao();
	}

	/**
	 * 查询系统代码
	 * 
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 */
	public List<SystemProperty> getSysProperties(int categoryId) throws SQLException {
		// TODO
		return null;
	}

	/**
	 * 查询系统代码
	 * 
	 * @param categoryId
	 * @param parentId
	 * @return
	 * @throws SQLException
	 */
	public List<SystemProperty> getSysProperties(int categoryId, int parentId) throws SQLException {
		// TOTO
		return null;
	}
}
