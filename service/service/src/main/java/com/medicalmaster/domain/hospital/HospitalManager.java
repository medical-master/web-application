package com.medicalmaster.domain.hospital;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.syshospital.QuerySysHospitalsRequest;
import com.medicalmaster.dal.SysHospital;
import com.medicalmaster.dal.SysHospitalDao;

/**
 * 医院
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class HospitalManager {
	Logger log = LoggerFactory.getLogger(HospitalManager.class);

	SysHospitalDao dao;

	/**
	 * 
	 */
	public HospitalManager() throws SQLException {
		dao = new SysHospitalDao();
	}

	public List<SysHospital> querySysHospitals(QuerySysHospitalsRequest request) {
		// TODO
		return null;
	}

	public SysHospital querySysHospitalInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}
}
