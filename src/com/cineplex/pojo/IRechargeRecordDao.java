package com.cineplex.pojo;

import java.util.List;

import com.cineplex.pojo.impl.RechargeRecord;

public interface IRechargeRecordDao {
	public void save(RechargeRecord transientInstance);
	public void delete(RechargeRecord persistentInstance);
	public RechargeRecord findById(java.lang.Integer id);
	public List findByExample(RechargeRecord instance);
	public List findByProperty(String propertyName, Object value);
	public List findByAmount(Object amount);
	public List findAll();
	public RechargeRecord merge(RechargeRecord detachedInstance);
	public void attachDirty(RechargeRecord instance);
	public void attachClean(RechargeRecord instance);
}
