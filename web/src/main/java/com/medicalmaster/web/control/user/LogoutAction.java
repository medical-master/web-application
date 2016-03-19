package com.medicalmaster.web.control.user;

import javax.servlet.http.HttpSession;

import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Processor;

public class LogoutAction implements Processor {

	@Override
	public void process(Context ctx) {
		WebContext context = (WebContext)ctx;

		HttpSession s = context.getRequest().getSession();
		s.removeAttribute("userName");
		s.removeAttribute("userId");
		context.setResult("you are logout now");
		context.setTargetPage("status.jsp");
	}
}
