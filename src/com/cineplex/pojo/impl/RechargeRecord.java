package com.cineplex.pojo.impl;

import java.sql.Timestamp;


/**
 * RechargeRecord entity. @author MyEclipse Persistence Tools
 */

public class RechargeRecord  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Member member;
     private double amount;
     private Timestamp time;


    // Constructors

    /** default constructor */
    public RechargeRecord() {
    }

    
    /** full constructor */
    public RechargeRecord(Member member, Integer amount, Timestamp time) {
        this.member = member;
        this.amount = amount;
        this.time = time;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getTime() {
        return this.time;
    }
    
    public void setTime(Timestamp time) {
        this.time = time;
    }
   








}