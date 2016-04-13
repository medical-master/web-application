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
@Database(name="")
@Table(name="")
public class DiagPlanViewPojo implements DalPojo {
	
	@Column(name="id")
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="name")
	@Type(value=Types.VARCHAR)
	private String name;
	
	@Column(name="hosptialId")
	@Type(value=Types.INTEGER)
	private Integer hosptialId;
	
	@Column(name="publishTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp publishTime;
	
	@Column(name="visitCnt")
	@Type(value=Types.INTEGER)
	private Integer visitCnt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getHosptialId() {
		return hosptialId;
	}

	public void setHosptialId(Integer hosptialId) {
		this.hosptialId = hosptialId;
	}

	public Timestamp getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(Integer visitCnt) {
		this.visitCnt = visitCnt;
	}

}