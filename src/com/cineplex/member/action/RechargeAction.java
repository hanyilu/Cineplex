package com.cineplex.member.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bank.pojo.impl.Bank;
import bank.service.IBankService;

import com.cineplex.member.service.IMemberService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RechargeAction extends ActionSupport{
	
	private Bank bank;
	private int level;
	private HashMap<Integer, Double> levelMap = new HashMap<Integer, Double>();
	private String message;
	@Autowired
    private IMemberService memberService;
	@Autowired
    private IBankService bankService;

	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	public HashMap<Integer, Double> getLevelMap() {
		levelMap.put(1, 200.0);
		levelMap.put(2, 500.0);
		levelMap.put(3, 800.0);
		levelMap.put(4, 1000.0);
		return levelMap;
	}
	public void setLevelMap(HashMap<Integer, Double> levelMap) {
		this.levelMap = levelMap;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getBankAccount(){
		Map session = ActionContext.getContext().getSession();
		String account = memberService.getBankAccount((Integer)session.get("USER_ID"));
		if (account.length() < 1) {
			setMessage("请先绑定银行卡");
			return "message";
		}
		session.put("BANK_ACCOUNT", account);
		return "success";
	}
	
	public String recharge(){
		Map session = ActionContext.getContext().getSession();
		bank.setAccount((String)session.get("BANK_ACCOUNT"));
		double payment = getLevelMap().get(level);
		String bankResult = bankService.pay(bank,payment);
		if (bankResult.equals("fail")) {
			setMessage("账户余额不足");
		} else if(bankResult.equals("error")) {
			setMessage("账号或密码错误");
		} else {
			int memberId = (Integer)session.get("USER_ID");
			if (memberService.recharge(memberId, level, payment)) {
				setMessage("充值成功");
			} else {
				setMessage("未知会员ID");
			}
		}
		return "message";
	}
}
