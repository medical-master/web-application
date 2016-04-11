package com.medicalmaster.common.sysresource;

import javax.ws.rs.FormParam;

import com.medicalmaster.common.request.Request;

/**
 * 资源上传请求
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SysResourceUploadRequest extends Request {

	@FormParam("desc")
	private String desc;

	@FormParam("alloDownload")
	private String allowDownload;

	@FormParam("userId")
	private String userId;

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * @return the allowDownload
	 */
	public String getAllowDownload() {
		return allowDownload;
	}

	/**
	 * @param allowDownload
	 *            the allowDownload to set
	 */
	public void setAllowDownload(String allowDownload) {
		this.allowDownload = allowDownload;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

}
