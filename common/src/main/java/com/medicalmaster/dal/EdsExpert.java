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
@Database(name="medical-master")
@Table(name="eds_expert")
public class EdsExpert implements DalPojo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="expertType")
	@Type(value=Types.INTEGER)
	private Integer expertType;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="inviteCode")
	@Type(value=Types.VARCHAR)
	private String inviteCode;
	
	@Column(name="iconResourceId")
	@Type(value=Types.INTEGER)
	private Integer iconResourceId;
	
	@Column(name="mobileNumber")
	@Type(value=Types.VARCHAR)
	private String mobileNumber;
	
	@Column(name="email")
	@Type(value=Types.VARCHAR)
	private String email;
	
	@Column(name="hosptialId")
	@Type(value=Types.INTEGER)
	private Integer hosptialId;
	
	@Column(name="doctorNo")
	@Type(value=Types.VARCHAR)
	private String doctorNo;
	
	@Column(name="expertArea")
	@Type(value=Types.VARCHAR)
	private String expertArea;
	
	@Column(name="summaryHtml")
	@Type(value=Types.INTEGER)
	private Integer summaryHtml;
	
	@Column(name="academicHtml")
	@Type(value=Types.INTEGER)
	private Integer academicHtml;
	
	@Column(name="honorHtml")
	@Type(value=Types.INTEGER)
	private Integer honorHtml;
	
	@Column(name="status")
	@Type(value=Types.INTEGER)
	private Integer status;
	
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;
	
	@Column(name="lastUpdateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp lastUpdateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExpertType() {
		return expertType;
	}

	public void setExpertType(Integer expertType) {
		this.expertType = expertType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public Integer getIconResourceId() {
		return iconResourceId;
	}

	public void setIconResourceId(Integer iconResourceId) {
		this.iconResourceId = iconResourceId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getHosptialId() {
		return hosptialId;
	}

	public void setHosptialId(Integer hosptialId) {
		this.hosptialId = hosptialId;
	}

	public String getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}

	public String getExpertArea() {
		return expertArea;
	}

	public void setExpertArea(String expertArea) {
		this.expertArea = expertArea;
	}

	public Integer getSummaryHtml() {
		return summaryHtml;
	}

	public void setSummaryHtml(Integer summaryHtml) {
		this.summaryHtml = summaryHtml;
	}

	public Integer getAcademicHtml() {
		return academicHtml;
	}

	public void setAcademicHtml(Integer academicHtml) {
		this.academicHtml = academicHtml;
	}

	public Integer getHonorHtml() {
		return honorHtml;
	}

	public void setHonorHtml(Integer honorHtml) {
		this.honorHtml = honorHtml;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}