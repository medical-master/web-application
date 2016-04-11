package com.medicalmaster.resource.control.sysresource;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.bean.request.HttpServletContext;
import com.medicalmaster.common.sysresource.SysResourceUploadResponse;
import com.medicalmaster.dal.SysResource;
import com.xross.tools.xunit.Context;

/**
 * 系统资源上传
 * 
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SysResourceUpload extends SysResourceConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.sysresource.SysResourceConverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		HttpServletContext request = (HttpServletContext) inputCtx;
		SysResourceUploadResponse response = new SysResourceUploadResponse();
		try {
			List<SysResource> resources = manager.upload(request);
			response.setSuccess(true);
			response.setResources(resources);
			response.setMessage("资源上传成功");

		} catch (SQLException exception) {
			response.setSuccess(false);
			response.setMessage("资源上传失败");
		}

		return response;
	}

}
