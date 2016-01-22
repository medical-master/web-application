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
@Table(name="clinical_research")
public class ClinicalResearch implements DalPojo {
	
	@Id
	@Column(name="clinical_research_id")
	@Type(value=Types.INTEGER)
	private Integer clinical_research_id;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="research_application_form_location")
	@Type(value=Types.VARCHAR)
	private String research_application_form_location;
	
	@Column(name="research_assignment_contract_location")
	@Type(value=Types.VARCHAR)
	private String research_assignment_contract_location;
	
	@Column(name="create_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp create_time;
	
	@Column(name="last_update_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp last_update_time;
	
	@Column(name="user_id")
	@Type(value=Types.INTEGER)
	private Integer user_id;

	public Integer getClinical_research_id() {
		return clinical_research_id;
	}

	public void setClinical_research_id(Integer clinical_research_id) {
		this.clinical_research_id = clinical_research_id;
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

	public String getResearch_application_form_location() {
		return research_application_form_location;
	}

	public void setResearch_application_form_location(String research_application_form_location) {
		this.research_application_form_location = research_application_form_location;
	}

	public String getResearch_assignment_contract_location() {
		return research_assignment_contract_location;
	}

	public void setResearch_assignment_contract_location(String research_assignment_contract_location) {
		this.research_assignment_contract_location = research_assignment_contract_location;
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