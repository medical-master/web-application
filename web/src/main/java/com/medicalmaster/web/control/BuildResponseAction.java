package com.medicalmaster.web.control;

import java.io.IOException;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class BuildResponseAction implements Processor {

	@Override
	public void process(Context ctx) {
		WebContext rpc = (WebContext)ctx;
		try {
			rpc.getResponse().getWriter().print(rpc.getResult());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
