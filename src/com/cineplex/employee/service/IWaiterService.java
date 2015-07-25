package com.cineplex.employee.service;

import java.util.List;
import java.util.Set;

import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;

public interface IWaiterService {

	public boolean addFilm(Film film);
	public List<Film> getFilms();
	public Plan createPlan(Plan plan);
	public void savePlans(List<PlanItem> planItems);
	public List<Plan> getEditPlans(int uid);
	public Plan getPlan(int pid);
	public List<PlanItem> getPlanItems(int pid);
	public void mergePlan(Plan plan);
	public void deleteOldPlanItems(int pid);
	public List<Film> getOnlineFilms();
	public Film getFilm(int fid);
	public boolean addActivity(Set<Question> questionSet, List<Integer> selectItemId);
	public List<PlanItem> getTodayPlanItems();
	public String sales(int mid, int pid, String seats, int wid, int crash);
}
