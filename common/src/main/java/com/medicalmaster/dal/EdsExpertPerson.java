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
@Table(name="eds_expert_person")
public class EdsExpertPerson implements DalPojo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="expertId")
	@Type(value=Types.INTEGER)
	private Integer expertId;
	
	@Column(name="sex")
	@Type(value=Types.BIT)
	private Boolean sex;
	
	@Column(name="educationLevel")
	@Type(value=Types.INTEGER)
	private Integer educationLevel;
	
	@Column(name="identityNumber")
	@Type(value=Types.VARCHAR)
	private String identityNumber;
	
	@Column(name="department")
	@Type(value=Types.VARCHAR)
	private String department;
	
	@Column(name="professionalRank")
	@Type(value=Types.INTEGER)
	private Integer professionalRank;
	
	@Column(name="duties")
	@Type(value=Types.INTEGER)
	private Integer duties;

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

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(Integer educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getIdentityNumber() {
		return identityNumber;
	}

	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Integer getProfessionalRank() {
		return professionalRank;
	}

	public void setProfessionalRank(Integer professionalRank) {
		this.professionalRank = professionalRank;
	}

	public Integer getDuties() {
		return duties;
	}

	public void setDuties(Integer duties) {
		this.duties = duties;
	}

}