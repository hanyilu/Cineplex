package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.chrono.JapaneseChronology;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

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

import com.cineplex.pojo.IPlanDao;

/**
 * A data access object (DAO) providing persistence and search support for Plan
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cineplex.pojo.impl.Plan
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class PlanDAO implements IPlanDao{
	private static final Logger log = LoggerFactory.getLogger(PlanDAO.class);
	// property constants
	public static final String WAITER_ID = "waiterId";
	public static final String MANAGER_ID = "managerId";
	public static final String STATE = "state";
	public static final String DATE = "date";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public Plan save(Plan transientInstance) {
		log.debug("saving Plan instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
			return transientInstance;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Plan persistentInstance) {
		log.debug("deleting Plan instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Plan findById(java.lang.Integer id) {
		log.debug("getting Plan instance with id: " + id);
		try {
			Plan instance = (Plan) getCurrentSession().get(
					"com.cineplex.pojo.impl.Plan", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Plan instance) {
		log.debug("finding Plan instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.Plan")
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
		log.debug("finding Plan instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Plan as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWaiterId(Object waiterId) {
		return findByProperty(WAITER_ID, waiterId);
	}

	public List findByManagerId(Object managerId) {
		return findByProperty(MANAGER_ID, managerId);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByDate(Object date) {
		return findByProperty(DATE, date);
	}

	public List findAll() {
		log.debug("finding all Plan instances");
		try {
			String queryString = "from Plan";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Plan merge(Plan detachedInstance) {
		log.debug("merging Plan instance");
		try {
			Plan result = (Plan) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Plan instance) {
		log.debug("attaching dirty Plan instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Plan instance) {
		log.debug("attaching clean Plan instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static PlanDAO getFromApplicationContext(ApplicationContext ctx) {
		return (PlanDAO) ctx.getBean("PlanDAO");
	}
	
	@Override
	public List findByDateAndRoomId(String date, int rid) {
		Criteria criteria = getCurrentSession().createCriteria(Plan.class)
				.add(Restrictions.eq("date", date))
				.add(Restrictions.eq("roomId", rid)); 
		return criteria.list();
	}

	@Override
	public List findByWaiterIdAndState(Object waiterId, Object state) {
		Criteria criteria = getCurrentSession().createCriteria(Plan.class)
				.add(Restrictions.eq("waiterId", waiterId))
				.add(Restrictions.eq("state", state)); 
		return criteria.list();
	}

	@Override
	public List<Plan> getMonthSales(String start, String end) {
		Criteria criteria = getCurrentSession().createCriteria(Plan.class)
				.add(Restrictions.between("date", start, end))
				.add(Restrictions.eq("state", 1)); 
		return criteria.list();
	}
}