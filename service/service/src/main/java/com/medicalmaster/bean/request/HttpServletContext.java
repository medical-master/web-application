package com.medicalmaster.bean.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriInfo;

import com.medicalmaster.common.request.Request;
import com.xross.tools.xunit.Context;

/**
 * 代码HttpServlet Context的Xunit Context
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class HttpServletContext extends Request {
	@javax.ws.rs.core.Context
	private HttpServletRequest httpServletRequest;

	@javax.ws.rs.core.Context
	private HttpServletResponse httpServletResponse;

	@javax.ws.rs.core.Context
	private UriInfo uriInfo;

	private Context inputContext;

	/**
	 * @return the httpServletRequest
	 */
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	/**
	 * @param httpServletRequest
	 *            the httpServletRequest to set
	 */
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}

	/**
	 * @return the httpServletResponse
	 */
	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}

	/**
	 * @param httpServletResponse
	 *            the httpServletResponse to set
	 */
	public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
		this.httpServletResponse = httpServletResponse;
	}

	/**
	 * @return the uriInfo
	 */
	public UriInfo getUriInfo() {
		return uriInfo;
	}

	/**
	 * @param uriInfo
	 *            the uriInfo to set
	 */
	public void setUriInfo(UriInfo uriInfo) {
		this.uriInfo = uriInfo;
	}

	/**
	 * @return the inputContext
	 */
	public Context getInputContext() {
		return inputContext;
	}

	/**
	 * @param inputContext
	 *            the inputContext to set
	 */
	public void setInputContext(Context inputContext) {
		this.inputContext = inputContext;
	}

}
