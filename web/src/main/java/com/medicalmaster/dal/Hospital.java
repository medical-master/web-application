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
@Table(name="hospital")
public class Hospital implements DalPojo {
	
	@Id
	@Column(name="hospital_id")
	@Type(value=Types.INTEGER)
	private Integer hospital_id;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="level")
	@Type(value=Types.INTEGER)
	private Integer level;
	
	@Column(name="provice_id")
	@Type(value=Types.INTEGER)
	private Integer provice_id;
	
	@Column(name="city_id")
	@Type(value=Types.INTEGER)
	private Integer city_id;
	
	@Column(name="distric")
	@Type(value=Types.VARCHAR)
	private String distric;
	
	@Column(name="address")
	@Type(value=Types.VARCHAR)
	private String address;

	public Integer getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(Integer hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getProvice_id() {
		return provice_id;
	}

	public void setProvice_id(Integer provice_id) {
		this.provice_id = provice_id;
	}

	public Integer getCity_id() {
		return city_id;
	}

	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}

	public String getDistric() {
		return distric;
	}

	public void setDistric(String distric) {
		this.distric = distric;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}