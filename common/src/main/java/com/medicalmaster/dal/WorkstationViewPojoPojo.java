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

import com.ctrip.platform.dal.dao.DalPojo;

@Entity
@Database(name="")
@Table(name="")
public class WorkstationViewPojoPojo implements DalPojo {
	
	@Column(name="workstationId")
	@Type(value=Types.INTEGER)
	private Integer workstationId;
	
	@Column(name="expertId")
	@Type(value=Types.INTEGER)
	private Integer expertId;
	
	@Column(name="subLink")
	@Type(value=Types.VARCHAR)
	private String subLink;
	
	@Column(name="wksName")
	@Type(value=Types.VARCHAR)
	private String wksName;
	
	@Column(name="summery")
	@Type(value=Types.VARCHAR)
	private String summery;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="keywords")
	@Type(value=Types.VARCHAR)
	private String keywords;
	
	@Column(name="domains")
	@Type(value=Types.VARCHAR)
	private String domains;
	
	@Column(name="illCode")
	@Type(value=Types.INTEGER)
	private Integer illCode;
	
	@Column(name="members")
	@Type(value=Types.INTEGER)
	private Integer members;
	
	@Column(name="attends")
	@Type(value=Types.INTEGER)
	private Integer attends;
	
	@Column(name="wksStatus")
	@Type(value=Types.INTEGER)
	private Integer wksStatus;
	
	@Column(name="usName")
	@Type(value=Types.VARCHAR)
	private String usName;
	
	@Column(name="nickName")
	@Type(value=Types.VARCHAR)
	private String nickName;
	
	@Column(name="sex")
	@Type(value=Types.BIT)
	private Boolean sex;
	
	@Column(name="email")
	@Type(value=Types.VARCHAR)
	private String email;
	
	@Column(name="pte")
	@Type(value=Types.VARCHAR)
	private String pte;
	
	@Column(name="usStatus")
	@Type(value=Types.INTEGER)
	private Integer usStatus;
	
	@Column(name="doctorNumber")
	@Type(value=Types.VARCHAR)
	private String doctorNumber;
	
	@Column(name="department")
	@Type(value=Types.VARCHAR)
	private String department;
	
	@Column(name="hospitalName")
	@Type(value=Types.VARCHAR)
	private String hospitalName;
	
	@Column(name="level")
	@Type(value=Types.INTEGER)
	private Integer level;
	
	@Column(name="proviceId")
	@Type(value=Types.INTEGER)
	private Integer proviceId;
	
	@Column(name="cityId")
	@Type(value=Types.INTEGER)
	private Integer cityId;
	
	@Column(name="districtId")
	@Type(value=Types.INTEGER)
	private Integer districtId;
	
	@Column(name="address")
	@Type(value=Types.VARCHAR)
	private String address;
	
	@Column(name="fileUrl")
	@Type(value=Types.VARCHAR)
	private String fileUrl;
	
	@Column(name="userId")
	@Type(value=Types.INTEGER)
	private Integer userId;
	
	@Column(name="expertArea")
	@Type(value=Types.VARCHAR)
	private String expertArea;
	
	@Column(name="expertType")
	@Type(value=Types.INTEGER)
	private Integer expertType;

	public Integer getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}

	public Integer getExpertId() {
		return expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public String getSubLink() {
		return subLink;
	}

	public void setSubLink(String subLink) {
		this.subLink = subLink;
	}

	public String getWksName() {
		return wksName;
	}

	public void setWksName(String wksName) {
		this.wksName = wksName;
	}

	public String getSummery() {
		return summery;
	}

	public void setSummery(String summery) {
		this.summery = summery;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDomains() {
		return domains;
	}

	public void setDomains(String domains) {
		this.domains = domains;
	}

	public Integer getIllCode() {
		return illCode;
	}

	public void setIllCode(Integer illCode) {
		this.illCode = illCode;
	}

	public Integer getMembers() {
		return members;
	}

	public void setMembers(Integer members) {
		this.members = members;
	}

	public Integer getAttends() {
		return attends;
	}

	public void setAttends(Integer attends) {
		this.attends = attends;
	}

	public Integer getWksStatus() {
		return wksStatus;
	}

	public void setWksStatus(Integer wksStatus) {
		this.wksStatus = wksStatus;
	}

	public String getUsName() {
		return usName;
	}

	public void setUsName(String usName) {
		this.usName = usName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPte() {
		return pte;
	}

	public void setPte(String pte) {
		this.pte = pte;
	}

	public Integer getUsStatus() {
		return usStatus;
	}

	public void setUsStatus(Integer usStatus) {
		this.usStatus = usStatus;
	}

	public String getDoctorNumber() {
		return doctorNumber;
	}

	public void setDoctorNumber(String doctorNumber) {
		this.doctorNumber = doctorNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getProviceId() {
		return proviceId;
	}

	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getExpertArea() {
		return expertArea;
	}

	public void setExpertArea(String expertArea) {
		this.expertArea = expertArea;
	}

	public Integer getExpertType() {
		return expertType;
	}

	public void setExpertType(Integer expertType) {
		this.expertType = expertType;
	}

}
