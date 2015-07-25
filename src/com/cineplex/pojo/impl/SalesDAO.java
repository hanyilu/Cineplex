package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cineplex.pojo.ISalesDao;

/**
 * A data access object (DAO) providing persistence and search support for Sales
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cineplex.pojo.impl.Sales
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SalesDAO implements ISalesDao{
	private static final Logger log = LoggerFactory.getLogger(SalesDAO.class);
	// property constants
	public static final String MEMBER_ID = "memberId";
	public static final String PLAN_ITEM_ID = "planItemId";
	public static final String PAY_TYPE = "payType";
	public static final String SEATS_IDS = "seatsIds";
	public static final String WAITER_ID = "waiterId";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Sales transientInstance) {
		log.debug("saving Sales instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Sales persistentInstance) {
		log.debug("deleting Sales instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Sales findById(java.lang.Integer id) {
		log.debug("getting Sales instance with id: " + id);
		try {
			Sales instance = (Sales) getCurrentSession().get(
					"com.cineplex.pojo.impl.Sales", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Sales instance) {
		log.debug("finding Sales instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.Sales")
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
		log.debug("finding Sales instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Sales as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMemberId(Object memberId) {
		return findByProperty(MEMBER_ID, memberId);
	}

	public List findByPlanItemId(Object planItemId) {
		return findByProperty(PLAN_ITEM_ID, planItemId);
	}

	public List findByPayType(Object payType) {
		return findByProperty(PAY_TYPE, payType);
	}

	public List findBySeatsIds(Object seatsIds) {
		return findByProperty(SEATS_IDS, seatsIds);
	}

	public List findByWaiterId(Object waiterId) {
		return findByProperty(WAITER_ID, waiterId);
	}

	public List findAll() {
		log.debug("finding all Sales instances");
		try {
			String queryString = "from Sales";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Sales merge(Sales detachedInstance) {
		log.debug("merging Sales instance");
		try {
			Sales result = (Sales) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Sales instance) {
		log.debug("attaching dirty Sales instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Sales instance) {
		log.debug("attaching clean Sales instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SalesDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SalesDAO) ctx.getBean("SalesDAO");
	}

	@Override
	public List getPayType(String startTime, String endTime) {
		Query query = getCurrentSession().createQuery(
				"select s.payType,count(*) from Sales s where s.time between '"+startTime+"' and '"+endTime+
				"' group by s.payType");
		return query.list();
	}
}