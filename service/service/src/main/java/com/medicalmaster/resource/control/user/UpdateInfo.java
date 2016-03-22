package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.helper.ParseHelper;
import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.dal.User;
import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class UpdateInfo implements Converter{
	private static UserManager manager; 
	static {
		try {
			manager = new UserManager();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Context convert(Context context) {
		UpdateUserRequest ctx = (UpdateUserRequest)context;
		String message = "undefined";
		GetUserInfoResponse guir = new GetUserInfoResponse();
		User user = extract(ctx);
		try{
			message = "Update infomation for user %s is success.";
			
			manager.updateInfo(user);;
			user = manager.getUser(user.getUserId());
			guir.setUser(user);
			guir.setMessage(String.format(message, user.getName()));
			guir.setSuccess(true);
			return guir;
		} catch (SQLException e) {
			guir.setSuccess(false);
			guir.setMessage(String.format("Update infomation for user id %s is success.", user.getUserId()));
			return guir;
		}
	}
	
	private User extract(UpdateUserRequest req) {
		User user = new User();
		
		user.setUserId(ParseHelper.parseInt(req.getUserId()));
		user.setEmail(req.getEmail());
		user.setHosptialId(ParseHelper.parseInt(req.getHosptialId()));
		user.setNickName(req.getNickName());
		user.setSex(ParseHelper.parseBoolean(req.getSex()));
		user.setDepartment(req.getDepartment());
		user.setEducationLevel(ParseHelper.parseInt(req.getEducationLevel()));
		user.setProfessionalRank(ParseHelper.parseInt(req.getProfessionalRank()));
		user.setTitle(req.getTitle());
		user.setIdentityNumber(req.getIdentityNumber());
		user.setDoctorNumber(req.getDoctorNumber());
		user.setMobilePhoneNumber(req.getMobilePhoneNumber());
		
		return user;
	}
}
