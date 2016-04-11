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

	public Integer countNotices(QueryNoticesRequest request) throws SQLException {
		List<Integer> list = dao.findNoticesCnt(request.getStatus(), null);
		if (list == null) {
			return 0;
		}

		return list.size();
	}

	public List<Notice> queryNotices(QueryNoticesRequest request) throws SQLException {
		return dao.findNotice(request.getStatus(), request.getPageSize(), request.getPageNo(), null);
	}

	public Notice queryNoticeInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}

}
