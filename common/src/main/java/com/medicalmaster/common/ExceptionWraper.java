package com.medicalmaster.common;

public class ExceptionWraper {
	public static void wrap(Throwable root) {
		throw new RuntimeException(root);
	}

	public static void wrap(String message, Throwable root) {
		throw new RuntimeException(message, root);
	}
}
