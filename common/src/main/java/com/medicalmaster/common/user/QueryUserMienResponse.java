package com.medicalmaster.common.user;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.UserMienViewPojo;

public class QueryUserMienResponse extends PageResponse
{
	private List<UserMienViewPojo> userMienList;
	public QueryUserMienResponse(){}
	
	public List<UserMienViewPojo> getUserMienList() {
		return userMienList;
	}
	public void setUserMienList(List<UserMienViewPojo> userMienList) {
		this.userMienList = userMienList;
	}	
}
