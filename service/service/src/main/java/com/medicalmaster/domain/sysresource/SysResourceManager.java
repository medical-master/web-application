package com.medicalmaster.domain.sysresource;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.bean.request.HttpServletContext;
import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.common.sysresource.SysResourceUploadRequest;
import com.medicalmaster.dal.SysResource;
import com.medicalmaster.dal.SysResourceDao;
import com.medicalmaster.dal.SysResourceRelateDao;

/**
 * 系统资源管理
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SysResourceManager {
	static Logger logger = LoggerFactory.getLogger(SysResourceManager.class);
	SysResourceDao resourceDao;
	SysResourceRelateDao relateDao;

	/**
	 * 
	 */
	public SysResourceManager() throws SQLException {
		resourceDao = new SysResourceDao();
		relateDao = new SysResourceRelateDao();
	}

	public List<SysResource> upload(HttpServletContext context) throws SQLException {
		SysResourceUploadRequest request = (SysResourceUploadRequest) context.getInputContext();
		HttpServletRequest httpServletRequest = context.getHttpServletRequest();

		
		return null;
	}

	public SysResource querySysResource(IdRequest request) throws SQLException {
		// TODO
		return null;
	}

	public void download(HttpServletContext context) throws SQLException {
		// TODO
	}
}
