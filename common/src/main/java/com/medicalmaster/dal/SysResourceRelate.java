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
@Table(name="sys_resource_relate")
public class SysResourceRelate implements DalPojo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="relateType")
	@Type(value=Types.INTEGER)
	private Integer relateType;
	
	@Column(name="relateId")
	@Type(value=Types.INTEGER)
	private Integer relateId;
	
	@Column(name="resourceId")
	@Type(value=Types.INTEGER)
	private Integer resourceId;
	
	@Column(name="status")
	@Type(value=Types.INTEGER)
	private Integer status;
	
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

	public Integer getRelateType() {
		return relateType;
	}

	public void setRelateType(Integer relateType) {
		this.relateType = relateType;
	}

	public Integer getRelateId() {
		return relateId;
	}

	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
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