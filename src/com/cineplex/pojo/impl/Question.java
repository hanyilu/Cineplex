package com.cineplex.pojo.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question  implements java.io.Serializable {


    // Fields    

     private Integer id;
     private PlanItem planItem;
     private String content;
     private Set<Answer> answers = new HashSet<Answer>();  

    // Constructors

    /** default constructor */
    public Question() {
    }

    
    /** full constructor */
    public Question(PlanItem planItem, String content) {
        this.planItem = planItem;
        this.content = content;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public PlanItem getPlanItem() {
        return this.planItem;
    }
    
    public void setPlanItem(PlanItem planItem) {
        this.planItem = planItem;
    }

    public String getContent() {
        return this.content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }


	public Set<Answer> getAnswers() {
		return answers;
	}


	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
}