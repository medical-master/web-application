package com.medicalmaster.common.syshospital;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.SysHospital;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月19日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QuerySysHospitalInfoResponse extends Response {
	private SysHospital hospital;

	/**
	 * @return the hospital
	 */
	public SysHospital getHospital() {
		return hospital;
	}

	/**
	 * @param hospital
	 *            the hospital to set
	 */
	public void setHospital(SysHospital hospital) {
		this.hospital = hospital;
	}
}
