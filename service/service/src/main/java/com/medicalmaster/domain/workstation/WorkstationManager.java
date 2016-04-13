package com.medicalmaster.domain.workstation;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.workstation.QueryWorkstationInfoRequeset;
import com.medicalmaster.common.workstation.QueryWorkstationListRequest;
import com.medicalmaster.common.workstation.QueryWorkstationRequest;
import com.medicalmaster.dal.Workstation;
import com.medicalmaster.dal.WorkstationDao;
import com.medicalmaster.dal.WorkstationExtDao;
import com.medicalmaster.dal.WorkstationViewDao;
import com.medicalmaster.dal.WorkstationViewPojoPojo;

public class WorkstationManager {
	private WorkstationViewDao viewDao;
	private WorkstationDao dao;
	private WorkstationExtDao extDao;

	/**
	 * 创建构造方法
	 * @throws SQLException
	 */
	public WorkstationManager() throws SQLException 
	{
		viewDao = new WorkstationViewDao();
		dao = new WorkstationDao();
		extDao = new WorkstationExtDao();
	}

	/**
	 * 获取整个工作空间数据
	 * @throws SQLException
	 * @return List<EdsWorkstation>
	 */
	public List<WorkstationViewPojoPojo> getAllWorkstation(QueryWorkstationRequest request) throws SQLException 
	{
		return viewDao.showWorkstation(request.getPageNo(), request.getPageSize(), null);
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

	/**
	 * 查询指定的工作站详细信息
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public WorkstationViewPojoPojo queryWorkstationInfo(QueryWorkstationInfoRequeset requeset) throws SQLException {
		return viewDao.showWorkstationInfo(requeset.getWorkstationId(), null);
	}

	/**
	 * 获取首页工作站总数
	 * @param request
	 * @return Integer
	 * @throws SqlException
	 */
	public Integer countWorkstation(QueryWorkstationRequest request) throws SQLException 
	{
		Long count = viewDao.count(null);
		return Integer.parseInt(count.toString());
	}
	
	/**
	 * 获取首页工作站列表总数
	 * @param request
	 * @return Integer
	 * @throws SqlException
	 */
	public Integer queryWorksationListCnt(QueryWorkstationListRequest request) throws SQLException 
	{
		return extDao.findWorkstationsCnt(request.getStatus(), null).intValue();
	}

	/**
	 * 获取首页工作站列表数据
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<Workstation> queryWorkstationList(QueryWorkstationListRequest request) throws SQLException 
	{
		return dao.findWorkstations(request.getStatus(), request.getPageNo(), request.getPageSize(), null);
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version 				Date 				Author					Note
 * ------------------------------------------------------------------------- 
 * 1.0				2016-04-01 				 js 			构造工作站基本信息操类
 */