package com.medicalmaster.web.control.workstation;

import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class PublishWorkstationAction implements Processor
{
	private String workstationResource = "workstations";
	
	@Override
	public void process(Context ctx) 
	{
		WebContext context = (WebContext)ctx;
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站信息发布
 */