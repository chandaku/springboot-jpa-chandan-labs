package com.chandan.labs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDate;

import com.chandan.labs.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(schema = "user_survey", name = "USER_SURVEY_RESPONSE")
public class UserSurvey {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "question_id")
	private Long questionId;
	
	@Column(name = "answer_id")
	private Long answerId;
	
	@Column(name = "flight_no")
	private String flightNo;
	
	@Column(name = "survey_date")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDate surveyDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public LocalDate getSurveyDate() {
		return surveyDate;
	}

	public void setSurveyDate(LocalDate surveyDate) {
		this.surveyDate = surveyDate;
	}
}
