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
	private String workstationId;

	@QueryParam("publishStatu")
	/** 发布状态 */
	private String publishStatu;

	/**
	 * @return the workstationId
	 */
	public String getWorkstationId() {
		return workstationId;
	}

	/**
	 * @param workstationId
	 *            the workstationId to set
	 */
	public void setWorkstationId(String workstationId) {
		this.workstationId = workstationId;
	}

	/**
	 * @return the publishStatu
	 */
	public String getPublishStatu() {
		return publishStatu;
	}

	/**
	 * @param publishStatu
	 *            the publishStatu to set
	 */
	public void setPublishStatu(String publishStatu) {
		this.publishStatu = publishStatu;
	}

}
