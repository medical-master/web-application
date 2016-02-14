package com.medicalmaster.domain.user;

public enum UserStatus {
	invited, activated, deactivated;
	public int intValue() {
		switch (this) {
		case invited:
			return 0;
		case activated:
			return 1;
		case deactivated:
			return 2;
		default:
			throw new IllegalStateException("User status is not defined");
		}
	}
}
