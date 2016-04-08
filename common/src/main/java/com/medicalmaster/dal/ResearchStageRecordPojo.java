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
@Database(name="")
@Table(name="")
public class ResearchStageRecordPojo implements DalPojo {
	
	@Column(name="clinicalResearchId")
	@Type(value=Types.INTEGER)
	private Integer clinicalResearchId;
	
	@Column(name="stageTitle")
	@Type(value=Types.VARCHAR)
	private String stageTitle;
	
	@Column(name="stage")
	@Type(value=Types.VARCHAR)
	private String stage;
	
	@Column(name="stageResourceId")
	@Type(value=Types.INTEGER)
	private Integer stageResourceId;
	
	@Column(name="stageViewStatus")
	@Type(value=Types.TINYINT)
	private Integer stageViewStatus;
	
	@Column(name="stageStatus")
	@Type(value=Types.INTEGER)
	private Integer stageStatus;
	
	@Column(name="stagePublishTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp stagePublishTime;
	
	@Column(name="stageCreateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp stageCreateTime;
	
	@Column(name="stageCreateUser")
	@Type(value=Types.INTEGER)
	private Integer stageCreateUser;
	
	@Column(name="stageLastUpdateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp stageLastUpdateTime;
	
	@Column(name="stageLastUpdateUser")
	@Type(value=Types.INTEGER)
	private Integer stageLastUpdateUser;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="resourceId")
	@Type(value=Types.INTEGER)
	private Integer resourceId;
	
	@Column(name="viewStatus")
	@Type(value=Types.TINYINT)
	private Integer viewStatus;
	
	@Column(name="currentStatus")
	@Type(value=Types.INTEGER)
	private Integer currentStatus;
	
	@Column(name="publishTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp publishTime;
	
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;
	
	@Column(name="createUser")
	@Type(value=Types.INTEGER)
	private Integer createUser;
	
	@Column(name="lastUpdateTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp lastUpdateTime;
	
	@Column(name="lastUpdateUser")
	@Type(value=Types.INTEGER)
	private Integer lastUpdateUser;

	public Integer getClinicalResearchId() {
		return clinicalResearchId;
	}

	public void setClinicalResearchId(Integer clinicalResearchId) {
		this.clinicalResearchId = clinicalResearchId;
	}

	public String getStageTitle() {
		return stageTitle;
	}

	public void setStageTitle(String stageTitle) {
		this.stageTitle = stageTitle;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Integer getStageResourceId() {
		return stageResourceId;
	}

	public void setStageResourceId(Integer stageResourceId) {
		this.stageResourceId = stageResourceId;
	}

	public Integer getStageViewStatus() {
		return stageViewStatus;
	}

	public void setStageViewStatus(Integer stageViewStatus) {
		this.stageViewStatus = stageViewStatus;
	}

	public Integer getStageStatus() {
		return stageStatus;
	}

	public void setStageStatus(Integer stageStatus) {
		this.stageStatus = stageStatus;
	}

	public Timestamp getStagePublishTime() {
		return stagePublishTime;
	}

	public void setStagePublishTime(Timestamp stagePublishTime) {
		this.stagePublishTime = stagePublishTime;
	}

	public Timestamp getStageCreateTime() {
		return stageCreateTime;
	}

	public void setStageCreateTime(Timestamp stageCreateTime) {
		this.stageCreateTime = stageCreateTime;
	}

	public Integer getStageCreateUser() {
		return stageCreateUser;
	}

	public void setStageCreateUser(Integer stageCreateUser) {
		this.stageCreateUser = stageCreateUser;
	}

	public Timestamp getStageLastUpdateTime() {
		return stageLastUpdateTime;
	}

	public void setStageLastUpdateTime(Timestamp stageLastUpdateTime) {
		this.stageLastUpdateTime = stageLastUpdateTime;
	}

	public Integer getStageLastUpdateUser() {
		return stageLastUpdateUser;
	}

	public void setStageLastUpdateUser(Integer stageLastUpdateUser) {
		this.stageLastUpdateUser = stageLastUpdateUser;
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

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public Integer getViewStatus() {
		return viewStatus;
	}

	public void setViewStatus(Integer viewStatus) {
		this.viewStatus = viewStatus;
	}

	public Integer getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(Integer currentStatus) {
		this.currentStatus = currentStatus;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getCreateUser() {
		return createUser;
	}

	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}

	public Timestamp getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Timestamp lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Integer getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(Integer lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

}