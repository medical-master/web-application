package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import com.medicalmaster.common.sysproperty.QuerySysPropertyRequest;
import com.medicalmaster.common.sysproperty.QuerySysPropertyResponse;

/**
 * 
 * Created By guanrong.xie Created On 2016年4月6日 CopyRight@IMedMaster
 */
@Resource
@Path("/sysproperty")
public class SysPropertyResource extends Resources{
	protected String converterId = "sys property branch";
	protected static String xunitName = "sys_property.xunit";
	
	public QuerySysPropertyResponse querySysProperties(int categoryId, int parentId){
		return null;
	}
	
	
}
