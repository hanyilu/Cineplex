package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Plan entity. @author MyEclipse Persistence Tools
 */

public class Plan implements java.io.Serializable {

	// Fields

	private Integer id;
	private Timestamp submitTime;
	private Integer waiterId;
	private Integer managerId;
	private Integer state;
	private String date;
	private Integer roomId;
	private Set<PlanItem> planItems = new HashSet<PlanItem>();  

	// Constructors

	/** default constructor */
	public Plan() {
	}

	/** minimal constructor */
	public Plan(Timestamp submitTime, Integer waiterId, Integer state, String date, Integer roomId) {
		this.submitTime = submitTime;
		this.waiterId = waiterId;
		this.state = state;
		this.date = date;
		this.roomId = roomId;
	}

	/** full constructor */
	public Plan(Timestamp submitTime, Integer waiterId, Integer managerId,
			Integer state, String date, Integer roomId) {
		this.submitTime = submitTime;
		this.waiterId = waiterId;
		this.managerId = managerId;
		this.state = state;
		this.date = date;
		this.roomId = roomId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Integer getWaiterId() {
		return this.waiterId;
	}

	public void setWaiterId(Integer waiterId) {
		this.waiterId = waiterId;
	}

	public Integer getManagerId() {
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<PlanItem> getPlanItems() {
		return planItems;
	}

	public void setPlanItems(Set<PlanItem> planItems) {
		this.planItems = planItems;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

}