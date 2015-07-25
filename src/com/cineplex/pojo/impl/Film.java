package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Film entity. @author MyEclipse Persistence Tools
 */

public class Film implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer duration;
	private String director;
	private String staring;
	private String description;
	private Timestamp onlineTime;
	private Timestamp offlineTime;
	private int state;
	private Set<PlanItem> planItems = new HashSet<PlanItem>();  

	// Constructors

	/** default constructor */
	public Film() {
	}

	/** minimal constructor */
	public Film(String name, Integer duration, Timestamp onlineTime,
			Timestamp offlineTime, int state) {
		this.name = name;
		this.duration = duration;
		this.onlineTime = onlineTime;
		this.offlineTime = offlineTime;
		this.state = state;
	}

	/** full constructor */
	public Film(String name, Integer duration, String director, String staring,
			String description, Timestamp onlineTime, Timestamp offlineTime, int state) {
		this.name = name;
		this.duration = duration;
		this.director = director;
		this.staring = staring;
		this.description = description;
		this.onlineTime = onlineTime;
		this.offlineTime = offlineTime;
		this.state = state;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return this.duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getDirector() {
		return this.director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStaring() {
		return this.staring;
	}

	public void setStaring(String staring) {
		this.staring = staring;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getOnlineTime() {
		return this.onlineTime;
	}

	public void setOnlineTime(Timestamp onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Timestamp getOfflineTime() {
		return this.offlineTime;
	}

	public void setOfflineTime(Timestamp offlineTime) {
		this.offlineTime = offlineTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Set<PlanItem> getPlanItems() {
		return planItems;
	}

	public void setPlanItems(Set<PlanItem> planItems) {
		this.planItems = planItems;
	}

}