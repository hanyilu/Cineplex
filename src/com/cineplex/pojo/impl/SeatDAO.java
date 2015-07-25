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

import com.cineplex.pojo.ISeatDao;

/**
 * A data access object (DAO) providing persistence and search support for Seat
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cineplex.pojo.impl.Seat
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class SeatDAO implements ISeatDao{
	private static final Logger log = LoggerFactory.getLogger(SeatDAO.class);
	// property constants
	public static final String ROOM_ID = "roomId";
	public static final String COLUMN_NUM = "columnNum";
	public static final String ROW_NUM = "rowNum";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Seat transientInstance) {
		log.debug("saving Seat instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Seat persistentInstance) {
		log.debug("deleting Seat instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Seat findById(java.lang.Integer id) {
		log.debug("getting Seat instance with id: " + id);
		try {
			Seat instance = (Seat) getCurrentSession().get(
					"com.cineplex.pojo.impl.Seat", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Seat instance) {
		log.debug("finding Seat instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.Seat")
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
		log.debug("finding Seat instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Seat as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoomId(Object roomId) {
		return findByProperty(ROOM_ID, roomId);
	}

	public List findByColumNum(Object columNum) {
		return findByProperty(COLUMN_NUM, columNum);
	}

	public List findByRowNum(Object rowNum) {
		return findByProperty(ROW_NUM, rowNum);
	}

	public List findAll() {
		log.debug("finding all Seat instances");
		try {
			String queryString = "from Seat";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Seat merge(Seat detachedInstance) {
		log.debug("merging Seat instance");
		try {
			Seat result = (Seat) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Seat instance) {
		log.debug("attaching dirty Seat instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Seat instance) {
		log.debug("attaching clean Seat instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SeatDAO getFromApplicationContext(ApplicationContext ctx) {
		return (SeatDAO) ctx.getBean("SeatDAO");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Seat> findByRoomAndRow(Integer roomId, int row) {
		List<Seat> list = new ArrayList<Seat>();
		list = getCurrentSession().createCriteria(Seat.class)
				.add(Restrictions.eq("roomId", roomId))
				.add(Restrictions.eq("rowNum", row))
				.list();
		return list;
	}

	@Override
	public List getSeatCount() {
		Query query = getCurrentSession().createQuery(
				"select s.roomId,count(*) from Seat s group by s.roomId");
		return query.list();
	}
}