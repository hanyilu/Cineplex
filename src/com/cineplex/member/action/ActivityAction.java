package com.cineplex.member.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.member.service.IMemberService;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActivityAction extends ActionSupport{
	
	private List<PlanItem> activities;
	private int pi;
	private List<Question> questionList;
	private List<Integer> answers;
	private String message;
	@Autowired
    private IMemberService memberService;

	public List<PlanItem> getActivities() {
		return activities;
	}
	
	public void setActivities(List<PlanItem> activities) {
		this.activities = activities;
	}

	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<Integer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Integer> answers) {
		this.answers = answers;
	}

	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

    public String getActivityList(){
    	Map session = ActionContext.getContext().getSession();
        List<PlanItem> activities = memberService.getActivityItemList((Integer) session.get("USER_ID"));
        setActivities(activities);
		return "success";  
    }  
    
    public String getQuestions(){
        Set<Question> questions = memberService.getPlanItem(pi).getQuestions();
        if (questions.size() > 0) {
        	List<Question> ques = new ArrayList<Question>();
        	ques.addAll(questions);
        	setQuestionList(ques);
			return "success";
		}
        setMessage("读取失败请重试");
        return "message";  
    }
    
    public String submitAnswers(){
    	Map session = ActionContext.getContext().getSession();
        if (memberService.submitAnswers(answers, (Integer) session.get("USER_ID"))) {
			return SUCCESS;
		} else {
			setMessage("提交失败");
		}
        return "message";  
    }
}
