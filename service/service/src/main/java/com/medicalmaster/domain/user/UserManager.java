package com.medicalmaster.domain.user;

import java.security.MessageDigest;
import java.sql.SQLException;

import com.medicalmaster.common.user.UserStatus;
import com.medicalmaster.common.user.UserType;
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
