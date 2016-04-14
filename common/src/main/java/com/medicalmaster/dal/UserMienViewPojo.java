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
public class UserMienViewPojo implements DalPojo {
	
	@Column(name="mienType")
	@Type(value=Types.INTEGER)
	private Integer mienType;
	
	@Column(name="begYear")
	@Type(value=Types.VARCHAR)
	private String begYear;
	
	@Column(name="endYear")
	@Type(value=Types.VARCHAR)
	private String endYear;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="publishStatu")
	@Type(value=Types.INTEGER)
	private Integer publishStatu;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPublishStatu() {
		return publishStatu;
	}

	public void setPublishStatu(Integer publishStatu) {
		this.publishStatu = publishStatu;
	}

}
