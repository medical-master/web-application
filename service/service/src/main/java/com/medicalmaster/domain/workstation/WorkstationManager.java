package com.medicalmaster.domain.workstation;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.EdsWorkstation;
import com.medicalmaster.dal.EdsWorkstationDao;

public class WorkstationManager 
{
	private EdsWorkstationDao dao;
	
	/**
	 * 创建构造方法
	 * @throws SQLException
	 */
	public WorkstationManager() throws SQLException 
	{
		dao = new EdsWorkstationDao();
	}
	
	/**
	 * 获取整个工作空间数据
	 * @throws SQLException 
	 * @return List<EdsWorkstation>
	 */
	public List<EdsWorkstation> getAllWorkstation() throws SQLException 
	{
		return dao.getAll(null);
	}
	
	/**
	 * 修改工作站信息
	 * @throws SQLException 
	 */
	public void updateWorkstation(EdsWorkstation edsWorkstation) throws SQLException 
	{
		dao.update(null, edsWorkstation);
	}
	
	/**
	 * 删除工作站信息
	 * @throws SQLException 
	 */
	public int removeWorkstation(Integer workstationId) throws SQLException
	{
		EdsWorkstation edsWorkstation = new EdsWorkstation();
		edsWorkstation.setWorkstationId(workstationId);
		return dao.delete(null, edsWorkstation);
	}
	
	/**
	 * 添加工作站信息
	 * @throws SQLException
	 */
	public void insertWorkstation() throws SQLException
	{
		EdsWorkstation edsWorkstation = new EdsWorkstation();
		dao.insert(null, edsWorkstation);
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note			
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	构造工作站基本信息操类
 */