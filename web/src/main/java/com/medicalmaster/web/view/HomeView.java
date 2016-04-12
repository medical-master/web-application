package com.medicalmaster.web.view;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.common.notice.QueryNoticesResponse;
import com.medicalmaster.common.trainmeeting.QueryTrainMeetingsRequest;
import com.medicalmaster.dal.Notice;
import com.medicalmaster.dal.TrainMeeting;
import com.medicalmaster.web.helper.ResourceProxy;

/**
 * 主页View
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class HomeView extends BaseView {
	static Logger logger = LoggerFactory.getLogger(HomeView.class);

	/**
	 * @throws Exception
	 * 
	 */
	public HomeView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super(request, response);
	}

	/**
	 * 查询最新的通知
	 * 
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws UnsupportedEncodingException 
	 */
	public Notice getLastedNotice() throws IllegalArgumentException, IllegalAccessException, UnsupportedEncodingException {
		QueryNoticesRequest req = new QueryNoticesRequest();
		QueryNoticesResponse response = ResourceProxy
				.get(webContext.getBaseServiceUrl() + ResourceConstants.PATH_NOTICE, req, QueryNoticesResponse.class);
		
		if (response.isSuccess()) {
			List<Notice> notices = response.getNotices();
			if (notices.size() > 0) {
				logger.info("title{}", notices.get(0).getTitle());
				return notices.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
	
	public List<TrainMeeting> getTrainMeetings(){
		QueryTrainMeetingsRequest request = new QueryTrainMeetingsRequest();
		request.setPublishStatu(40);
		request.setPageNo(1);
		request.setPageSize();
		
	}

}
