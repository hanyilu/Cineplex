package com.cineplex.employee.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IWaiterService;
import com.cineplex.pojo.IEmployeeDao;
import com.cineplex.pojo.IFilmDao;
import com.cineplex.pojo.IMemberDao;
import com.cineplex.pojo.IPlanDao;
import com.cineplex.pojo.IPlanItemDao;
import com.cineplex.pojo.ISalesDao;
import com.cineplex.pojo.impl.Employee;
import com.cineplex.pojo.impl.Film;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;
import com.cineplex.pojo.impl.Sales;

public class WaiterService implements IWaiterService {

	@Autowired
	private IFilmDao filmDao;
	@Autowired
	private IPlanDao planDao;
	@Autowired
	private IPlanItemDao planItemDao;
	@Autowired
	private IMemberDao memberDao;
	@Autowired
	private ISalesDao salesDao;
	@Autowired
	private IEmployeeDao employeeDao;
	
	public boolean addFilm(Film film) {
		try {
			filmDao.save(film);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<Film> getFilms() {
		return filmDao.findOnlineFilms();
	}
	
	public Plan createPlan(Plan plan) {
		return planDao.save(plan);
	}
	
	public void savePlans(List<PlanItem> planItems) {
		for (PlanItem item : planItems) {
			planItemDao.save(item);
		}
	}

	@Override
	public List<Plan> getEditPlans(int uid) {
		return planDao.findByWaiterIdAndState(uid,2);
	}

	@Override
	public List<PlanItem> getPlanItems(int pid) {
		return planItemDao.findByPlanId(pid);
	}

	@Override
	public Plan getPlan(int pid) {
		return planDao.findById(pid);
	}

	@Override
	public void mergePlan(Plan plan) {
		planDao.merge(plan);
	}

	@Override
	public void deleteOldPlanItems(int pid) {
		Set<PlanItem> items = getPlan(pid).getPlanItems();
		for (PlanItem planItem : items) {
			planItemDao.delete(planItem);
		}
	}

	@Override
	public List<Film> getOnlineFilms() {
		return filmDao.findOnlineFilms();
	}

	@Override
	public Film getFilm(int fid) {
		return filmDao.findById(fid);
	}

	@Override
	public boolean addActivity(Set<Question> questionSet, List<Integer> selectItemId) {
		try {
			for (Integer id : selectItemId) {
				PlanItem item = planItemDao.findById(id);
				for (Question que : questionSet) {
					que.setPlanItem(item);
				}
				item.setQuestions(questionSet);
				planItemDao.merge(item);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<PlanItem> getTodayPlanItems() {
		Date today=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<PlanItem> items = new ArrayList<PlanItem>();
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		items = planItemDao.findApprovedItems(sdf.format(today), 1, time.format(today));
		return items;
	}

	@Override
	public String sales(int mid, int pid, String seats, int wid, int crash) {
		Sales sale = new Sales();
		Member member = memberDao.findById(mid);
		PlanItem item = planItemDao.findById(pid);
		int count = seats.split(",").length;
		double pay = 0;
		if (crash == 1 || mid == 1) {
			pay = count*item.getPrice();
		} else {
			HashMap<Integer, Double> discountMap = new HashMap<Integer, Double>();
			discountMap.put(0, 1.0);
			discountMap.put(1, 0.9);
			discountMap.put(2, 0.75);
			discountMap.put(3, 0.6);
			discountMap.put(4, 0.5);
			pay = count*item.getPrice()*discountMap.get(member.getLevel());
		}
		member.setBalance(member.getBalance() - pay);
		member.setCredit(member.getCredit()+(int)Math.floor(pay));
		item.setSoldSeatsId(item.getSoldSeatsId()+seats);
		sale.setWaiter(employeeDao.findById(wid));
		sale.setMember(member);
		sale.setPlanItem(item);
		sale.setPayment(pay);
		sale.setPayType(crash);
		sale.setSeatsIds(seats);
		sale.setSeatCount(count);
		sale.setTime(new Timestamp(new Date().getTime()));
		if(mid != 1) {
			memberDao.merge(member);
		}
		planItemDao.merge(item);
		salesDao.save(sale);
		return "success";
	}
}
