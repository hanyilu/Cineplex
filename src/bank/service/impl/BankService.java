package bank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import bank.pojo.IBankDao;
import bank.pojo.impl.Bank;
import bank.service.IBankService;

public class BankService implements IBankService {
	
	@Autowired
	private IBankDao bankDao;

	public String pay(Bank bank, double pay) {
		try {
			Bank b = bankDao.findByAccount(bank.getAccount());
			if (!b.getPassword().equals(bank.getPassword())) {
				throw new Exception();
			}
			if (b.getBalance() < pay) {
				return "fail";
			}
			b.setBalance(b.getBalance()-pay);
			bankDao.merge(b);
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

}
