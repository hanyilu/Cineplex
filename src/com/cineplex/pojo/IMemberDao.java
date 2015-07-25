package com.cineplex.pojo;

import java.sql.Timestamp;
import java.util.List;

import com.cineplex.pojo.impl.Member;

public interface IMemberDao {
	public int save(Member transientInstance);
	public void delete(Member persistentInstance);
	public Member findById(java.lang.Integer id);
	public List findByExample(Member instance);
	public List findByProperty(String propertyName, Object value);
	public List findByPassword(Object password);
	public List findByName(Object name);
	public List findByBalance(Object balance);
	public List findByBankAccount(Object bankAccount);
	public List findByState(Object state);
	public List findByLevel(Object level);
	public List findByCredit(Object credit);
	public List findByGender(Object gender);
	public List findByAddress(Object address);
	public List findAll();
	public Member merge(Member detachedInstance);
	public void attachDirty(Member instance);
	public void attachClean(Member instance);
	public List findOverTimeMember(Timestamp time);
	public List getAddressCount();
	public List getCardState();
	public List getGender();
}
