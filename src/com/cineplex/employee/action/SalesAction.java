package com.cineplex.employee.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IWaiterService;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.PlanItem;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SalesAction extends ActionSupport{
	
	private Map<Film, List<PlanItem>> filmItems = new HashMap<Film, List<PlanItem>>();
	private int mid;
	private int pid;
	private String seats;
	private int crash;
	private String message;
	@Autowired
    private IWaiterService waiterService;

	public Map<Film, List<PlanItem>> getFilmItems() {
		return filmItems;
	}

	public void setFilmItems(Map<Film, List<PlanItem>> filmItems) {
		this.filmItems = filmItems;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public int getCrash() {
		return crash;
	}

	public void setCrash(int crash) {
		this.crash = crash;
	}

	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

    public String getTodayPlanItems(){
    	List<PlanItem> planItems = waiterService.getTodayPlanItems();
    	for (PlanItem item : planItems) {
			Film film = item.getFilm();
			if (filmItems.containsKey(film)) {
				filmItems.get(film).add(item);
			} else {
				List<PlanItem> items = new ArrayList<PlanItem>();
				items.add(item);
				filmItems.put(film, items);
			}
		}
        return "success";  
    }  
    
    public String sales(){
    	Map session = ActionContext.getContext().getSession();
    	String result = waiterService.sales(mid, pid, seats, (Integer)session.get("USER_ID"), crash);
    	return "success"; 
    }
}
