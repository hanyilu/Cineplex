package com.cineplex.employee.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IWaiterService;
import com.cineplex.pojo.impl.Answer;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;
import com.opensymphony.xwork2.ActionSupport;

public class AddActivityAction extends ActionSupport {

	private List<Film> films;
	private int fid;
	private Film film;
	private List<Question> questions;
	private List<Answer> answers0;
	private List<Answer> answers1;
	private List<Answer> answers2;
	private List<Integer> selectItemId;
	private String message;
	
	@Autowired
	private IWaiterService waiterService;
	
	public List<Film> getFilms() {
		return films;
	}
	public void setFilms(List<Film> films) {
		this.films = films;
	}

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers0() {
		return answers0;
	}
	public void setAnswers0(List<Answer> answers0) {
		this.answers0 = answers0;
	}
	public List<Answer> getAnswers1() {
		return answers1;
	}
	public void setAnswers1(List<Answer> answers1) {
		this.answers1 = answers1;
	}
	public List<Answer> getAnswers2() {
		return answers2;
	}
	public void setAnswers2(List<Answer> answers2) {
		this.answers2 = answers2;
	}
	public List<Integer> getSelectItemId() {
		return selectItemId;
	}
	public void setSelectItemId(List<Integer> selectItemId) {
		this.selectItemId = selectItemId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getOnlineFilms() {
		List<Film> filmList = waiterService.getOnlineFilms();
		if (filmList.size() > 0) {
			setFilms(filmList);
			return "success";
		} else {
			setMessage("没有正在上映的电影");
			return "message";
		}
	}
	
	public String getFilmInfo() {
		Film film = waiterService.getFilm(fid);
		Set<PlanItem> items = film.getPlanItems();
		if (items.size() > 0) {
			setFilm(film);
			return "success";
		} else {
			setMessage("没有匹配的放映计划");
			return "message";
		}
	}
	
	public String addActivity() {
		ArrayList<List<Answer>> answerList = new ArrayList<List<Answer>>();
		answerList.add(answers0);
		answerList.add(answers1);
		answerList.add(answers2);
		Set<Question> questionSet = new HashSet<Question>();
		for (int i = 0; i < 3; i++) {
			Question question = questions.get(i);
			if (question.getContent().length() > 0) {
				Set<Answer> answers = new HashSet<Answer>();
				for (Answer answer : answerList.get(i)) {
					if (answer.getAnswer().length() > 0) {
						answer.setQuestion(question);
						answers.add(answer);
					}
				}
				question.setAnswers(answers);
				questionSet.add(question);
			}
		}
		if (waiterService.addActivity(questionSet, selectItemId)) {
			setMessage("发布活动成功");
		} else {
			setMessage("发布失败");
		}
		return "message";
	}
}
