package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import com.medicalmaster.common.bean.ResourceConstants;

/**
 * 医院
 * 
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月6日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path(ResourceConstants.PATH_HOSPITAL)
public class HospitalResource extends Resources {
	public HospitalResource() {
		super("hospital.xunit", "hospital branch");
	}
	
}
