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
@Table(name="training_material")
public class TrainingMaterial implements DalPojo {
	
	@Id
	@Column(name="training_material_id")
	@Type(value=Types.INTEGER)
	private Integer training_material_id;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="material_location")
	@Type(value=Types.VARCHAR)
	private String material_location;
	
	@Column(name="create_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp create_time;
	
	@Column(name="last_update_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp last_update_time;
	
	@Column(name="user_id")
	@Type(value=Types.INTEGER)
	private Integer user_id;

	public Integer getTraining_material_id() {
		return training_material_id;
	}

	public void setTraining_material_id(Integer training_material_id) {
		this.training_material_id = training_material_id;
	}

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

	public String getMaterial_location() {
		return material_location;
	}

	public void setMaterial_location(String material_location) {
		this.material_location = material_location;
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

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}