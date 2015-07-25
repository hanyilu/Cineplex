package com.cineplex.pojo;

import java.util.List;

import com.cineplex.pojo.impl.Sales;

public interface ISalesDao {
	public void save(Sales transientInstance);
	public void delete(Sales persistentInstance);
	public Sales findById(java.lang.Integer id);
	public List findByExample(Sales instance);
	public List findByProperty(String propertyName, Object value);
	public List findByMemberId(Object memberId);
	public List findByPlanItemId(Object planItemId);
	public List findByPayType(Object payType);
	public List findBySeatsIds(Object seatsIds);
	public List findByWaiterId(Object waiterId);
	public List findAll();
	public Sales merge(Sales detachedInstance);
	public void attachDirty(Sales instance);
	public void attachClean(Sales instance);
	public List getPayType(String startTime, String endTime);
}
