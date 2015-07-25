package com.cineplex.member.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.util.IteratorGenerator.Converter;
import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.member.service.IMemberService;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.MemberDAO;
import com.cineplex.pojo.impl.RechargeRecord;
import com.cineplex.pojo.impl.Sales;
import com.cineplex.pojo.impl.Seat;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberAction extends ActionSupport{
	
	private int credit;
	private Member member;
	private List<Sales> sales;
	private List<RechargeRecord> rechargeRecords;
	private String password;
	private String newPassword;
	private String rePassword;
	private String message;
	@Autowired
	private IMemberService memberService;
	
	
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List<Sales> getSales() {
		return sales;
	}

	public void setSales(List<Sales> sales) {
		this.sales = sales;
	}

	public List<RechargeRecord> getRechargeRecords() {
		return rechargeRecords;
	}

	public void setRechargeRecords(List<RechargeRecord> rechargeRecords) {
		this.rechargeRecords = rechargeRecords;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
    public String login(){
        if (memberService.hasMatch(member)) {
        	setMessage("Welcome!");
        	Map session = ActionContext.getContext().getSession();
            session.put("USER_ID", member.getId());
            session.put("USER_TYPE", "member");
            return "success";
        }
        setMessage("用户名不存在或密码错误！");
        return "message";  
    } 
   
	public String cancel() {
		Map session = ActionContext.getContext().getSession();
		if(memberService.cancel((Integer)session.get("USER_ID"))){
			session.clear();
			return "success";
		} else {
			setMessage("注销会员资格失败..请重试");
			return "message";
		}
	}
	
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return "success";
	}
	
	public String getInfo() {
		Map session = ActionContext.getContext().getSession();
		setMember(memberService.getMember((Integer) session.get("USER_ID")));
		return "success";
	}
	
	public String changeCredit() {
		Map session = ActionContext.getContext().getSession();
		memberService.changeCredit((Integer) session.get("USER_ID"), credit);
		return "success";
	}
	
	public String getPurchaseRecord(){
		Map session = ActionContext.getContext().getSession();
		setSales(memberService.getPurchaseRecord((Integer) session.get("USER_ID")));
		return "success";
	}

	public String getRechargeRecord(){
		Map session = ActionContext.getContext().getSession();
		setRechargeRecords(memberService.getRechargeRecord((Integer) session.get("USER_ID")));
		return "success";
	}
	
	public String saveInfo(){
		Map session = ActionContext.getContext().getSession();
		memberService.saveInfo((Integer) session.get("USER_ID"),member);
		return "success";
	}
	
	public String changePassword(){
		if(!newPassword.equals(rePassword)){
			setMessage("新密码与重复密码要一致");
			return "message";
		} else {
			Map session = ActionContext.getContext().getSession();
			String result = memberService.changePassword((Integer) session.get("USER_ID"),password,newPassword);
			if (result.equals("wrong")) {
				setMessage("旧密码错误");
				return "message";
			} else {
				return "success";
			}
		}
	}
	
	public Converter getSeat(){  
        return new Converter() {  
            public Object convert(String id) throws Exception {  
            	String result = "";
                Seat seat = memberService.getSeat(Integer.parseInt(id));  
                result = seat.getRowNum()+"排"+seat.getColumnNum()+"座";
                return result;  
            }  
        };  
    }  

}
