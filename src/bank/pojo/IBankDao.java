package bank.pojo;

import java.util.List;

import bank.pojo.impl.Bank;

public interface IBankDao {
	public void save(Bank transientInstance);
	public void delete(Bank persistentInstance);
	public Bank findById(java.lang.Integer id);
	public List findByExample(Bank instance);
	public List findByProperty(String propertyName, Object value);
	public Bank findByAccount(Object account);
	public List findByPassword(Object password);
	public List findByBalance(Object balance);
	public List findAll();
	public Bank merge(Bank detachedInstance);
	public void attachDirty(Bank instance);
	public void attachClean(Bank instance);
}
