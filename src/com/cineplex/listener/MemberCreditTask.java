package com.cineplex.listener;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.pojo.IFilmDao;
import com.cineplex.pojo.IMemberDao;
import com.cineplex.pojo.impl.Activity;
import com.cineplex.pojo.impl.Answer;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;

public class MemberCreditTask extends TimerTask {

	IMemberDao memberDao;
	IFilmDao filmDao;
	
	public MemberCreditTask(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.memberDao = (IMemberDao) context.getBean("memberDao");
		this.filmDao = (IFilmDao) context.getBean("filmDao");
	}
	
	public void run() {
		Timestamp time = new Timestamp(new Date().getTime());
		List<Film> films = filmDao.findOfflineFilm(time);
		for (Film film : films) {
			for (PlanItem item : film.getPlanItems()) {
				for (Question question : item.getQuestions()) {
					Answer mostAnswer = new Answer();
					mostAnswer.setCount(0);
					for (Answer answer : question.getAnswers()) {
						if (answer.getCount() >= mostAnswer.getCount()) {
							mostAnswer = answer;
						}
					}
					for (Activity activity : mostAnswer.getActivities()) {
						Member member = activity.getMember();
						member.setCredit(member.getCredit()+50);
						memberDao.merge(member);
					}
				}
			}
			film.setState(1);
			filmDao.merge(film);
		}
	}  
}
