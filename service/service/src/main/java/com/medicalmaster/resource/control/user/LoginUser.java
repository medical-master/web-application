package com.medicalmaster.resource.control.user;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.user.LoginRequest;
import com.medicalmaster.common.user.LoginResponse;
import com.medicalmaster.dal.User;
import com.xross.tools.xunit.Context;

public class LoginUser extends UserConverter {
	static Logger log = LoggerFactory.getLogger(LoginUser.class);

	@Override
	public Context convert(Context context) {
		LoginResponse lr = new LoginResponse();
		try {
			LoginRequest ctx = (LoginRequest) context;

			User user = manager.login(ctx.getName(), ctx.getPassword());
			if (user == null) {
				lr.setSuccess(false);
				lr.setMessage("您输入的手机号/邮箱/密码不正确");
				return lr;
			}
			user.setAuthentication("");
			lr.setUser(user);
			lr.setSuccess(true);
			lr.setMessage("登录成功");
			return lr;
		} catch (SQLException e) {
			log.error("登录失败", e);

			lr.setSuccess(false);
			lr.setMessage("用户信息查询失败");
			return lr;
		} catch (NoSuchAlgorithmException e) {
			log.error("登录失败", e);

			lr.setSuccess(false);
			lr.setMessage("用户信息查询失败");
			return lr;
		}
	}
}
