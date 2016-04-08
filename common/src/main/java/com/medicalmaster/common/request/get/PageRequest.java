package com.medicalmaster.common.request.get;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.Request;

/**
 * 分页请求
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class PageRequest extends Request {
	@DefaultValue("1")
	@QueryParam("pageNo")
	private Integer pageNo;

	@DefaultValue("10")
	@QueryParam("pageSize")
	private Integer pageSize;

	/**
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
