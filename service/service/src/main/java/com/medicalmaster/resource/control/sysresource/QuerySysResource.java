package com.medicalmaster.resource.control.sysresource;

import java.sql.SQLException;

import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.common.sysresource.QuerySysResourceInfoResponse;
import com.medicalmaster.dal.SysResource;
import com.xross.tools.xunit.Context;

/**
 * 系统资源查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QuerySysResource extends SysResourceConverter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.medicalmaster.resource.control.sysresource.SysResourceConverter#
	 * convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public Context convert(Context inputCtx) {
		IdRequest request = (IdRequest) inputCtx;
		QuerySysResourceInfoResponse response = new  QuerySysResourceInfoResponse();
		try{
			SysResource resource = manager.querySysResource(request);
			response.setSuccess(true);
			response.setMessage("查询成功");
			response.setResource(resource);
			
		}catch(SQLException exception){
			response.setSuccess(false);
			response.setMessage("数据库查询失败");
		}
		
		
		return response;
	}

}
