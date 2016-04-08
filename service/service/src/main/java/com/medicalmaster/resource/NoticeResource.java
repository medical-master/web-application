package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.notice.QueryNoticeInfoResponse;
import com.medicalmaster.common.notice.QueryNoticesRequest;
import com.medicalmaster.common.notice.QueryNoticesResponse;
import com.medicalmaster.common.request.get.IdRequest;
import com.xross.tools.xunit.XunitFactory;

/**
 * 重要通知
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月6日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path("/notice")
public class NoticeResource extends Resources {
	static {
		try {
			factory = XunitFactory.load("notice.xunit");
			converterId = "notice branch";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询公告通知列表
	 * 
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public QueryNoticesResponse queryNotices(@BeanParam QueryNoticesRequest request) {
		request.setAction("queryNotices");

		return handle(request, request.getAction());
	}

	/**
	 * 获取公告通知内容
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public QueryNoticeInfoResponse queryNoticeInfo(@PathParam("id") Integer id) {
		IdRequest context = new IdRequest();
		context.setAction("queryNoticeInfo");
		context.setId(id);

		return handle(context, context.getAction());
	}
}
