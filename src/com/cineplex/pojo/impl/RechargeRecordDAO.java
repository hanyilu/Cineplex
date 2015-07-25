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

import com.cineplex.pojo.IRechargeRecordDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * RechargeRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.cineplex.pojo.impl.RechargeRecord
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class RechargeRecordDAO implements IRechargeRecordDao{
	private static final Logger log = LoggerFactory.getLogger(RechargeRecordDAO.class);
	// property constants
	public static final String AMOUNT = "amount";

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(RechargeRecord transientInstance) {
		log.debug("saving RechargeRecord instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(RechargeRecord persistentInstance) {
		log.debug("deleting RechargeRecord instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RechargeRecord findById(java.lang.Integer id) {
		log.debug("getting RechargeRecord instance with id: " + id);
		try {
			RechargeRecord instance = (RechargeRecord) getCurrentSession().get(
					"com.cineplex.pojo.impl.RechargeRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(RechargeRecord instance) {
		log.debug("finding RechargeRecord instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.RechargeRecord")
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
		log.debug("finding RechargeRecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from RechargeRecord as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findAll() {
		log.debug("finding all RechargeRecord instances");
		try {
			String queryString = "from RechargeRecord";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RechargeRecord merge(RechargeRecord detachedInstance) {
		log.debug("merging RechargeRecord instance");
		try {
			RechargeRecord result = (RechargeRecord) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RechargeRecord instance) {
		log.debug("attaching dirty RechargeRecord instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RechargeRecord instance) {
		log.debug("attaching clean RechargeRecord instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RechargeRecordDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (RechargeRecordDAO) ctx.getBean("RechargeRecordDAO");
	}
}