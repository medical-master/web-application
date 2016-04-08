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
public class TrainMaterialRecorderPojo implements DalPojo {
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="resourceName")
	@Type(value=Types.VARCHAR)
	private String resourceName;
	
	@Column(name="resourceType")
	@Type(value=Types.INTEGER)
	private Integer resourceType;
	
	@Column(name="fileUrl")
	@Type(value=Types.VARCHAR)
	private String fileUrl;
	
	@Column(name="allowDownload")
	@Type(value=Types.TINYINT)
	private Integer allowDownload;
	
	@Column(name="downloadCnt")
	@Type(value=Types.INTEGER)
	private Integer downloadCnt;

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

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
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

}