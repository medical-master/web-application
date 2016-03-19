package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;

import com.xross.tools.xunit.Context;

public class UpdateUserRequest implements Context {
	@FormParam("action") 
	private String action;
	
	@PathParam("userid") 
	String userId;
	
	@FormParam("email") 
	private String email; 
	
	@FormParam("hosptialId") 
	private String hosptialId;
	
	@FormParam("nickName")
	private String nickName;
	
	@FormParam("sex")
	private String sex;
	
	@FormParam("department")
	private String department;
	
	@FormParam("educationLevel")
	private String educationLevel;
	
	@FormParam("professionalRank")
	private String professionalRank;
	
	@FormParam("title")
	private String title;
	
	@FormParam("identityNumber")
	private String identityNumber;
	
	@FormParam("doctorNumber")
	private String doctorNumber;
	
	@FormParam("mobilePhoneNumber")
	private String mobilePhoneNumber;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHosptialId() {
		return hosptialId;
	}

	public void setHosptialId(String hosptialId) {
		this.hosptialId = hosptialId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getProfessionalRank() {
		return professionalRank;
	}

	public void setProfessionalRank(String professionalRank) {
		this.professionalRank = professionalRank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}
}
