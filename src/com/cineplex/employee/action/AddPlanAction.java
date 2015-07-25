package com.cineplex.employee.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IWaiterService;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AddPlanAction extends ActionSupport{
	private List<PlanItem> planItems;
	private Plan plan;
	private List<Film> films;
	private String message;
	@Autowired
	private IWaiterService waiterService;
	
	public List<PlanItem> getPlanItems() {
		return planItems;
	}
	public void setPlanItems(List<PlanItem> planItems) {
		this.planItems = planItems;
	}
	public Plan getPlan() {
		return plan;
	}
	public void setPlan(Plan plan) {
		this.plan = plan;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void setFilms(List<Film> films) {
		this.films = films;
	}
	public List<Film> getFilms(){
		return films;
	}
	
	public String getFilmsList() {
		List<Film> list = waiterService.getFilms();
		if (list.size() > 0) {
			setFilms(list);
			return "success";
		} else {
			setMessage("请先添加电影");
			return "message";
		}
		
	}
	
	public String addPlan(){
		try {
			Map session = ActionContext.getContext().getSession();
			plan.setWaiterId((Integer)session.get("USER_ID"));
			plan.setSubmitTime(new Timestamp(new Date().getTime()));
			Plan p = waiterService.createPlan(plan);
			List<PlanItem> list = new ArrayList<PlanItem>();
			for (PlanItem item : planItems) {
				if (item.getDuration().intern()!="" && item.getFilm().getId() != 0) {
					item.setPlan(p);
					list.add(item);
				}
			}
			waiterService.savePlans(list);
			setMessage("提交成功");
		} catch (Exception e) {
			setMessage("提交失败");
		}  
		return "message";
	}

}
