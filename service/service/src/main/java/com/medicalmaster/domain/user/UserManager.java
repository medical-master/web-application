package com.medicalmaster.domain.user;

import java.sql.SQLException;

import com.medicalmaster.dal.User;
import com.medicalmaster.dal.UserDao;

public class UserManager {
	private UserDao dao;
	
	public UserManager() throws SQLException {
		dao = new UserDao();
	}
	
	public String inviteMaster(String name, String email, String mobilePhoneNumber) throws SQLException {
		String inviteCode = buildInviteCode();
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setMobilePhoneNumber(mobilePhoneNumber);
		user.setInviteCode(inviteCode);
		
		dao.insert(null, user);
		return inviteCode;
	}

	public void activateMaster(String inviteCode, String authentication, String mobilePhoneNumber) throws SQLException {
		dao.activateByInviteCode(UserStatus.activated.intValue(), authentication, inviteCode, UserStatus.invited.intValue(), null);
	}
	
	public void register(UserType userType, String name, String authentication, String email, String mobilePhoneNumber) throws SQLException {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setAuthentication(authentication);
		user.setMobilePhoneNumber(mobilePhoneNumber);
		dao.insert(null, user);
	}

	public void completeInfo(UserType userType, String name, String mobilePhoneNumber) {
		
	}
	
	private String buildInviteCode() {
		return String.valueOf(System.currentTimeMillis());
	}
}
