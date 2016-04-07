package com.medicalmaster.web.view.diagnostic;

import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class DiagnosticView  implements Processor 
{
	private String workstationResource = "workstations";

	@Override
	public void process(Context ctx) 
	{
		System.out.println("ddddddddddddddd");
		WebContext context = (WebContext) ctx;
		
		context.setTargetPage("status.jsp");
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站信息显示
 */