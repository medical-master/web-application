package com.medicalmaster.common.request.post;

import javax.ws.rs.FormParam;

import com.medicalmaster.common.request.Request;

/**
 * Id请求
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class IdRequest extends Request {
	@FormParam("id")
	private Integer id;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
