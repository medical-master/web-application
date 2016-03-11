package com.medicalmaster.web.control;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class BuildResponseAction implements Processor {

	@Override
	public void process(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		try {
			rpc.getRequest().getRequestDispatcher("index.jsp").forward(rpc.getRequest(),rpc.getResponse());
		} catch (Exception e) {
			rpc.wrapException(e);
		}
	}
}
