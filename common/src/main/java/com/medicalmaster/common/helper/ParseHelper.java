package com.medicalmaster.common.helper;

import java.sql.Timestamp;
import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

public class ParseHelper {
	public static Integer parseInt(String value) {
		if (value == null || value.trim().length() == 0)
			return null;
		return Integer.parseInt(value);
	}

	public static Double parseDouble(String value) {
		if (value == null || value.trim().length() == 0)
			return null;
		return Double.parseDouble(value);
	}

	public static Boolean parseBoolean(String value) {
		if (value == null || value.trim().length() == 0)
			return null;

		return Boolean.parseBoolean(value);
	}

	public static String formateTimestamp(Timestamp timestamp, String pattern) {
		if (timestamp == null) {
			return "";
		}

		if (StringUtils.isBlank(pattern)) {
			pattern = "yyyy-MM-dd";
		}

		return DateFormatUtils.format(timestamp, pattern);
	}

	public static String formateNumber(Number number) {
		if (number == null) {
			return "";
		}

		return NumberFormat.getInstance().format(number);
	}
}
