package com.cineplex.pojo.impl;

import org.apache.struts2.json.annotations.JSON;

/**
 * Seat entity. @author MyEclipse Persistence Tools
 */

public class Seat implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roomId;
	private Integer columnNum;
	private Integer rowNum;

	// Constructors

	/** default constructor */
	public Seat() {
	}

	/** full constructor */
	public Seat(Integer roomId, Integer columnNum, Integer rowNum) {
		this.roomId = roomId;
		this.columnNum = columnNum;
		this.rowNum = rowNum;
	}

	// Property accessors
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoomId() {
		return this.roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getColumnNum() {
		return this.columnNum;
	}

	public void setColumnNum(Integer columnNum) {
		this.columnNum = columnNum;
	}

	public Integer getRowNum() {
		return this.rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

}