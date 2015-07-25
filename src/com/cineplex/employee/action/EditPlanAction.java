package com.cineplex.employee.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IWaiterService;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditPlanAction extends ActionSupport{
	
	private List<Plan> plans;
	private int pid;
	private Plan plan;
	private List<Film> films;
	private List<PlanItem> planItems;
	private String message;

	@Autowired
	private IWaiterService waiterService;

	public List<Plan> getPlans() {
		return plans;
	}

	public void setPlans(List<Plan> plans) {
		this.plans = plans;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public List<PlanItem> getPlanItems() {
		return planItems;
	}

	public void setPlanItems(List<PlanItem> planItems) {
		this.planItems = planItems;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPlansToEdit(){
		Map session = ActionContext.getContext().getSession();
		List<Plan> plans = waiterService.getEditPlans((Integer)session.get("USER_ID"));
		if (plans.size() > 0) {
			setPlans(plans);
			return "success";
		} else {
			setMessage("没有要修改的计划");
			return "message";
		}
	}
	
	public String editPlan(){
		this.setFilms(waiterService.getFilms());
		Plan p = waiterService.getPlan(pid);
		this.setPlan(p);
		List<PlanItem> itemList = new ArrayList<PlanItem>();
		itemList.addAll(p.getPlanItems());
		this.setPlanItems(itemList);
		return "success";
	}
	
	public String submitEdit(){
		try {
			waiterService.deleteOldPlanItems(pid);
			Plan p = waiterService.getPlan(pid);
			Set<PlanItem> pitems = new HashSet<PlanItem>();
			for (PlanItem item : planItems) {
				if (item.getDuration().intern()!="" && item.getFilm().getId() != 0) {
					item.setPlan(p);
					pitems.add(item);
				}
			}
			p.setPlanItems(pitems);
			p.setState(0);
			p.setSubmitTime(new Timestamp(new Date().getTime()));
			waiterService.mergePlan(p);
			return "success";
		} catch (Exception e) {
			setMessage("操作失败请重试");
			return "message";
		}
	}
}
