package com.medicalmaster.domain.user;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.helper.MD5Helper;
import com.medicalmaster.common.user.QueryUserMienRequest;
import com.medicalmaster.common.user.UserType;
import com.medicalmaster.dal.User;
import com.medicalmaster.dal.UserDao;
import com.medicalmaster.dal.UserMienExtDao;
import com.medicalmaster.dal.UserMienViewPojo;

public class UserManager {
	private UserDao dao;
	private UserMienExtDao userMienExtDao;

	public UserManager() throws SQLException {
		dao = new UserDao();
		userMienExtDao = new UserMienExtDao();
	}

	public String inviteMaster(String name, String email, String mobilePhoneNumber) throws SQLException {
		String inviteCode = buildInviteCode();

		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setMobilePhoneNumber(mobilePhoneNumber);
		// user.setInviteCode(inviteCode);

		dao.insert(null, user);
		return inviteCode;
	}

	public void activateMaster(String inviteCode, String authentication, String mobilePhoneNumber) throws SQLException {
		// dao.activateByInviteCode(UserStatus.activated.intValue(),
		// authentication, inviteCode, UserStatus.invited.intValue(), null);
	}

	public void register(UserType UserType, String name, String authentication, String email, String mobilePhoneNumber)
			throws SQLException {
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setAuthentication(authentication);
		user.setMobilePhoneNumber(mobilePhoneNumber);
		user.setType(UserType.ordinal());
		dao.insert(null, user);
	}

	public void updateInfo(User User) throws SQLException {
		dao.update(null, User);
	}

	public User getUser(Integer UserId) throws SQLException {
		return dao.queryByPk(UserId, null);
	}

	public User login(String userName, String password) throws SQLException, NoSuchAlgorithmException {
		password = MD5Helper.encrypt(password);
		User user = dao.loginByEmail(userName, password, 1, null);
		if (user != null) {
			return user;
		}

		user = dao.loginByPhoneNo(userName, password, 1, null);

		return user;
	}

	public int removeUser(Integer userId) throws SQLException {
		User u = new User();
		u.setUserId(userId);
		return dao.delete(null, u);
	}

	public String buildAuthentication(String password) {
		// TODO replace with MD5
		return password;
	}

	private String buildInviteCode() {
		return String.valueOf(System.currentTimeMillis());
	}

	public List<UserMienViewPojo> queryUserMien(QueryUserMienRequest request) throws SQLException {
		return userMienExtDao.queryUserMien(request.getUserId(), request.getPageNo(), request.getPageSize(), null);
	}
}
