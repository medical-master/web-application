package com.medicalmaster.web.control.diagnostic;

import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class CreateDiagnosticAction implements Processor
{
	private String diagnosisResource = "diagnosis";
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
 * 1.0         2016-04-01        	js        	  	添加诊疗方案信息
 */
