package com.cineplex.employee.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.IntToDoubleFunction;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IManagerService;
import com.cineplex.pojo.IFilmDao;
import com.cineplex.pojo.IMemberDao;
import com.cineplex.pojo.IPlanDao;
import com.cineplex.pojo.IPlanItemDao;
import com.cineplex.pojo.IQuestionDao;
import com.cineplex.pojo.ISalesDao;
import com.cineplex.pojo.ISeatDao;
import com.cineplex.pojo.impl.Answer;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;
import com.cineplex.pojo.impl.Sales;

public class ManagerService implements IManagerService {

	@Autowired
	private IPlanDao planDao;
	@Autowired
	private IPlanItemDao planItemDao;
	@Autowired
	private IMemberDao memberDao;
	@Autowired
	private IFilmDao filmDao;
	@Autowired
	private ISalesDao salesDao;
	@Autowired
	private ISeatDao seatDao;
	@Autowired
	private IQuestionDao questionDao;
	
	private String startTime;
	private String endTime;
	

	private void setStartAndEnd(SimpleDateFormat sdf, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)-month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		this.startTime = sdf.format(calendar.getTime());
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH)+1);
		this.endTime = sdf.format(calendar.getTime());
	}
	
	@Override
	public List<Plan> getUnapprovedPlans() {
		return planDao.findByState(0);
	}

	@Override
	public List<PlanItem> getPlanItems(int pid) {
		List<PlanItem> list = new ArrayList<PlanItem>();
		list.addAll(planDao.findById(pid).getPlanItems());
		return list;
	}

	@Override
	public boolean approve(int pid, int mid) {
		try {
			Plan plan = planDao.findById(pid);
			String date = plan.getDate();
			int rid = plan.getRoomId();
			List<Plan> otherPlans = planDao.findByDateAndRoomId(date, rid);
			for (Plan p : otherPlans) {
				p.setState(-1);
				planDao.merge(p);
			}
			plan.setState(1);
			plan.setManagerId(mid);
			planDao.merge(plan);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean unapprove(int pid, int mid) {
		try {
			Plan plan = planDao.findById(pid);
			plan.setState(2);
			plan.setManagerId(mid);
			planDao.merge(plan);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Member> getAllMembers() {
		return memberDao.findAll();
	}

	@Override
	public HashMap<String, Integer> getAddressCount() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		List<Object[]> list = memberDao.getAddressCount();
		for (Object[] object : list) {
			result.put(String.valueOf(object[0]), Integer.valueOf(object[1].toString()));
		}
		return result;
	}

	@Override
	public HashMap<String, Integer> getCardState() {
		String[] states = {"未激活","正常","暂停","失效","取消"};
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		List<Object[]> list = memberDao.getCardState();
		for (Object[] object : list) {
			result.put(states[Integer.valueOf(object[0].toString())], Integer.valueOf(object[1].toString()));
		}
		return result;
	}

	@Override
	public HashMap<String, Integer> getGender() {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		List<Object[]> list = memberDao.getGender();
		for (Object[] object : list) {
			result.put(String.valueOf(object[0]), Integer.valueOf(object[1].toString()));
		}
		return result;
	}

	@Override
	public HashMap<String, Double> getFilmSales(int month) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setStartAndEnd(sdf,month);
		List<Plan> list= planDao.getMonthSales(startTime, endTime);
		HashMap<String, Double> map = new HashMap<String, Double>();
		for (Plan plan : list) {
			for (PlanItem item : plan.getPlanItems()) {
				String film = item.getFilm().getName();
				if (!map.containsKey(film)) {
					map.put(film, 0.0);
				}
				double sum = map.get(film);
				for (Sales sale : item.getSales()) {
					sum += sale.getPayment();
				}
				map.put(film, sum);
			}
		}
		return map;
	}

	@Override
	public HashMap<String, Integer> getPayType(int month) {
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		setStartAndEnd(sdf, month);
		List<Object[]> list = salesDao.getPayType(startTime, endTime);
		for (Object[] object : list) {
			String t = Integer.valueOf(object[0].toString()) == 0 ? "卡购票" : "现金购票";
			result.put(t, Integer.valueOf(object[1].toString()));
		}
		return result;
	}

	@Override
	public HashMap<Integer, Integer> getPersonCount(int month) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setStartAndEnd(sdf,month);
		List<Plan> list= planDao.getMonthSales(startTime, endTime);
		int total = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Plan plan : list) {
			int day = Integer.valueOf(plan.getDate().substring(8));
			if (!map.containsKey(day)) {
				map.put(day, 0);
			}
			for (PlanItem item : plan.getPlanItems()) {
				int sum = map.get(day);
				for (Sales sale : item.getSales()) {
					sum += sale.getSeatCount();
					total += sale.getSeatCount();
				}
				map.put(day, sum);
			}
		}
		map.put(0, total);
		return map;
	}

	@Override
	public HashMap<Integer, Double> getRoom(int month) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setStartAndEnd(sdf,month);
		List<Object[]> roomSeatCount = seatDao.getSeatCount();
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> tmap = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> smap = new HashMap<Integer, Integer>();
		for (Object[] object : roomSeatCount) {
			int id = Integer.valueOf(object[0].toString());
			tmap.put(id, Integer.valueOf(object[1].toString()));
			smap.put(id, 0);
			count.put(id, 0);
		}
		List<Plan> list= planDao.getMonthSales(startTime, endTime);
		for (Plan plan : list) {
			int rid = plan.getRoomId();
			for (PlanItem item : plan.getPlanItems()) {
				count.put(rid, count.get(rid)+1);
				int sum = smap.get(rid);
				for (Sales sale : item.getSales()) {
					sum += sale.getSeatCount();
				}
				smap.put(rid, sum);
			}
		}
		HashMap<Integer, Double> map = new HashMap<Integer, Double>();
		for (int i = 1; i <= tmap.size(); i++) {
			double percent;
			if (count.get(i) == 0) {
				percent = 0.0;
			} else {
				percent = smap.get(i)*100.0/count.get(i)/tmap.get(i);
			}
			map.put(i, percent);
		}
		return map;
	}

	@Override
	public HashMap<String, Double> getFilm(int month) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setStartAndEnd(sdf,month);
		List<Object[]> roomSeatCount = seatDao.getSeatCount();
		HashMap<Integer, Integer> tmap = new HashMap<Integer, Integer>();
		for (Object[] object : roomSeatCount) {
			tmap.put(Integer.valueOf(object[0].toString()), Integer.valueOf(object[1].toString()));
		}
		HashMap<String, Integer> filmCount = new HashMap<String, Integer>();
		HashMap<String, Integer> filmSaleCount = new HashMap<String, Integer>();
		List<Plan> list= planDao.getMonthSales(startTime, endTime);
		for (Plan plan : list) {
			for (PlanItem item : plan.getPlanItems()) {
				String name = item.getFilm().getName();
				int rid = item.getPlan().getRoomId();
				if (!filmCount.containsKey(name)) {
					filmCount.put(name, 0);
					filmSaleCount.put(name, 0);
				}
				filmCount.put(name, filmCount.get(name)+tmap.get(rid));
				int sum = filmSaleCount.get(name);
				for (Sales sale : item.getSales()) {
					sum += sale.getSeatCount();
				}
				filmSaleCount.put(name, sum);
			}
		}
		HashMap<String, Double> map = new HashMap<String, Double>();
		for (String name : filmCount.keySet()) {
			map.put(name, filmSaleCount.get(name)*100.0/filmCount.get(name));
		}
		return map;
	}

	@Override
	public HashMap<String, String> getActivity(int month) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		setStartAndEnd(sdf,month);
		List<Plan> list= planDao.getMonthSales(startTime, endTime);
		HashMap<String, String> map = new HashMap<String, String>();
		for (Plan plan : list) {
			for (PlanItem item : plan.getPlanItems()) {
				String name = item.getFilm().getName();
				String items = "";
				if (map.containsKey(name)) {
					items = map.get(name)+"_"+item.getId();
				} else {
					items = item.getId().toString();
				}
				map.put(name, items);
			}
		}
		return map;
	}

	@Override
	public List<Question> getQuestion(String items) {
		String ids = "(" + items.replace('_', ',') +")";
		List<Object[]> objects= questionDao.getQuestions(ids);
		HashMap<String, Question> ques = new HashMap<String, Question>();
		for (Object[] obj : objects) {
			String con = String.valueOf(obj[0]);
			Question question = ques.containsKey(con) ? ques.get(con) : new Question();
			question.setContent(con);
			Answer answer = new Answer();
			answer.setAnswer(String.valueOf(obj[1]));
			answer.setCount(Integer.valueOf(obj[2].toString()));
			Set<Answer> answers = question.getAnswers() == null ? new HashSet<Answer>() : question.getAnswers();
			answers.add(answer);
			question.setAnswers(answers);
			ques.put(con, question);
		}
		List<Question> results = new ArrayList<Question>();
		for (Question que : ques.values()) {
			results.add(que);
		}
		return results;
	}
}
