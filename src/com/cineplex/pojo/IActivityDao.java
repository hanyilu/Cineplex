package com.cineplex.pojo;

import java.util.List;

import com.cineplex.pojo.impl.Activity;

public interface IActivityDao {
	public void save(Activity transientInstance);
	public void delete(Activity persistentInstance);
	public Activity findById(java.lang.Integer id);
	public List findByExample(Activity instance);
	public List findByProperty(String propertyName, Object value);
	public List findByAnswerId(Object answerId);
	public List findAll();
	public Activity merge(Activity detachedInstance);
	public void attachDirty(Activity instance);
	public void attachClean(Activity instance);
}
