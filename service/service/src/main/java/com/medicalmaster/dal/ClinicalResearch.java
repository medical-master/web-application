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
@Table(name="clinical_research")
public class ClinicalResearch implements DalPojo {
	
	@Id
	@Column(name="clinicalResearchId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer clinicalResearchId;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="applicationLocation")
	@Type(value=Types.VARCHAR)
	private String applicationLocation;
	
	@Column(name="assignmentContractLocation")
	@Type(value=Types.VARCHAR)
	private String assignmentContractLocation;
	
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;
	
	@Column(name="lastUpdateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp lastUpdateTime;
	
	@Column(name="userId")
	@Type(value=Types.INTEGER)
	private Integer userId;

	public Integer getClinicalResearchId() {
		return clinicalResearchId;
	}

	public void setClinicalResearchId(Integer clinicalResearchId) {
		this.clinicalResearchId = clinicalResearchId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getApplicationLocation() {
		return applicationLocation;
	}

	public void setApplicationLocation(String applicationLocation) {
		this.applicationLocation = applicationLocation;
	}

	public String getAssignmentContractLocation() {
		return assignmentContractLocation;
	}

	public void setAssignmentContractLocation(String assignmentContractLocation) {
		this.assignmentContractLocation = assignmentContractLocation;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}