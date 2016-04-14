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
@Database(name="")
@Table(name="")
    public class TrainMaterialViewPojoPojo implements DalPojo {
	
	@Column(name="id")
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="workstationId")
	@Type(value=Types.INTEGER)
	private Integer workstationId;
	
	@Column(name="description")
	@Type(value=Types.VARCHAR)
	private String description;
	
	@Column(name="materialFile")
	@Type(value=Types.INTEGER)
	private Integer materialFile;
	
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

	public Integer getWorkstationId() {
		return workstationId;
	}

	public void setWorkstationId(Integer workstationId) {
		this.workstationId = workstationId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaterialFile() {
		return materialFile;
	}

	public void setMaterialFile(Integer materialFile) {
		this.materialFile = materialFile;
	}

	public Integer getVisitCnt() {
		return visitCnt;
	}

	public void setVisitCnt(Integer visitCnt) {
		this.visitCnt = visitCnt;
	}

}
