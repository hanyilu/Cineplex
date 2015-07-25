package com.cineplex.pojo;

import java.util.List;

import com.cineplex.pojo.impl.Seat;

public interface ISeatDao {
	public void save(Seat transientInstance);
	public void delete(Seat persistentInstance);
	public Seat findById(java.lang.Integer id);
	public List findByExample(Seat instance);
	public List findByProperty(String propertyName, Object value);
	public List findByRoomId(Object roomId);
	public List findByColumNum(Object columNum);
	public List findByRowNum(Object rowNum);
	public List findAll();
	public Seat merge(Seat detachedInstance);
	public void attachDirty(Seat instance);
	public void attachClean(Seat instance);
	public List<Seat> findByRoomAndRow(Integer roomId, int row);
	public List getSeatCount();
}
