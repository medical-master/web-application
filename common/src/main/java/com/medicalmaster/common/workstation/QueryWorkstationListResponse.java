package com.medicalmaster.common.workstation;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.Workstation;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryWorkstationListResponse extends PageResponse {
	private List<Workstation> workstations;

	/**
	 * @return the workstations
	 */
	public List<Workstation> getWorkstations() {
		return workstations;
	}

	/**
	 * @param workstations
	 *            the workstations to set
	 */
	public void setWorkstations(List<Workstation> workstations) {
		this.workstations = workstations;
	}

}
