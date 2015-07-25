package com.cineplex.pojo;

import java.util.ArrayList;
import java.util.List;

import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;

public interface IPlanItemDao {
	public void save(PlanItem transientInstance);
	public void delete(PlanItem persistentInstance);
	public PlanItem findById(java.lang.Integer id);
	public List findByExample(PlanItem instance);
	public List findByProperty(String propertyName, Object value);
	public List findByPlanId(Object planId);
	public List findByDuration(Object duration);
	public List findByFilmId(Object filmId);
	public List findByPrice(Object price);
	public List findBySoldSeatsId(Object soldSeatsId);
	public List findAll();
	public PlanItem merge(PlanItem detachedInstance);
	public void attachDirty(PlanItem instance);
	public void attachClean(PlanItem instance);
	public List findApprovedItems(Object date, Object state, Object time);
}
