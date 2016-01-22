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
@Table(name="user")
public class User implements DalPojo {
	
	@Id
	@Column(name="user_id")
	@Type(value=Types.INTEGER)
	private Integer user_id;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="email")
	@Type(value=Types.VARCHAR)
	private String email;
	
	@Column(name="authentication")
	@Type(value=Types.VARCHAR)
	private String authentication;
	
	@Column(name="create_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp create_time;
	
	@Column(name="user_type")
	@Type(value=Types.INTEGER)
	private Integer user_type;
	
	@Column(name="hosptial_id")
	@Type(value=Types.INTEGER)
	private Integer hosptial_id;
	
	@Column(name="nick_name")
	@Type(value=Types.VARCHAR)
	private String nick_name;
	
	@Column(name="sex")
	@Type(value=Types.BIT)
	private Boolean sex;
	
	@Column(name="department")
	@Type(value=Types.VARCHAR)
	private String department;
	
	@Column(name="education_level")
	@Type(value=Types.INTEGER)
	private Integer education_level;
	
	@Column(name="professional_rank")
	@Type(value=Types.INTEGER)
	private Integer professional_rank;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="identity_number")
	@Type(value=Types.VARCHAR)
	private String identity_number;
	
	@Column(name="doctor_number")
	@Type(value=Types.VARCHAR)
	private String doctor_number;
	
	@Column(name="mobile_phone_number")
	@Type(value=Types.VARCHAR)
	private String mobile_phone_number;
	
	@Column(name="last_update_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp last_update_time;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	public Integer getHosptial_id() {
		return hosptial_id;
	}

	public void setHosptial_id(Integer hosptial_id) {
		this.hosptial_id = hosptial_id;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getEducation_level() {
		return education_level;
	}

	public void setEducation_level(Integer education_level) {
		this.education_level = education_level;
	}

	public Integer getProfessional_rank() {
		return professional_rank;
	}

	public void setProfessional_rank(Integer professional_rank) {
		this.professional_rank = professional_rank;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIdentity_number() {
		return identity_number;
	}

	public void setIdentity_number(String identity_number) {
		this.identity_number = identity_number;
	}

	public String getDoctor_number() {
		return doctor_number;
	}

	public void setDoctor_number(String doctor_number) {
		this.doctor_number = doctor_number;
	}

	public String getMobile_phone_number() {
		return mobile_phone_number;
	}

	public void setMobile_phone_number(String mobile_phone_number) {
		this.mobile_phone_number = mobile_phone_number;
	}

	public Timestamp getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Timestamp last_update_time) {
		this.last_update_time = last_update_time;
	}

}