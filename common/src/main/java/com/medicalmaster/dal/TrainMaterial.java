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
@Table(name="train_material")
public class TrainMaterial implements DalPojo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="workstationId")
	@Type(value=Types.INTEGER)
	private Integer workstationId;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="materialFile")
	@Type(value=Types.INTEGER)
	private Integer materialFile;
	
	@Column(name="publishTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp publishTime;
	
	@Column(name="visitCnt")
	@Type(value=Types.INTEGER)
	private Integer visitCnt;
	
	@Column(name="publishStatus")
	@Type(value=Types.INTEGER)
	private Integer publishStatus;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaterialFile() {
		return materialFile;
	}

	public void setMaterialFile(Integer materialFile) {
		this.materialFile = materialFile;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(Integer visitCnt) {
		this.visitCnt = visitCnt;
	}

	public Integer getPublishStatus() {
		return publishStatus;
	}

	public void setPublishStatus(Integer publishStatus) {
		this.publishStatus = publishStatus;
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