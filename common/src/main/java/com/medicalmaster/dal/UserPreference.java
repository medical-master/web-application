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
@Database(name="medical-master")
@Table(name="user_preference")
public class UserPreference implements DalPojo {
	
	@Id
	@Column(name="id")
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="userId")
	@Type(value=Types.INTEGER)
	private Integer userId;
	
	@Column(name="hiddenName")
	@Type(value=Types.INTEGER)
	private Integer hiddenName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHiddenName() {
		return hiddenName;
	}

	public void setHiddenName(Integer hiddenName) {
		this.hiddenName = hiddenName;
	}

}