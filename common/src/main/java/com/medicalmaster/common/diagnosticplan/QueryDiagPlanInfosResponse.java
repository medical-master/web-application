package com.medicalmaster.common.diagnosticplan;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.DiagnosticPlanExtDao;
import com.medicalmaster.dal.DiagnosticPlanListPojo;

/**
 * 诊疗方案详情列表
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlanInfosResponse extends PageResponse {
	private List<DiagnosticPlanListPojo> pojos;

	/**
	 * @return the pojos
	 */
	public List<DiagnosticPlanListPojo> getPojos() {
		return pojos;
	}

	/**
	 * @param pojos
	 *            the pojos to set
	 */
	public void setPojos(List<DiagnosticPlanListPojo> pojos) {
		this.pojos = pojos;
	}

}
