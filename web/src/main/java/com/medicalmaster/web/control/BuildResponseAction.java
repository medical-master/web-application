package com.medicalmaster.web.control;

import org.apache.commons.lang.StringUtils;

import com.medicalmaster.common.ExceptionWraper;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class BuildResponseAction implements Processor {

	@Override
	public void process(Context ctx) {
		WebContext rpc = (WebContext) ctx;
		try {
			String forwardPage = rpc.getForwardPage();
			if (StringUtils.isNotBlank(forwardPage)) {
				if (rpc.isRedirect()) {
					rpc.getResponse().sendRedirect(forwardPage);
				} else {
					rpc.getRequest().getRequestDispatcher(forwardPage).forward(rpc.getRequest(), rpc.getResponse());
				}
			} else {
				rpc.getRequest().getRequestDispatcher("index.jsp").forward(rpc.getRequest(), rpc.getResponse());
			}
		} catch (Exception e) {
			ExceptionWraper.wrap(e);
		}
	}
}
