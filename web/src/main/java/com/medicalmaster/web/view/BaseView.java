package com.medicalmaster.web.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicalmaster.web.control.WebContext;
import com.xross.tools.xunit.XunitFactory;

/**
 * 基础View
 *  
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class BaseView implements View{
	protected WebContext webContext;
	
	protected static XunitFactory factory;
	static{
		try{
			factory = XunitFactory.load("main.xunit");
		}catch(Exception exception){
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
}
