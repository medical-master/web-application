package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.CommonResponse;
import com.medicalmaster.common.Status;
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
		CommonResponse crc = new CommonResponse();
		try{
			message = "Update infomation for user %s is success.";
			User user = extract(ctx);
			
			manager.updateInfo(user);;
			Status.success(String.format(message, ctx.getUserId().toString()));
			return crc;
		} catch (SQLException e) {
			return Status.fail(ctx.getAction(), e);
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
