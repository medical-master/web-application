package com.medicalmaster.common.diagnosticplan;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

/**
 * 诊疗方案详情列表
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlanInfosRequest extends PageRequest {
	/**
	 * 方案状态
	 */
	@QueryParam("planStatus")
	@DefaultValue("40")
	public Integer planStatus;

	/**
	 * 工作站状态
	 */
	@QueryParam("workstatStatus")
	@DefaultValue("1")
	public Integer workstatStatus;

	/**
	 * @return the planStatus
	 */
	public Integer getPlanStatus() {
		return planStatus;
	}

	/**
	 * @param planStatus
	 *            the planStatus to set
	 */
	public void setPlanStatus(Integer planStatus) {
		this.planStatus = planStatus;
	}

	/**
	 * @return the workstatStatus
	 */
	public Integer getWorkstatStatus() {
		return workstatStatus;
	}

	/**
	 * @param workstatStatus
	 *            the workstatStatus to set
	 */
	public void setWorkstatStatus(Integer workstatStatus) {
		this.workstatStatus = workstatStatus;
	}

}
