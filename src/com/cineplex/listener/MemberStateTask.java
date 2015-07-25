package com.cineplex.listener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.pojo.IMemberDao;
import com.cineplex.pojo.impl.Member;

public class MemberStateTask extends TimerTask {

	IMemberDao memberDao;
	
	public MemberStateTask(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.memberDao = (IMemberDao) context.getBean("memberDao");
	}
	
	public void run() {
		Timestamp time = new Timestamp(new Date().getTime());
		List<Member> members = memberDao.findOverTimeMember(time);
		for (Member member : members) {
			member.setState(member.getState()+1);
			System.out.println(member.getId()+":"+member.getState());
			memberDao.merge(member);
		}
	}  
}
