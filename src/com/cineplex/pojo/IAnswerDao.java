package com.cineplex.pojo;

import java.util.List;

import com.cineplex.pojo.impl.Answer;

public interface IAnswerDao {
	public void save(Answer transientInstance);
	public void delete(Answer persistentInstance);
	public Answer findById(java.lang.Integer id);
	public List findByExample(Answer instance);
	public List findByProperty(String propertyName, Object value);
	public List findByQuestionId(Object questionId);
	public List findByAnswer(Object answer);
	public List findByCount(Object count);
	public List findAll();
	public Answer merge(Answer detachedInstance);
	public void attachDirty(Answer instance);
	public void attachClean(Answer instance);
}
