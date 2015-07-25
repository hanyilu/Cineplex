package com.cineplex.member.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.member.service.IMemberService;
import com.cineplex.pojo.impl.Member;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	private Member member;
	private String repassword;
	private String message;
	@Autowired
    private IMemberService memberService;
	
	private static final String[] ADDRESS = {"鼓楼区", "玄武区","秦淮区" ,"建邺区", "白下区", "下关区", "雨花台区", "浦口区", "栖霞区", "江宁区", "六合区", "其他地区"};
	
    public Member getMember() {  
        return member;  
    }  
  
    public void setMember(Member member) {  
        this.member = member;  
    } 
  
	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public String register(){
		member.setAddress(ADDRESS[Integer.valueOf(member.getAddress())]);
		String memberId = memberService.register(member);
        if (!memberId.equals("fail")) {
        	Map session = ActionContext.getContext().getSession();
            session.put("USER_ID", Integer.valueOf(memberId));
            session.put("USER_TYPE", "member");
        	setMessage("新会员ID为："+memberId);
        } else {
        	setMessage("注册失败！");
        }
		return "message";
	}
}
