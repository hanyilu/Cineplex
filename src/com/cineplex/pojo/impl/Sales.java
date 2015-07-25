package com.cineplex.pojo.impl;

import java.sql.Timestamp;

/**
 * Sales entity. @author MyEclipse Persistence Tools
 */

public class Sales implements java.io.Serializable {

	// Fields

	private Integer id;
	private Member member;
	private PlanItem planItem;
	private Double payment;
	private Integer payType;
	private Timestamp time;
	private String seatsIds;
	private Employee waiter;
	private Integer seatCount;
	// Constructors

	/** default constructor */
	public Sales() {
	}

	/** full constructor */
	public Sales(Member member, PlanItem planItem, Double payment, Integer payType,
			Timestamp time, String seatsIds, Employee waiter, Integer seatCount) {
		this.member = member;
		this.planItem = planItem;
		this.payment = payment;
		this.payType = payType;
		this.time = time;
		this.seatsIds = seatsIds;
		this.waiter = waiter;
		this.seatCount = seatCount;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public PlanItem getPlanItem() {
		return this.planItem;
	}

	public void setPlanItem(PlanItem planItem) {
		this.planItem = planItem;
	}
	
	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public String getSeatsIds() {
		return this.seatsIds;
	}

	public void setSeatsIds(String seatsIds) {
		this.seatsIds = seatsIds;
	}

	public Employee getWaiter() {
		return this.waiter;
	}

	public void setWaiter(Employee waiter) {
		this.waiter = waiter;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}
	
}