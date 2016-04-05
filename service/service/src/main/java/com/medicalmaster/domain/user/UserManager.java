package com.medicalmaster.domain.user;

import java.security.MessageDigest;
import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.user.UserStatus;
import com.medicalmaster.common.user.UserType;
import com.medicalmaster.dal.EdsUser;
import com.medicalmaster.dal.EdsUserDao;

public class UserManager {
	private EdsUserDao dao;
	
	public UserManager() throws SQLException {
		dao = new EdsUserDao();
	}
	
	public String inviteMaster(String name, String email, String mobilePhoneNumber) throws SQLException {
		String inviteCode = buildInviteCode();
		
		EdsUser user = new EdsUser();
		user.setName(name);
		user.setEmail(email);
		user.setMobilePhoneNumber(mobilePhoneNumber);
//		user.setInviteCode(inviteCode);
		
		dao.insert(null, user);
		return inviteCode;
	}

	public void activateMaster(String inviteCode, String authentication, String mobilePhoneNumber) throws SQLException {
//		dao.activateByInviteCode(UserStatus.activated.intValue(), authentication, inviteCode, UserStatus.invited.intValue(), null);
	}
	
	public void register(UserType EdsUserType, String name, String authentication, String email, String mobilePhoneNumber) throws SQLException {
		EdsUser user = new EdsUser();
		user.setName(name);
		user.setEmail(email);
		user.setAuthentication(authentication);
		user.setMobilePhoneNumber(mobilePhoneNumber);
		user.setType(EdsUserType.ordinal());
		dao.insert(null, user);
	}

	public void updateInfo(EdsUser EdsUser) throws SQLException {
		dao.update(null, EdsUser);
	}

	public EdsUser getUser(Integer EdsUserId) throws SQLException {
		return dao.queryByPk(EdsUserId, null);
	}

	public EdsUser getUser(String EdsUserName, String password) throws SQLException {
		EdsUser EdsUser = new EdsUser();
		EdsUser.setAuthentication(password);
		EdsUser.setName(EdsUserName);
		List<EdsUser> EdsUsers = dao.queryLike(EdsUser, null);
		if(EdsUsers.size() != 1)
			return null;
		
		return EdsUsers.get(0);
	}
	
	public int removeUser(Integer userId) throws SQLException {
		EdsUser u = new EdsUser();
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
	
	private String generateAuthen(String password) {
		return toMD5(password);
	}
	
	private String toMD5(String inStr) {
		 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       

        try {
            byte[] btInput = inStr.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
}
