	package com.medicalmaster.web.view.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.user.QueryUserMienRequest;
import com.medicalmaster.common.user.QueryUserMienResponse;
import com.medicalmaster.dal.UserMienViewPojo;
import com.medicalmaster.web.helper.ResourceProxy;
import com.medicalmaster.web.view.BaseView;

public class UserView extends BaseView
{
	public UserView(HttpServletRequest request, HttpServletResponse response) throws Exception {
		super(request, response);
	}

	/**
	 * 获取指定用户个人风采信息
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public List<UserMienViewPojo> getUserMienInfo(String id) throws IllegalArgumentException, IllegalAccessException 
	{
		QueryUserMienRequest request = new QueryUserMienRequest();
		request.setPageSize(30);
		request.setUserId(Integer.parseInt(id.toString()));
		QueryUserMienResponse response = ResourceProxy.get(
				webContext.getBaseServiceUrl() + ResourceConstants.PATH_USER+"/userMienInfo", request,
				QueryUserMienResponse.class);

		if (response.isSuccess()) 
		{
			List<UserMienViewPojo> UserMienViewList = response.getUserMienList();
			return UserMienViewList;
		}
		else 
		{
			return null;
		}
	}
}
