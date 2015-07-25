package com.cineplex.employee.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IManagerService;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ApprovePlanAction extends ActionSupport{
	
	private List<Plan> plans;
	private int pid;
	private List<PlanItem> planItems;
	private String message;
	
	@Autowired
	private IManagerService managerService;
	
	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}
	
	public List<Plan> getPlans() {
		return plans;
	}
	
	public int getPid() {
		return pid;
	}

	public List<PlanItem> getPlanItems() {
		return planItems;
	}

	public void setPlanItems(List<PlanItem> planItems) {
		this.planItems = planItems;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUnapprovedPlans(){
		List<Plan> unapprovedPlans = managerService.getUnapprovedPlans();
		setPlans(unapprovedPlans);
		return "success";
	}
	
	public String viewPlan(){
		List<PlanItem> items = managerService.getPlanItems(pid);
		if (items.size() > 0) {
			setPlanItems(items);
			return "success";
		} else {
			setMessage("读取失败请重试。");
			return "message";
		}
	}
	
	public String approve(){
		Map session = ActionContext.getContext().getSession();
		if (managerService.approve(pid, (Integer)session.get("USER_ID"))) {
			return "success";
		} else {
			setMessage("操作失败请重试。");
			return "message";
		}
	}
	
	public String unapprove(){
		Map session = ActionContext.getContext().getSession();
		if (managerService.unapprove(pid, (Integer)session.get("USER_ID"))) {
			return "success";
		} else {
			setMessage("操作失败请重试。");
			return "message";
		}
	}
}
