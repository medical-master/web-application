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
@Table(name="diagnostic_plan")
public class DiagnosticPlan implements DalPojo {
	
	@Id
	@Column(name="diagnostic_plan_id")
	@Type(value=Types.INTEGER)
	private Integer diagnostic_plan_id;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="category")
	@Type(value=Types.INTEGER)
	private Integer category;
	
	@Column(name="detail")
	@Type(value=Types.VARCHAR)
	private String detail;
	
	@Column(name="create_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp create_time;
	
	@Column(name="last_update")
	@Type(value=Types.TIMESTAMP)
	private Timestamp last_update;
	
	@Column(name="user_id")
	@Type(value=Types.INTEGER)
	private Integer user_id;

	public Integer getDiagnostic_plan_id() {
		return diagnostic_plan_id;
	}

	public void setDiagnostic_plan_id(Integer diagnostic_plan_id) {
		this.diagnostic_plan_id = diagnostic_plan_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

}