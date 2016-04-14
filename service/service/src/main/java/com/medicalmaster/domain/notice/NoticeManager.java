package com.medicalmaster.domain.notice;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.dal.Notice;
import com.medicalmaster.dal.NoticeDao;
import com.medicalmaster.dal.NoticeExtDao;

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
	NoticeExtDao extDao;

	/**
	 * 
	 */
	public NoticeManager() throws SQLException {
		dao = new NoticeDao();
		extDao = new NoticeExtDao();
	}

	public Integer countNotices(QueryNoticesRequest request) throws SQLException {
		if (request.getStatus() == null) {
			return extDao.findAllCnt(null).intValue();
		} else {
			return extDao.findByPublishstatusCnt(request.getStatus(), null).intValue();
		}
	}

	public List<Notice> queryNotices(QueryNoticesRequest request) throws SQLException {
		return dao.findNotice(request.getStatus(), request.getPageNo(), request.getPageSize(), null);
	}

	public Notice queryNoticeInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}

}
