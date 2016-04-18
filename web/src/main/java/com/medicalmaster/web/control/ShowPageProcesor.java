package com.medicalmaster.web.control;

import org.apache.commons.lang.StringUtils;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class ShowPageProcesor implements Processor {
	/** 查看，在index.jsp中显示 */
	static final String VIEW_PAGE = "view";
	/** 跳转，独立显示 */
	static final String JUMP_PAGE = "jump";

	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext) ctx;
		String pageToShow = context.getRequest().getParameter(VIEW_PAGE);
		if (StringUtils.isNotBlank(pageToShow)) {
			context.setTargetPage(pageToShow + ".jsp");
			return;
		}

		String pageToJump = context.getRequest().getParameter(JUMP_PAGE);
		if (StringUtils.isNotBlank(pageToJump)) {
			context.setForwardPage(pageToJump + ".jsp");
			return;
		}
	}
}
