package com.medicalmaster.common.notice;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.Notice;

/**
 * 公告通知内容信息
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryNoticeInfoResponse extends Response {
	private Notice notice;

	/**
	 * @return the notice
	 */
	public Notice getNotice() {
		return notice;
	}

	/**
	 * @param notice
	 *            the notice to set
	 */
	public void setNotice(Notice notice) {
		this.notice = notice;
	}

}
