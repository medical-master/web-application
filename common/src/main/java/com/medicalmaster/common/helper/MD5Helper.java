/**
 * 
 */
package com.medicalmaster.common.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * 
 * 
 * @author guanrong.xie Created By 2015-7-31
 * 
 */
public class MD5Helper {
	public static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	public static String getFileMD5(File file) throws Exception {
		MessageDigest messageDigest = null;
		InputStream inputStream = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			inputStream = new FileInputStream(file);
			byte[] buffer = new byte[1048576];
			int len = 0;
			while ((len = inputStream.read(buffer)) > 0) {
				messageDigest.update(buffer, 0, len);
			}
		} catch (Exception e) {
			throw new Exception("获取文件[" + file.getAbsolutePath() + "+]MD5码异常!", e);
		} finally {
			CloseableHelper.close(inputStream);
		}

		return toHexString(messageDigest.digest());
	}

	static String toHexString(byte[] b) {
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < b.length; ++i) {
			sb.append(hexChar[((b[i] & 0xF0) >>> 4)]);
			sb.append(hexChar[(b[i] & 0xF)]);
		}
		return sb.toString();
	}

	public static String encrypt(String inStr) throws NoSuchAlgorithmException {
		if ((inStr == null) || ("".equals(inStr))) {
			throw new IllegalArgumentException("Parameter[inStr] can't be null.");
		}
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];
		for (int i = 0; i < charArray.length; ++i) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);
		return byte2Hex(md5Bytes);
	}

	static String byte2Hex(byte[] bytes) {
		StringBuilder hexSb = new StringBuilder();
		for (int i = 0; i < bytes.length; ++i) {
			int val = bytes[i] & 0xFF;
			if (val < 16) {
				hexSb.append('0');
			}
			hexSb.append(Integer.toHexString(val));
		}
		return hexSb.toString();
	}
}
