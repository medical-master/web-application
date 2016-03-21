package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

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
		
		user.setUserId(Integer.parseInt(req.getUserId()));
		user.setEmail(req.getEmail());
		user.setHosptialId(Integer.parseInt(req.getHosptialId()));
		user.setNickName(req.getNickName());
		user.setSex(Boolean.parseBoolean(req.getSex()));
		user.setDepartment(req.getDepartment());
		user.setEducationLevel(Integer.parseInt(req.getEducationLevel()));
		user.setProfessionalRank(Integer.parseInt(req.getProfessionalRank()));
		user.setTitle(req.getTitle());
		user.setIdentityNumber(req.getIdentityNumber());
		user.setDoctorNumber(req.getDoctorNumber());
		user.setMobilePhoneNumber(req.getMobilePhoneNumber());
		
		return user;
	}
}
