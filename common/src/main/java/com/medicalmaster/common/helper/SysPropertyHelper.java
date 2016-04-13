package com.medicalmaster.common.helper;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.dal.SysProperty;
import com.medicalmaster.dal.SysPropertyDao;

/**
 * 系统代码帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月12日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SysPropertyHelper {
	static Logger log = LoggerFactory.getLogger(SysPropertyHelper.class);

	static SysPropertyDao dao;
	static Map<String, SysProperty> map;

	static {
		try {
			dao = new SysPropertyDao();
			map = new HashMap<String, SysProperty>();
		} catch (SQLException exception) {
			log.error("inited failed!", exception);
		}
	}

	static String generateKey(Integer categoryId, Integer propertyId) {
		return categoryId + "_" + propertyId;
	}

	static String generateKey(SysProperty property) {
		if (property == null) {
			return null;
		}

		return property.getCategoryId() + "_" + property.getPropertyId();
	}

	public static void load(Integer categoryId, Integer propertyId) {
		try {
			SysProperty property = dao.queryByPk(categoryId, propertyId, null);
			String key = generateKey(categoryId, propertyId);
			map.put(key, property);
		} catch (SQLException exception) {
			log.error("categoryId {}, propertyId {} load failed!", categoryId, propertyId, exception);
		}
	}

	public static void load(Integer categoryId) {
		try {
			List<SysProperty> properties = dao.findSysProperties(categoryId, null, null);
			if (properties == null) {
				return;
			}

			for (SysProperty sysProperty : properties) {
				String key = generateKey(sysProperty);
				map.put(key, sysProperty);
			}
		} catch (SQLException exception) {
			log.error("categoryId {},  load failed!", categoryId, exception);
		}
	}

	static SysProperty getSysProperty(Integer categoryId, Integer propertyId) {
		String key = generateKey(categoryId, propertyId);
		if (!map.containsKey(key)) {
			load(categoryId, propertyId);
		}

		return map.get(key);
	}

	public static String getName(Integer categoryId, Integer propertyId) {
		SysProperty property = getSysProperty(categoryId, propertyId);
		if (property != null) {
			return property.getName();
		} else {
			return null;
		}
	}

	public static String getDesc(Integer categoryId, Integer propertyId) {
		SysProperty property = getSysProperty(categoryId, propertyId);
		if (property != null) {
			return property.getDescription();
		} else {
			return null;
		}
	}

	public static String getAlias(Integer categoryId, Integer propertyId) {
		SysProperty property = getSysProperty(categoryId, propertyId);
		if (property != null) {
			return property.getAlias();
		} else {
			return null;
		}
	}
}
