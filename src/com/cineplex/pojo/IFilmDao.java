package com.cineplex.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.cineplex.pojo.impl.Film;

public interface IFilmDao {
	public void save(Film transientInstance);
	public void delete(Film persistentInstance);
	public Film findById(java.lang.Integer id);
	public List findByExample(Film instance);
	public List findByProperty(String propertyName, Object value);
	public List findByName(Object name);
	public List findByDuration(Object duration);
	public List findByDirector(Object director);
	public List findByStaring(Object staring);
	public List findByDescription(Object description);
	public List findOnlineFilms();
	public List findAll();
	public Film merge(Film detachedInstance);
	public void attachDirty(Film instance);
	public void attachClean(Film instance);
	public List findOfflineFilm(Timestamp time);
}
