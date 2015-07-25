package com.cineplex.employee.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IManagerService;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.Question;
import com.opensymphony.xwork2.ActionSupport;

public class ChartsAction extends ActionSupport{
	
	private int month;
	private int[] ageCount;
	private double[] agePercent;
	private String[] ageCate;
	private HashMap<String, Integer> gender;
	private HashMap<String, Integer> address;
	private HashMap<String, Integer> cardState;
	private HashMap<String, Double> filmSales;
	private HashMap<String, Integer> payType;
	private HashMap<Integer, Integer> personDayCount;
	private int personMonthCount;
	private HashMap<Integer, Double> room;
	private HashMap<String, Double> film;
	private HashMap<String, String> activity;
	private String items = "0";
	private List<Question> question;
	
	private static final int[] agePart = {20, 30, 40, 50, 200};
	@Autowired
    private IManagerService managerService;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int[] getAgeCount() {
		return ageCount;
	}

	public void setAgeCount(int[] ageCount) {
		this.ageCount = ageCount;
	}

	public double[] getAgePercent() {
		return agePercent;
	}

	public void setAgePercent(double[] agePercent) {
		this.agePercent = agePercent;
	}

	public String[] getAgeCate() {
		return ageCate;
	}

	public void setAgeCate(String[] ageCate) {
		this.ageCate = ageCate;
	}
	
	public HashMap<String, Integer> getGender() {
		return gender;
	}

	public void setGender(HashMap<String, Integer> gender) {
		this.gender = gender;
	}

	public HashMap<String, Integer> getAddress() {
		return address;
	}

	public void setAddress(HashMap<String, Integer> address) {
		this.address = address;
	}

	public HashMap<String, Integer> getCardState() {
		return cardState;
	}

	public void setCardState(HashMap<String, Integer> cardState) {
		this.cardState = cardState;
	}

	public HashMap<String, Double> getFilmSales() {
		return filmSales;
	}

	public void setFilmSales(HashMap<String, Double> filmSales) {
		this.filmSales = filmSales;
	}

	public HashMap<String, Integer> getPayType() {
		return payType;
	}

	public void setPayType(HashMap<String, Integer> payType) {
		this.payType = payType;
	}

	public HashMap<Integer, Integer> getPersonDayCount() {
		return personDayCount;
	}

	public void setPersonDayCount(HashMap<Integer, Integer> personDayCount) {
		this.personDayCount = personDayCount;
	}

	public int getPersonMonthCount() {
		return personMonthCount;
	}

	public void setPersonMonthCount(int personMonthCount) {
		this.personMonthCount = personMonthCount;
	}

	public HashMap<Integer, Double> getRoom() {
		return room;
	}

	public void setRoom(HashMap<Integer, Double> room) {
		this.room = room;
	}

	public HashMap<String, Double> getFilm() {
		return film;
	}

	public void setFilm(HashMap<String, Double> film) {
		this.film = film;
	}

	public HashMap<String, String> getActivity() {
		return activity;
	}

	public void setActivity(HashMap<String, String> activity) {
		this.activity = activity;
	}

	@JSON(serialize=false)
	public String getItems() {
		return items;
	}

	public void setItems(String items) {
		this.items = items;
	}

	public List<Question> getQuestion() {
		return question;
	}

	public void setQuestion(List<Question> question) {
		this.question = question;
	}

	public String toCharts() {
		return SUCCESS;
	}

	public String getMemberAgeChart() {
		int[] ages = {0,0,0,0,0};
		int year = Calendar.getInstance().get(Calendar.YEAR);
		List<Member> members = managerService.getAllMembers();
		for(Member member : members) {
			String birthYear = member.getBirthday().substring(0, 4);
			int age = year - Integer.valueOf(birthYear);
			for(int i = 0; i < agePart.length; i++) {
				if(age <= agePart[i]){
					ages[i] +=1;
					break;
				}
			}
		}
		setAgeCount(ages);
		String[] cates = {"20岁以下", "20-30岁", "30-40岁", "40-50岁", "50岁以上"};
		setAgeCate(cates);
		double[] percents = {0.0,0.0,0.0,0.0,0.0};
		double all = members.size()*1.0;
		for (int i = 0; i < ages.length; i++) {
			percents[i] = ages[i] / all * 100.0;
		}
		setAgePercent(percents);
		return SUCCESS;
	}
	
	public String getMemberGenderChart() {
		setGender(managerService.getGender());
		return SUCCESS;
	}
	
	public String getMemberAddressChart() {
		setAddress(managerService.getAddressCount());
		return SUCCESS;
	}
	
	public String getMemberCardStateChart() {
		setCardState(managerService.getCardState());
		return SUCCESS;
	}
	
	public String getFilmSalesChart() {
		setFilmSales(managerService.getFilmSales(month));
		return SUCCESS;
	}
	
	public String getPayTypeChart() {
		setPayType(managerService.getPayType(month));
		return SUCCESS;
	}
	
	public String getPersonCountChart() {
		HashMap<Integer, Integer> map = managerService.getPersonCount(month);
		setPersonMonthCount(map.get(0));
		map.remove(0);
		setPersonDayCount(map);
		return SUCCESS;
	}
	
	public String getRoomChart() {
		setRoom(managerService.getRoom(month));
		return SUCCESS;
	}
	
	public String getFilmChart() {
		setFilm(managerService.getFilm(month));
		return SUCCESS;
	}
	
	public String getActivityChart() {
		setActivity(managerService.getActivity(month));
		return SUCCESS;
	}
	
	public String getQuestionChart() {
		setQuestion(managerService.getQuestion(items));
		return SUCCESS;
	}
}
