package com.medicalmaster.domain.workstation;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.Workstation;
import com.medicalmaster.dal.WorkstationDao;

public class WorkstationManager 
{
	private WorkstationDao dao;
	
	/**
	 * 创建构造方法
	 * @throws SQLException
	 */
	public WorkstationManager() throws SQLException 
	{
		dao = new WorkstationDao();
	}
	
	/**
	 * 获取整个工作空间数据
	 * @throws SQLException 
	 * @return List<EdsWorkstation>
	 */
	public List<Workstation> getAllWorkstation() throws SQLException 
	{
		return dao.getAll(null);
	}
	
	/**
	 * 修改工作站信息
	 * @throws SQLException 
	 */
	public void updateWorkstation(Workstation edsWorkstation) throws SQLException 
	{
		dao.update(null, edsWorkstation);
	}
	
	/**
	 * 删除工作站信息
	 * @throws SQLException 
	 */
	public int removeWorkstation(Integer workstationId) throws SQLException
	{
		Workstation workstation = new Workstation();
		workstation.setWorkstationId(workstationId);
		return dao.delete(null, workstation);
	}
	
	/**
	 * 添加工作站信息
	 * @throws SQLException
	 */
	public void insertWorkstation() throws SQLException
	{
		Workstation workstation = new Workstation();
		dao.insert(null, workstation);
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note			
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	构造工作站基本信息操类
 */