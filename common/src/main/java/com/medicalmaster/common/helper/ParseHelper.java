package com.medicalmaster.common.helper;

public class ParseHelper {
	public static Integer parseInt(String value) {
		if(value == null || value.trim().length() == 0)
			return null;
		return Integer.parseInt(value);
	}

	public static Double parseDouble(String value) {
		if(value == null || value.trim().length() == 0)
			return null;
		return Double.parseDouble(value);
	}
	
	public static Boolean parseBoolean(String value) {
		if(value == null || value.trim().length() == 0)
			return null;
		
		return Boolean.parseBoolean(value);
	}

}
