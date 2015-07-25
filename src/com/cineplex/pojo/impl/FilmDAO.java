package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.cineplex.pojo.IFilmDao;

/**
 * A data access object (DAO) providing persistence and search support for Film
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.cineplex.pojo.impl.Film
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FilmDAO implements IFilmDao{
	private static final Logger log = LoggerFactory.getLogger(FilmDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String DURATION = "duration";
	public static final String DIRECTOR = "director";
	public static final String STARING = "staring";
	public static final String DESCRIPTION = "description";
	public static final String ONLINE_TIME = "onlineTime";
	public static final String OFFLINE_TIME = "offlineTime";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Film transientInstance) {
		log.debug("saving Film instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Film persistentInstance) {
		log.debug("deleting Film instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Film findById(java.lang.Integer id) {
		log.debug("getting Film instance with id: " + id);
		try {
			Film instance = (Film) getCurrentSession().get(
					"com.cineplex.pojo.impl.Film", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Film instance) {
		log.debug("finding Film instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.Film")
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
		log.debug("finding Film instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Film as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByDuration(Object duration) {
		return findByProperty(DURATION, duration);
	}

	public List findByDirector(Object director) {
		return findByProperty(DIRECTOR, director);
	}

	public List findByStaring(Object staring) {
		return findByProperty(STARING, staring);
	}

	public List findByDescription(Object description) {
		return findByProperty(DESCRIPTION, description);
	}
	
	public List findOnlineFilms() {
		try {
			Criteria criteria = getCurrentSession().createCriteria(Film.class);
			List results = criteria.add(Restrictions.ge(OFFLINE_TIME, new Date())).list();
			return results;
		} catch (RuntimeException re) {
			log.error("find failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all Film instances");
		try {
			String queryString = "from Film";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Film merge(Film detachedInstance) {
		log.debug("merging Film instance");
		try {
			Film result = (Film) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Film instance) {
		log.debug("attaching dirty Film instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Film instance) {
		log.debug("attaching clean Film instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FilmDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmDAO) ctx.getBean("FilmDAO");
	}

	@Override
	public List findOfflineFilm(Timestamp time) {
		Criteria criteria = getCurrentSession().createCriteria(Film.class)
				.add(Restrictions.lt("offlineTime", time))
				.add(Restrictions.eq("state", 0));
		return criteria.list();
	}

}