package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import com.medicalmaster.common.helper.ParseHelper;
import com.medicalmaster.common.user.GetUserInfoResponse;
import com.medicalmaster.common.user.UpdateUserRequest;
import com.medicalmaster.dal.User;
import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public class UpdateInfo implements Converter {
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
		UpdateUserRequest ctx = (UpdateUserRequest) context;
		GetUserInfoResponse guir = new GetUserInfoResponse();
		User user = extract(ctx);
		try {
			manager.updateInfo(user);
			user = manager.getUser(user.getUserId());
			guir.setUser(user);
			guir.setMessage("用户信息更新成功");
			guir.setSuccess(true);
			return guir;
		} catch (SQLException e) {
			guir.setSuccess(false);
			guir.setMessage("用户信息更新失败");
			return guir;
		}
	}

	private User extract(UpdateUserRequest req) {
		User user = new User();

		user.setUserId(ParseHelper.parseInt(req.getUserId()));
		user.setEmail(req.getEmail());
		user.setHosptialId(ParseHelper.parseInt(req.getHosptialId()));
		user.setNickName(req.getNickName());
		user.setSex(ParseHelper.parseInt(req.getSex()));
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
