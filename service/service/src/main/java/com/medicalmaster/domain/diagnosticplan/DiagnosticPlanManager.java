package com.medicalmaster.domain.diagnosticplan;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.DiagnosticPlan;
import com.medicalmaster.dal.DiagnosticPlanDao;

public class DiagnosticPlanManager 
{
	private DiagnosticPlanDao dao;
	
	/**
	 * 创建构造方法
	 * @throws SQLException
	 */
	public DiagnosticPlanManager() throws SQLException 
	{
		dao = new DiagnosticPlanDao();
	}
	
	/**
	 * 获取整个工作空间数据
	 * @throws SQLException 
	 * @return List<EdsWorkstation>
	 */
	public List<DiagnosticPlan> getAllDiagnosticPlan() throws SQLException 
	{
		return dao.getAll(null);
	}
	
	/**
	 * 修改工作站信息
	 * @throws SQLException 
	 */
	public void updateDiagnosticPlan(DiagnosticPlan diagnosticPlan) throws SQLException 
	{
		dao.update(null, diagnosticPlan);
	}
	
	/**
	 * 删除工作站信息
	 * @throws SQLException 
	 */
	public int removeDiagnosticPlan(Integer diagnosticPlanId) throws SQLException
	{
		DiagnosticPlan diagnosticPlan = new DiagnosticPlan();
		diagnosticPlan.setId(diagnosticPlanId);
		return dao.delete(null, diagnosticPlan);
	}
	
	/**
	 * 添加工作站信息
	 * @throws SQLException
	 */
	public void insertWorkstationFollower() throws SQLException
	{
		DiagnosticPlan diagnosticPlan = new DiagnosticPlan();
		dao.insert(null, diagnosticPlan);
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note			
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	     构造诊疗方案操类
 */