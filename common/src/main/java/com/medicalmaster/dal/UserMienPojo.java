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
public class UserMienPojo implements DalPojo {
	
	@Column(name="mienType")
	@Type(value=Types.INTEGER)
	private Integer mienType;
	
	@Column(name="begYear")
	@Type(value=Types.VARCHAR)
	private String begYear;
	
	@Column(name="endYear")
	@Type(value=Types.VARCHAR)
	private String endYear;
	
	@Column(name="userMienDesc")
	@Type(value=Types.VARCHAR)
	private String userMienDesc;
	
	@Column(name="publishTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp publishTime;
	
	@Column(name="createTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp createTime;

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

	public String getUserMienDesc() {
		return userMienDesc;
	}

	public void setUserMienDesc(String userMienDesc) {
		this.userMienDesc = userMienDesc;
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

}
