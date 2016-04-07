package com.medicalmaster.domain.workstation;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.WorkstationFollower;
import com.medicalmaster.dal.WorkstationFollowerDao;

public class WorkstationFollowerManager 
{
	private WorkstationFollowerDao dao;
	
	/**
	 * 创建构造方法
	 * @throws SQLException
	 */
	public WorkstationFollowerManager() throws SQLException 
	{
		dao = new WorkstationFollowerDao();
	}
	
	/**
	 * 获取整个工作空间数据
	 * @throws SQLException 
	 * @return List<EdsWorkstation>
	 */
	public List<WorkstationFollower> getAllWorkstationFollower() throws SQLException 
	{
		return dao.getAll(null);
	}
	
	/**
	 * 修改工作站信息
	 * @throws SQLException 
	 */
	public void updateWorkstationFollower(WorkstationFollower edsWorkstationFollower) throws SQLException 
	{
		dao.update(null, edsWorkstationFollower);
	}
	
	/**
	 * 删除工作站信息
	 * @throws SQLException 
	 */
	public int removeWorkstation(Integer workstationFollowerId) throws SQLException
	{
		WorkstationFollower workstationFollower = new WorkstationFollower();
		workstationFollower.setId(workstationFollowerId);
		return dao.delete(null, workstationFollower);
	}
	
	/**
	 * 添加工作站信息
	 * @throws SQLException
	 */
	public void insertWorkstationFollower() throws SQLException
	{
		WorkstationFollower workstationFollower = new WorkstationFollower();
		dao.insert(null, workstationFollower);
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note			
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	构造工作站追随者操类
 */