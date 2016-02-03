package com.medicalmaster.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ctrip.platform.dal.dao.annotation.Database;
import com.ctrip.platform.dal.dao.annotation.Sensitive;
import com.ctrip.platform.dal.dao.annotation.Type;
import java.sql.Types;
import java.sql.Timestamp;

import com.ctrip.platform.dal.dao.DalPojo;

@Entity
@Database(name="medical_master")
@Table(name="user")
public class User implements DalPojo {
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer userId;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="email")
	@Type(value=Types.VARCHAR)
	private String email;
	
	@Column(name="authentication")
	@Type(value=Types.VARCHAR)
	private String authentication;
	
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;
	
	@Column(name="type")
	@Type(value=Types.INTEGER)
	private Integer type;
	
	@Column(name="hosptialId")
	@Type(value=Types.INTEGER)
	private Integer hosptialId;
	
	@Column(name="nickName")
	@Type(value=Types.VARCHAR)
	private String nickName;
	
	@Column(name="sex")
	@Type(value=Types.BIT)
	private Boolean sex;
	
	@Column(name="department")
	@Type(value=Types.VARCHAR)
	private String department;
	
	@Column(name="educationLevel")
	@Type(value=Types.INTEGER)
	private Integer educationLevel;
	
	@Column(name="professionalRank")
	@Type(value=Types.INTEGER)
	private Integer professionalRank;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="identityNumber")
	@Type(value=Types.VARCHAR)
	private String identityNumber;
	
	@Column(name="doctorNumber")
	@Type(value=Types.VARCHAR)
	private String doctorNumber;
	
	@Column(name="mobilePhoneNumber")
	@Type(value=Types.VARCHAR)
	private String mobilePhoneNumber;
	
	@Column(name="lastUpdateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp lastUpdateTime;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}