package com.medicalmaster.common.diagnosticplan;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

/**
 * 诊疗方案列表
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryDiagPlansRequest extends PageRequest {
	@QueryParam("workstationId")
	private Integer workstationId;

	@QueryParam("publishStatus")
	private Integer publishStatus;

	/**
	 * @return the workstationId
	 */
	public Integer getWorkstationId() {
		return workstationId;
	}

	/**
	 * @param workstationId
	 *            the workstationId to set
	 */
	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}

	/**
	 * @return the publishStatus
	 */
	public Integer getPublishStatus() {
		return publishStatus;
	}

	/**
	 * @param publishStatus
	 *            the publishStatus to set
	 */
	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
	}

}
