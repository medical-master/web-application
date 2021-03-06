package com.medicalmaster.domain.diagnosticplan;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.diagnosticplan.QueryDiagPlansRequest;
import com.medicalmaster.common.request.get.PageRequest;
import com.medicalmaster.dal.DiagPlanViewPojo;
import com.medicalmaster.dal.DiagnosticPlan;
import com.medicalmaster.dal.DiagnosticPlanDao;
import com.medicalmaster.dal.DiagnosticPlanExtDao;

public class DiagnosticPlanManager {
	private DiagnosticPlanDao dao;
	private DiagnosticPlanExtDao extDao;

	/**
	 * 创建构造方法
	 * 
	 * @throws SQLException
	 */
	public DiagnosticPlanManager() throws SQLException {
		dao = new DiagnosticPlanDao();
		extDao = new DiagnosticPlanExtDao();
	}

	/**
	 * 获取整个工作空间数据
	 * 
	 * @throws SQLException
	 * @return List<EdsWorkstation>
	 */
	public List<DiagnosticPlan> getAllDiagnosticPlan() throws SQLException {
		return dao.getAll(null);
	}

	/**
	 * 修改工作站信息
	 * 
	 * @throws SQLException
	 */
	public void updateDiagnosticPlan(DiagnosticPlan diagnosticPlan) throws SQLException {
		dao.update(null, diagnosticPlan);
	}

	/**
	 * 删除工作站信息
	 * 
	 * @throws SQLException
	 */
	public int removeDiagnosticPlan(Integer diagnosticPlanId) throws SQLException {
		DiagnosticPlan diagnosticPlan = new DiagnosticPlan();
		diagnosticPlan.setId(diagnosticPlanId);
		return dao.delete(null, diagnosticPlan);
	}

	/**
	 * 添加工作站信息
	 * 
	 * @throws SQLException
	 */
	public void insertWorkstationFollower() throws SQLException {
		DiagnosticPlan diagnosticPlan = new DiagnosticPlan();
		dao.insert(null, diagnosticPlan);
	}

	/**
	 * 查询信息
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public DiagnosticPlan queryInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}

	public Integer findDiagnosticPlansCnt(QueryDiagPlansRequest request) throws SQLException {
		List<DiagnosticPlan> plans = dao.findAllDiagnosticPlans(request.getWorkstationId(), request.getPublishStatus(),
				null);
		if (plans == null) {
			return 0;
		}

		return plans.size();
	}

	/**
	 * 获取工作站对应的相关诊疗方案信息
	 * 
	 * @param request
	 * @return
	 * @throws SQLException
	 */
	public List<DiagnosticPlan> findDiagnosticPlans(QueryDiagPlansRequest request) throws SQLException {
		return dao.findDiagnosticPlans(request.getWorkstationId(), request.getPublishStatus(), request.getPageNo(),
				request.getPageSize(), null);
	}

	public Integer findDiagPlanInfosCnt() throws SQLException {
		return extDao.findDiagPlanViewCnt(null).intValue();
	}

	public List<DiagPlanViewPojo> findDiagPlanInfos(PageRequest request) throws SQLException {
		return extDao.findDiagPlanView(request.getPageNo(), request.getPageSize(), null);
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version Date Author Note
 * ------------------------------------------------------------------------- 1.0
 * 2016-04-01 js 构造诊疗方案操类
 */
