package com.cineplex.pojo.impl;

import java.util.HashSet;
import java.util.Set;


/**
 * PlanItem entity. @author MyEclipse Persistence Tools
 */

public class PlanItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private Plan plan;
	private String duration;
	private Film film;
	private Double price;
	private String soldSeatsId;
	private Set<Sales> sales = new HashSet<Sales>();  
	private Set<Question> questions = new HashSet<Question>();  

	// Constructors

	/** default constructor */
	public PlanItem() {
	}

	/** minimal constructor */
	public PlanItem(Plan plan, String duration,
			Film film, Double price) {
		this.plan = plan;
		this.duration = duration;
		this.film = film;
		this.price = price;
	}

	/** full constructor */
	public PlanItem(Plan plan, String duration,
			Film film, Double price, String soldSeatsId) {
		this.plan = plan;
		this.duration = duration;
		this.film = film;
		this.price = price;
		this.soldSeatsId = soldSeatsId;
	}
	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getSoldSeatsId() {
		return this.soldSeatsId;
	}

	public void setSoldSeatsId(String soldSeatsId) {
		this.soldSeatsId = soldSeatsId;
	}

	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}