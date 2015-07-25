package com.cineplex.pojo;

import java.util.List;

import com.cineplex.pojo.impl.Employee;

public interface IEmployeeDao {
	public void save(Employee transientInstance);
	public void delete(Employee persistentInstance);
	public Employee findById(java.lang.Integer id);
	public List findByExample(Employee instance);
	public List findByProperty(String propertyName, Object value);
	public List findByPassword(Object password);
	public List findByName(Object name);
	public List findByGender(Object gender);
	public List findByPosition(Object position);
	public List findAll();
	public Employee merge(Employee detachedInstance);
	public void attachDirty(Employee instance);
	public void attachClean(Employee instance);
}
