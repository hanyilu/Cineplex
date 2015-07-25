package com.cineplex.pojo.impl;

import java.util.HashSet;
import java.util.Set;

/**
 * Answer entity. @author MyEclipse Persistence Tools
 */

public class Answer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Question question;
	private String answer;
	private Integer count;
	private Set<Activity> activities = new HashSet<Activity>();

	// Constructors

	/** default constructor */
	public Answer() {
	}

	/** full constructor */
	public Answer(Question question, String answer, Integer count) {
		this.question = question;
		this.answer = answer;
		this.count = count;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

}