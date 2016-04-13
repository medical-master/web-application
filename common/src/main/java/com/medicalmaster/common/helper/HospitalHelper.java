package com.medicalmaster.common.helper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.dal.SysHospital;
import com.medicalmaster.dal.SysHospitalDao;

/**
 * 医院帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月13日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class HospitalHelper {
	static Logger log = LoggerFactory.getLogger(HospitalHelper.class);
	static Map<Integer, SysHospital> map;
	static SysHospitalDao dao;

	static {
		try {
			dao = new SysHospitalDao();
			map = new HashMap<Integer, SysHospital>();

		} catch (SQLException exception) {
			log.error("HospitalHelper", exception);
		}
	}

	public static void load() {
		try {
			List<SysHospital> hospitals = dao.getAll(null);
			for (SysHospital hospital : hospitals) {
				map.put(hospital.getHospitalId(), hospital);
			}
		} catch (SQLException exception) {
			log.error("load failed!", exception);
		}
	}

	static void load(Integer id) {
		try {
			SysHospital hospital = dao.queryByPk(id, null);
			map.put(hospital.getHospitalId(), hospital);
		} catch (SQLException exception) {
			log.error("load by id {} failed!", id, exception);
		}
	}

	public static SysHospital getHospital(Integer id) {
		if (!map.containsKey(id)) {
			load(id);
		}

		return map.get(id);
	}

	public static String getName(Integer id) {
		SysHospital hospital = getHospital(id);
		if (hospital != null) {
			return hospital.getName();
		}

		return null;
	}

	public static void release() {
		map.clear();
	}
}
