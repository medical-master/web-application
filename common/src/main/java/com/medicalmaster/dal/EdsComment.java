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
@Database(name="medical-master")
@Table(name="eds_comment")
public class EdsComment implements DalPojo {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer id;
	
	@Column(name="title")
	@Type(value=Types.VARCHAR)
	private String title;
	
	@Column(name="comment")
	@Type(value=Types.VARCHAR)
	private String comment;
	
	@Column(name="commentUser")
	@Type(value=Types.INTEGER)
	private Integer commentUser;
	
	@Column(name="commentTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp commentTime;
	
	@Column(name="phone")
	@Type(value=Types.VARCHAR)
	private String phone;
	
	@Column(name="email")
	@Type(value=Types.VARCHAR)
	private String email;
	
	@Column(name="feedback")
	@Type(value=Types.VARCHAR)
	private String feedback;
	
	@Column(name="feedbackUser")
	@Type(value=Types.INTEGER)
	private Integer feedbackUser;
	
	@Column(name="feedbackTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp feedbackTime;
	
	@Column(name="status")
	@Type(value=Types.INTEGER)
	private Integer status;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCommentUser() {
		return commentUser;
	}

	public void setCommentUser(Integer commentUser) {
		this.commentUser = commentUser;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Integer getFeedbackUser() {
		return feedbackUser;
	}

	public void setFeedbackUser(Integer feedbackUser) {
		this.feedbackUser = feedbackUser;
	}

	public Timestamp getFeedbackTime() {
		return feedbackTime;
	}

	public void setFeedbackTime(Timestamp feedbackTime) {
		this.feedbackTime = feedbackTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}