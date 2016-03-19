package com.medicalmaster.web.control;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class ShowPageProcesor implements Processor{

	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;
		String pageToShow = context.getRequest().getParameter("view");
		context.setTargetPage(pageToShow +".jsp");
	}
}
