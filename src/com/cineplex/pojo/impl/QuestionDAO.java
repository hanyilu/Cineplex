package com.cineplex.pojo.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cineplex.pojo.IQuestionDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * Question entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cineplex.pojo.impl.Question
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class QuestionDAO implements IQuestionDao{
	private static final Logger log = LoggerFactory.getLogger(QuestionDAO.class);
	// property constants
	public static final String PLAN_ITEM_ID = "planItemId";
	public static final String CONTENT = "content";

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Question transientInstance) {
		log.debug("saving Question instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Question persistentInstance) {
		log.debug("deleting Question instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Question findById(java.lang.Integer id) {
		log.debug("getting Question instance with id: " + id);
		try {
			Question instance = (Question) getCurrentSession().get(
					"com.cineplex.pojo.impl.Question", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Question instance) {
		log.debug("finding Question instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.Question")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Question instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Question as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPlanItemId(Object planItemId) {
		return findByProperty(PLAN_ITEM_ID, planItemId);
	}

	public List findByContent(Object content) {
		return findByProperty(CONTENT, content);
	}

	public List findAll() {
		log.debug("finding all Question instances");
		try {
			String queryString = "from Question";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Question merge(Question detachedInstance) {
		log.debug("merging Question instance");
		try {
			Question result = (Question) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Question instance) {
		log.debug("attaching dirty Question instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Question instance) {
		log.debug("attaching clean Question instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static QuestionDAO getFromApplicationContext(ApplicationContext ctx) {
		return (QuestionDAO) ctx.getBean("QuestionDAO");
	}

	@Override
	public List getQuestions(String ids) {
		Query query = getCurrentSession().createQuery(
				"select q.content,a.answer,sum(a.count) from Question q,Answer a,PlanItem p "
				+ "where a.question.id=q.id and q.planItem.id=p.id and p.id in "+ids+" group by q.content,a.answer");
		return query.list();
	}
}