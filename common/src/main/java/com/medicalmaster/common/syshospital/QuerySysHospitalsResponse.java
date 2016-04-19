package com.medicalmaster.common.syshospital;

import java.util.List;

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
public class QuerySysHospitalsResponse extends Response {
	private List<SysHospital> hospitals;

	/**
	 * @return the hospitals
	 */
	public List<SysHospital> getHospitals() {
		return hospitals;
	}

	/**
	 * @param hospitals
	 *            the hospitals to set
	 */
	public void setHospitals(List<SysHospital> hospitals) {
		this.hospitals = hospitals;
	}

}
