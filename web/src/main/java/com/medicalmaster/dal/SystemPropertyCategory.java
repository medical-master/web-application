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
@Database(name="medical_master")
@Table(name="system_property_category")
public class SystemPropertyCategory implements DalPojo {
	
	@Id
	@Column(name="system_property_category_id")
	@Type(value=Types.INTEGER)
	private Integer system_property_category_id;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;

	public Integer getSystem_property_category_id() {
		return system_property_category_id;
	}

	public void setSystem_property_category_id(Integer system_property_category_id) {
		this.system_property_category_id = system_property_category_id;
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

}