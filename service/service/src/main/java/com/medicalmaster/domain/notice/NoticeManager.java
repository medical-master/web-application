package com.medicalmaster.domain.notice;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.dal.Notice;
import com.medicalmaster.dal.NoticeDao;

/**
 * 公告通知
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class NoticeManager {
	NoticeDao dao;

	/**
	 * 
	 */
	public NoticeManager() throws SQLException {
		dao = new NoticeDao();
	}

	public Integer countNotices() throws SQLException {
		return dao.count(null);
	}

	public List<Notice> queryNotices(QueryNoticesRequest request) throws SQLException {
		return dao.queryByPage(request.getPageSize(), request.getPageNo(), null);
	}

	public Notice queryNoticeInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}

}
