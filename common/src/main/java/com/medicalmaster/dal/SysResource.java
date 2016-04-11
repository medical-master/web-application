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
@Table(name="sys_resource")
public class SysResource implements DalPojo {
	
	@Id
	@Column(name="id")
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="resourceType")
	@Type(value=Types.INTEGER)
	private Integer resourceType;
	
	@Column(name="resourceName")
	@Type(value=Types.VARCHAR)
	private String resourceName;
	
	@Column(name="desc")
	@Type(value=Types.VARCHAR)
	private String desc;
	
	@Column(name="fileUrl")
	@Type(value=Types.VARCHAR)
	private String fileUrl;
	
	@Column(name="fileSize")
	@Type(value=Types.INTEGER)
	private Integer fileSize;
	
	@Column(name="md5")
	@Type(value=Types.VARCHAR)
	private String md5;
	
	@Column(name="status")
	@Type(value=Types.INTEGER)
	private Integer status;
	
	@Column(name="allowDownload")
	@Type(value=Types.TINYINT)
	private Integer allowDownload;
	
	@Column(name="downloadCnt")
	@Type(value=Types.INTEGER)
	private Integer downloadCnt;
	
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

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getAllowDownload() {
		return allowDownload;
	}

	public void setAllowDownload(Integer allowDownload) {
		this.allowDownload = allowDownload;
	}

	public Integer getDownloadCnt() {
		return downloadCnt;
	}

	public void setDownloadCnt(Integer downloadCnt) {
		this.downloadCnt = downloadCnt;
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
