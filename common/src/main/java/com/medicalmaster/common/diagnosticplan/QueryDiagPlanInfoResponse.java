package com.medicalmaster.common.diagnosticplan;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.DiagnosticPlan;

/**
 * 诊疗方案
 * 
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlanInfoResponse extends Response {
	private DiagnosticPlan plan;

	/**
	 * @return the plan
	 */
	public DiagnosticPlan getPlan() {
		return plan;
	}

	/**
	 * @param plan the plan to set
	 */
	public void setPlan(DiagnosticPlan plan) {
		this.plan = plan;
	}
	
	
}
