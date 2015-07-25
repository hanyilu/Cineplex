package com.cineplex.pojo;

import java.util.ArrayList;
import java.util.List;

import com.cineplex.pojo.impl.Question;

public interface IQuestionDao {
	public void save(Question transientInstance);
	public void delete(Question persistentInstance);
	public Question findById(java.lang.Integer id);
	public List findByExample(Question instance);
	public List findByProperty(String propertyName, Object value);
	public List findByPlanItemId(Object planItemId);
	public List findByContent(Object content);
	public List findAll();
	public Question merge(Question detachedInstance);
	public void attachDirty(Question instance);
	public void attachClean(Question instance);
	public List getQuestions(String ids);
}
