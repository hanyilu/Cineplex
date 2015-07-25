package com.cineplex.pojo;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.SessionFactory;

import com.cineplex.pojo.impl.Plan;

public interface IPlanDao {
	public Plan save(Plan transientInstance);
	public void delete(Plan persistentInstance);
	public Plan findById(java.lang.Integer id);
	public List findByExample(Plan instance);
	public List findByProperty(String propertyName, Object value);
	public List findByWaiterId(Object waiterId);
	public List findByManagerId(Object managerId);
	public List findByState(Object state);
	public List findByDate(Object date);
	public List findAll();
	public Plan merge(Plan detachedInstance);
	public void attachDirty(Plan instance);
	public void attachClean(Plan instance);
	public List findByWaiterIdAndState(Object waiterId, Object state);
	public List<Plan> getMonthSales(String start, String end);
	public List findByDateAndRoomId(String date, int rid);
}
