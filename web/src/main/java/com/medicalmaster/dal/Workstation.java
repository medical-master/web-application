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
@Table(name="workstation")
public class Workstation implements DalPojo {
	
	@Id
	@Column(name="workstation_id")
	@Type(value=Types.INTEGER)
	private Integer workstation_id;
	
	@Column(name="user_id")
	@Type(value=Types.INTEGER)
	private Integer user_id;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="domains")
	@Type(value=Types.VARCHAR)
	private String domains;
	
	@Column(name="keywords")
	@Type(value=Types.VARCHAR)
	private String keywords;
	
	@Column(name="allow_download")
	@Type(value=Types.BIT)
	private Boolean allow_download;
	
	@Column(name="create_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp create_time;
	
	@Column(name="last_update_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp last_update_time;

	public Integer getWorkstation_id() {
		return workstation_id;
	}

	public void setWorkstation_id(Integer workstation_id) {
		this.workstation_id = workstation_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDomains() {
		return domains;
	}

	public void setDomains(String domains) {
		this.domains = domains;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Boolean getAllow_download() {
		return allow_download;
	}

	public void setAllow_download(Boolean allow_download) {
		this.allow_download = allow_download;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Timestamp last_update_time) {
		this.last_update_time = last_update_time;
	}

}