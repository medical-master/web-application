package com.medicalmaster.web.control.workstation;

import com.medicalmaster.common.Status;
import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.workstation.CreateWorkstationRequest;
import com.medicalmaster.web.control.WebContext;
import com.medicalmaster.web.helper.ResourceProxy;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class ModifyWorkstationAction implements Processor
{	
	@Override
	public void process(Context ctx) 
	{
		WebContext context = (WebContext) ctx;
		Status response = ResourceProxy.put(context,
				context.getBaseServiceUrl() + ResourceConstants.PATH_WORKSTATION + "/modifyWorkstation",
				CreateWorkstationRequest.class, Status.class);

		context.setResult(response.getMessage());
		context.setTargetPage("status.jsp");
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    修改工作站信息
 */