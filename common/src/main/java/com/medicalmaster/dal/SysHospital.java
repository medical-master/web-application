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
@Table(name="sys_hospital")
public class SysHospital implements DalPojo {
	
	@Id
	@Column(name="hospitalId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer hospitalId;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="level")
	@Type(value=Types.INTEGER)
	private Integer level;
	
	@Column(name="proviceId")
	@Type(value=Types.INTEGER)
	private Integer proviceId;
	
	@Column(name="cityId")
	@Type(value=Types.INTEGER)
	private Integer cityId;
	
	@Column(name="districtId")
	@Type(value=Types.INTEGER)
	private Integer districtId;
	
	@Column(name="address")
	@Type(value=Types.VARCHAR)
	private String address;

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
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

	public Integer getProviceId() {
		return proviceId;
	}

	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}