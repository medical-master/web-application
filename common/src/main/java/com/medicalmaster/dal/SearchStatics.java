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
@Table(name="search_statics")
public class SearchStatics implements DalPojo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="keyWord")
	@Type(value=Types.VARCHAR)
	private String keyWord;
	
	@Column(name="searchCnt")
	@Type(value=Types.INTEGER)
	private Integer searchCnt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Integer getSearchCnt() {
		return searchCnt;
	}

	public void setSearchCnt(Integer searchCnt) {
		this.searchCnt = searchCnt;
	}

}