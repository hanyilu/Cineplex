package com.cineplex.pojo.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Expression;

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

import com.cineplex.pojo.IMemberDao;

/**
 * A data access object (DAO) providing persistence and search support for
 * Member entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.cineplex.pojo.impl.Member
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MemberDAO implements IMemberDao{
	private static final Logger log = LoggerFactory.getLogger(MemberDAO.class);
	// property constants
	public static final String PASSWORD = "password";
	public static final String NAME = "name";
	public static final String BALANCE = "balance";
	public static final String BANK_ACCOUNT = "bankAccount";
	public static final String STATE = "state";
	public static final String LEVEL = "level";
	public static final String CREDIT = "credit";
	public static final String GENDER = "gender";
	public static final String ADDRESS = "address";
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public int save(Member transientInstance) {
		log.debug("saving Member instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
			return transientInstance.getId();
		} catch (RuntimeException re) {
			log.error("save failed", re);
		}
		return -1;
	}

	public void delete(Member persistentInstance) {
		log.debug("deleting Member instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Member findById(java.lang.Integer id) {
		log.debug("getting Member instance with id: " + id);
		try {
			Member instance = (Member) getCurrentSession().get(
					"com.cineplex.pojo.impl.Member", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Member instance) {
		log.debug("finding Member instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.cineplex.pojo.impl.Member")
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
		log.debug("finding Member instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Member as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByBalance(Object balance) {
		return findByProperty(BALANCE, balance);
	}

	public List findByBankAccount(Object bankAccount) {
		return findByProperty(BANK_ACCOUNT, bankAccount);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findByLevel(Object level) {
		return findByProperty(LEVEL, level);
	}

	public List findByCredit(Object credit) {
		return findByProperty(CREDIT, credit);
	}

	public List findByGender(Object gender) {
		return findByProperty(GENDER, gender);
	}

	public List findByAddress(Object address) {
		return findByProperty(ADDRESS, address);
	}

	public List findAll() {
		log.debug("finding all Member instances");
		try {
			String queryString = "from Member";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Member merge(Member detachedInstance) {
		log.debug("merging Member instance");
		try {
			Member result = (Member) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Member instance) {
		log.debug("attaching dirty Member instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Member instance) {
		log.debug("attaching clean Member instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MemberDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MemberDAO) ctx.getBean("MemberDAO");
	}

	@Override
	public List findOverTimeMember(Timestamp time) {
		Criteria criteria = getCurrentSession().createCriteria(Member.class)
				.add(Restrictions.or(
						Restrictions.and(Restrictions.lt("pauseTime", time),Restrictions.eq("state", 1)),
						Restrictions.and(Restrictions.lt("stopTime", time),Restrictions.eq("state", 2))));
		return criteria.list();
	}
	
	@Override
	public List getAddressCount() {
		Query query = getCurrentSession().createQuery(
				"select m.address,count(*) from Member m where m.address!=null group by m.address");
		return query.list();
	}

	@Override
	public List getCardState() {
		Query query = getCurrentSession().createQuery(
				"select m.state,count(*) from Member m where m.state < 5 group by m.state");
		return query.list();
	}

	@Override
	public List getGender() {
		Query query = getCurrentSession().createQuery(
				"select m.gender,count(*) from Member m group by m.gender");
		return query.list();
	}
}