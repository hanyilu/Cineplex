package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */

public class Member implements java.io.Serializable {

	// Fields

	private Integer id;
	private String password;
	private String name;
	private Double balance;
	private String bankAccount;
	private Integer state;
	private Timestamp startTime;
	private Timestamp pauseTime;
	private Timestamp stopTime;
	private Integer level;
	private Integer credit;
	private String birthday;
	private String gender;
	private String address;
	private Set<Sales> sales = new HashSet<Sales>();  
	private Set<RechargeRecord> rechargeRecords = new HashSet<RechargeRecord>();  
	private Set<Activity> activities = new HashSet<Activity>();  
	
	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String name, String gender) {
		this.name = name;
		this.gender = gender;
	}

	/** full constructor */
	public Member(String password, String name, Double balance,
			String bankAccount, Integer state, Timestamp startTime,
			Timestamp pauseTime, Timestamp stopTime, Integer level,
			Integer credit, String birthday, String gender, String address) {
		this.password = password;
		this.name = name;
		this.balance = balance;
		this.bankAccount = bankAccount;
		this.state = state;
		this.startTime = startTime;
		this.pauseTime = pauseTime;
		this.stopTime = stopTime;
		this.level = level;
		this.credit = credit;
		this.birthday = birthday;
		this.gender = gender;
		this.address = address;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getPauseTime() {
		return this.pauseTime;
	}

	public void setPauseTime(Timestamp pauseTime) {
		this.pauseTime = pauseTime;
	}

	public Timestamp getStopTime() {
		return this.stopTime;
	}

	public void setStopTime(Timestamp stopTime) {
		this.stopTime = stopTime;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

	public Set<RechargeRecord> getRechargeRecords() {
		return rechargeRecords;
	}

	public void setRechargeRecords(Set<RechargeRecord> rechargeRecords) {
		this.rechargeRecords = rechargeRecords;
	}

	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}

}