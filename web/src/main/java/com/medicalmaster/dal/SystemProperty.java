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
@Table(name="system_property")
public class SystemProperty implements DalPojo {
	
	@Id
	@Column(name="system_property_id")
	@Type(value=Types.INTEGER)
	private Integer system_property_id;
	
	@Column(name="system_property_category_id")
	@Type(value=Types.INTEGER)
	private Integer system_property_category_id;
	
	@Column(name="value")
	@Type(value=Types.VARCHAR)
	private String value;
	
	@Column(name="comment")
	@Type(value=Types.VARCHAR)
	private String comment;
	
	@Column(name="create_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp create_time;
	
	@Column(name="last_update_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp last_update_time;

	public Integer getSystem_property_id() {
		return system_property_id;
	}

	public void setSystem_property_id(Integer system_property_id) {
		this.system_property_id = system_property_id;
	}

	public Integer getSystem_property_category_id() {
		return system_property_category_id;
	}

	public void setSystem_property_category_id(Integer system_property_category_id) {
		this.system_property_category_id = system_property_category_id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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