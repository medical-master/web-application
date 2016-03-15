package com.medicalmaster.common.user;

import javax.ws.rs.FormParam;

import com.xross.tools.xunit.Context;

public class UpdateUserRequest implements Context {
	@FormParam("action") 
	private String action;
	
	@FormParam("name") 
	private String name;
	
	@FormParam("email") 
	private String email; 
	
	@FormParam("authentication") 
	private String authentication;
	
	@FormParam("invitionCode") 
	private String invitionCode;
	
	@FormParam("hosptialId") 
	private Integer hosptialId;
	
	@FormParam("nickName")
	private String nickName;
	
	@FormParam("sex")
	private Boolean sex;
	
	@FormParam("department")
	private String department;
	
	@FormParam("educationLevel")
	private Integer educationLevel;
	
	@FormParam("professionalRank")
	private Integer professionalRank;
	
	@FormParam("title")
	private String title;
	
	@FormParam("identityNumber")
	private String identityNumber;
	
	@FormParam("doctorNumber")
	private String doctorNumber;
	
	@FormParam("mobilePhoneNumber")
	private String mobilePhoneNumber;
	
	@FormParam("status")
	private Integer status;
	
	@FormParam("inviteCode")
	private String inviteCode;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getInvitionCode() {
		return invitionCode;
	}

	public void setInvitionCode(String invitionCode) {
		this.invitionCode = invitionCode;
	}

	public Integer getHosptialId() {
		return hosptialId;
	}

	public void setHosptialId(Integer hosptialId) {
		this.hosptialId = hosptialId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(Integer educationLevel) {
		this.educationLevel = educationLevel;
	}

	public Integer getProfessionalRank() {
		return professionalRank;
	}

	public void setProfessionalRank(Integer professionalRank) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
}
