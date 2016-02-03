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
	@Column(name="commentId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer commentId;
	
	@Column(name="userId")
	@Type(value=Types.INTEGER)
	private Integer userId;
	
	@Column(name="commenterName")
	@Type(value=Types.VARCHAR)
	private String commenterName;
	
	@Column(name="contactInfo")
	@Type(value=Types.VARCHAR)
	private String contactInfo;
	
	@Column(name="commentTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp commentTime;
	
	@Column(name="feedback")
	@Type(value=Types.VARCHAR)
	private String feedback;
	
	@Column(name="feedbackTime")
	@Type(value=Types.TIMESTAMP)
	private Timestamp feedbackTime;
	
	@Column(name="status")
	@Type(value=Types.INTEGER)
	private Integer status;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCommenterName() {
		return commenterName;
	}

	public void setCommenterName(String commenterName) {
		this.commenterName = commenterName;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
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