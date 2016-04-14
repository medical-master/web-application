package com.medicalmaster.web.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicalmaster.common.helper.ParseHelper;
import com.medicalmaster.common.request.get.PageRequest;
import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.XunitFactory;

/**
 * 基础View
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class BaseView implements View {
	protected WebContext webContext;
	protected static XunitFactory factory;

	static {
		try {
			factory = XunitFactory.load("main.xunit");
		} catch (Exception exception) {
		}

	}

	/**
	 * @throws Exception
	 * 
	 */
	public BaseView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		webContext = new WebContext(request, response);
		factory.getProcessor("populate").process(webContext);
	}

	protected void getPageParameters(PageRequest request) {
		if (request == null) {
			return;
		}

		Integer pageNo = null;
		Integer pageSize = null;
		Integer recordCnt = null;
		Long cacheTime = null;
		try {
			pageNo = ParseHelper.parseInt(webContext.getParameter("pageNo"));
		} catch (Exception exception) {
		}

		try {
			pageSize = ParseHelper.parseInt(webContext.getParameter("pageSize"));
		} catch (Exception exception) {
		}

		try {
			recordCnt = ParseHelper.parseInt(webContext.getParameter("recordCnt"));
		} catch (Exception exception) {
		}

		try {
			cacheTime = ParseHelper.parseLong(webContext.getParameter("cacheTime"));
		} catch (Exception exception) {
		}

		request.setPageNo(pageNo);
		request.setPageSize(pageSize);
		request.setRecordCnt(recordCnt);
		request.setCacheTime(cacheTime);
	}
}
