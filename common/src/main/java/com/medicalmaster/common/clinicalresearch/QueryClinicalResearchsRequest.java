package com.medicalmaster.common.clinicalresearch;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.get.PageRequest;

/**
 * 临床研究列表查询请求
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryClinicalResearchsRequest extends PageRequest {
	@QueryParam("workstationId")
	private Integer workstationId;

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

}
