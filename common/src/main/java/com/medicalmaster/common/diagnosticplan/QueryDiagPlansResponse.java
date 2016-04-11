package com.medicalmaster.common.diagnosticplan;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.DiagnosticPlan;

/**
 * 诊疗方案列表
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlansResponse extends PageResponse {
	private List<DiagnosticPlan> plans;

	/**
	 * @return the plans
	 */
	public List<DiagnosticPlan> getPlans() {
		return plans;
	}

	/**
	 * @param plans
	 *            the plans to set
	 */
	public void setPlans(List<DiagnosticPlan> plans) {
		this.plans = plans;
	}

}
