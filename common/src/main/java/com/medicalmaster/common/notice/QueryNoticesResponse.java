package com.medicalmaster.common.notice;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.Notice;

/**
 * 公告通知列表查询
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryNoticesResponse extends PageResponse {
	private List<Notice> notices;

	/**
	 * @return the notices
	 */
	public List<Notice> getNotices() {
		return notices;
	}

	/**
	 * @param notices
	 *            the notices to set
	 */
	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

}
