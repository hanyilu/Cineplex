package com.cineplex.pojo.impl;



/**
 * Activity entity. @author MyEclipse Persistence Tools
 */

public class Activity  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private Answer answer;
     private Member member;


    // Constructors

    /** default constructor */
    public Activity() {
    }

    
    /** full constructor */
    public Activity(Answer answer, Member member) {
        this.answer = answer;
        this.member = member;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Answer getAnswer() {
        return this.answer;
    }
    
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }
   








}