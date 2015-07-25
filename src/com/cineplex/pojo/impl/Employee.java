package com.cineplex.pojo.impl;

import java.util.HashSet;
import java.util.Set;

/**
 * Employee entity. @author MyEclipse Persistence Tools
 */

public class Employee implements java.io.Serializable {

	// Fields

	private Integer id;
	private String password;
	private String name;
	private String gender;
	private String position;
	private Set<Sales> sales = new HashSet<Sales>();  

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(String password, String name, String gender, String position) {
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.position = position;
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

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Set<Sales> getSales() {
		return sales;
	}

	public void setSales(Set<Sales> sales) {
		this.sales = sales;
	}

}