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
@Table(name="expert_mien")
public class ExpertMien implements DalPojo {
	
	@Id
	@Column(name="id")
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="expertId")
	@Type(value=Types.INTEGER)
	private Integer expertId;
	
	@Column(name="mienType")
	@Type(value=Types.INTEGER)
	private Integer mienType;
	
	@Column(name="begYear")
	@Type(value=Types.VARCHAR)
	private String begYear;
	
	@Column(name="endYear")
	@Type(value=Types.VARCHAR)
	private String endYear;
	
	@Column(name="desc")
	@Type(value=Types.VARCHAR)
	private String desc;
	
	@Column(name="publishStatu")
	@Type(value=Types.INTEGER)
	private Integer publishStatu;
	
	@Column(name="publishTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp publishTime;
	
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;
	
	@Column(name="createUser")
	@Type(value=Types.INTEGER)
	private Integer createUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExpertId() {
		return expertId;
	}

	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}

	public Integer getMienType() {
		return mienType;
	}

	public void setMienType(Integer mienType) {
		this.mienType = mienType;
	}

	public String getBegYear() {
		return begYear;
	}

	public void setBegYear(String begYear) {
		this.begYear = begYear;
	}

	public String getEndYear() {
		return endYear;
	}

	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getPublishStatu() {
		return publishStatu;
	}

	public void setPublishStatu(Integer publishStatu) {
		this.publishStatu = publishStatu;
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

}