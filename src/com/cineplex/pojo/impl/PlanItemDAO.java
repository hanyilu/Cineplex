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

import com.cineplex.pojo.IPlanItemDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * PlanItem entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cineplex.pojo.impl.PlanItem
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PlanItemDAO implements IPlanItemDao{
	private static final Logger log = LoggerFactory
			.getLogger(PlanItemDAO.class);
	// property constants
	public static final String PLAN_ID = "planId";
	public static final String DURATION = "duration";
	public static final String FILM_ID = "filmId";
	public static final String PRICE = "price";
	public static final String SOLD_SEATS_ID = "soldSeatsId";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(PlanItem transientInstance) {
		log.debug("saving PlanItem instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(PlanItem persistentInstance) {
		log.debug("deleting PlanItem instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PlanItem findById(java.lang.Integer id) {
		log.debug("getting PlanItem instance with id: " + id);
		try {
			PlanItem instance = (PlanItem) getCurrentSession().get(
					"com.cineplex.pojo.impl.PlanItem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(PlanItem instance) {
		log.debug("finding PlanItem instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.PlanItem")
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
		log.debug("finding PlanItem instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from PlanItem as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPlanId(Object planId) {
		return findByProperty(PLAN_ID, planId);
	}

	public List findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List findByFilmId(Object filmId) {
		return findByProperty(FILM_ID, filmId);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findBySoldSeatsId(Object soldSeatsId) {
		return findByProperty(SOLD_SEATS_ID, soldSeatsId);
	}

	public List findAll() {
		log.debug("finding all PlanItem instances");
		try {
			String queryString = "from PlanItem";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public PlanItem merge(PlanItem detachedInstance) {
		log.debug("merging PlanItem instance");
		try {
			PlanItem result = (PlanItem) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(PlanItem instance) {
		log.debug("attaching dirty PlanItem instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PlanItem instance) {
		log.debug("attaching clean PlanItem instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PlanItemDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PlanItemDAO) ctx.getBean("PlanItemDAO");
	}
	
	@Override
	public List findApprovedItems(Object date, Object state, Object time) {
		Criteria criteria = getCurrentSession().createCriteria(PlanItem.class)
				.add(Restrictions.gt("duration", time)); 
		criteria.createCriteria("plan")
				.add(Restrictions.eq("date", date))
				.add(Restrictions.eq("state", state));
		return criteria.list();
	}
}