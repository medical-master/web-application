package com.medicalmaster.domain.sysproperty;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.SysProperty;
import com.medicalmaster.dal.SysPropertyDao;

/**
 * 系统代码管理 Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class SysPropertyManager {
	private SysPropertyDao dao;

	/**
	 * 
	 */
	public SysPropertyManager() throws SQLException {
		dao = new SysPropertyDao();
	}

	/**
	 * 查询系统代码
	 * 
	 * @param categoryId
	 * @return
	 * @throws SQLException
	 */
	public List<SysProperty> getSysProperties(Integer categoryId) throws SQLException {
		return dao.findSysProperties(categoryId, null, null);
	}

	/**
	 * 查询系统代码
	 * 
	 * @param categoryId
	 * @param parentId
	 * @return
	 * @throws SQLException
	 */
	public List<SysProperty> getSysProperties(Integer categoryId, Integer parentId) throws SQLException {
		return dao.findSysProperties(categoryId, parentId, null);
	}
}
