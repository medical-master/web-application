package com.medicalmaster.common.trainmeeting;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

/**
 * 培训会议列表查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryTrainMeetingsRequest extends PageRequest {
	@QueryParam("workstationId")
	/** 工作站ID */
	private Integer workstationId;

	@QueryParam("publishStatu")
	/** 发布状态 */
	private Integer publishStatu;

	/**
	 * @return the workstationId
	 */
	public Integer getWorkstationId() {
		return workstationId;
	}

	/**
	 * @param workstationId the workstationId to set
	 */
	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}

	/**
	 * @return the publishStatu
	 */
	public Integer getPublishStatu() {
		return publishStatu;
	}

	/**
	 * @param publishStatu the publishStatu to set
	 */
	public void setPublishStatu(Integer publishStatu) {
		this.publishStatu = publishStatu;
	}

	

}
