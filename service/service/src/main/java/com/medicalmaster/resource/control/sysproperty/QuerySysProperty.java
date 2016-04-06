package com.medicalmaster.resource.control.sysproperty;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.sysproperty.QuerySysPropertyResponse;
import com.medicalmaster.dal.SysProperty;
import com.medicalmaster.domain.sysproperty.SysPropertyManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 查询系统代码
 * 
 * Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
public class QuerySysProperty implements Converter {
	static Logger logger = LoggerFactory.getLogger(QuerySysProperty.class);

	private static SysPropertyManager manager;

	static {
		try {
			manager = new SysPropertyManager();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		QuerySysPropertyRequest request = (QuerySysPropertyRequest) inputCtx;

		logger.info("categoryId {}; parentId {}", request.getCategoryId(), request.getParentId());

		QuerySysPropertyResponse response = new QuerySysPropertyResponse();

		try {
			List<SysProperty> properties = null;

			if (request.getParentId() == null) {
				properties = manager.getSysProperties(request.getCategoryId());
			} else {
				properties = manager.getSysProperties(request.getCategoryId(), request.getParentId());
			}
			response.setProperties(properties);
			response.setSuccess(true);
			response.setMessage("查询成功");
		} catch (SQLException exception) {
			logger.error("QuerySysProperty error, categoryId {}, parentId {}", request.getCategoryId(),
					request.getParentId(), exception);
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}

		return response;
	}

}
