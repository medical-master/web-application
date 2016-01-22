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
@Table(name="comment")
public class Comment implements DalPojo {
	
	@Id
	@Column(name="comment_id")
	@Type(value=Types.INTEGER)
	private Integer comment_id;
	
	@Column(name="user_id")
	@Type(value=Types.INTEGER)
	private Integer user_id;
	
	@Column(name="commenter_name")
	@Type(value=Types.VARCHAR)
	private String commenter_name;
	
	@Column(name="contact_info")
	@Type(value=Types.VARCHAR)
	private String contact_info;
	
	@Column(name="comment_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp comment_time;
	
	@Column(name="feedback")
	@Type(value=Types.VARCHAR)
	private String feedback;
	
	@Column(name="feedback_time")
	@Type(value=Types.TIMESTAMP)
	private Timestamp feedback_time;

	public Integer getComment_id() {
		return comment_id;
	}

	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getCommenter_name() {
		return commenter_name;
	}

	public void setCommenter_name(String commenter_name) {
		this.commenter_name = commenter_name;
	}

	public String getContact_info() {
		return contact_info;
	}

	public void setContact_info(String contact_info) {
		this.contact_info = contact_info;
	}

	public Timestamp getComment_time() {
		return comment_time;
	}

	public void setComment_time(Timestamp comment_time) {
		this.comment_time = comment_time;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Timestamp getFeedback_time() {
		return feedback_time;
	}

	public void setFeedback_time(Timestamp feedback_time) {
		this.feedback_time = feedback_time;
	}

}