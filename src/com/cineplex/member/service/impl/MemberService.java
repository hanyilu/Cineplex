package com.cineplex.member.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

import javax.xml.soap.SAAJResult;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.member.service.IMemberService;
import com.cineplex.pojo.IActivityDao;
import com.cineplex.pojo.IAnswerDao;
import com.cineplex.pojo.IMemberDao;
import com.cineplex.pojo.IPlanDao;
import com.cineplex.pojo.IPlanItemDao;
import com.cineplex.pojo.IRechargeRecordDao;
import com.cineplex.pojo.ISalesDao;
import com.cineplex.pojo.ISeatDao;
import com.cineplex.pojo.impl.Activity;
import com.cineplex.pojo.impl.Answer;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;
import com.cineplex.pojo.impl.RechargeRecord;
import com.cineplex.pojo.impl.Sales;
import com.cineplex.pojo.impl.Seat;

public class MemberService implements IMemberService {
	
	private final static long ONE_YEAR = 31536000000L;
	
	@Autowired
	private IMemberDao memberDao;
	@Autowired
	private IPlanDao planDao;
	@Autowired
	private IPlanItemDao planItemDao;
	@Autowired
	private ISeatDao seatDao;
	@Autowired
	private ISalesDao salesDao;
	@Autowired
	private IAnswerDao answerDao;
	@Autowired
	private IActivityDao activityDao;
	@Autowired
	private IRechargeRecordDao rechargeRecordDao;

	@Override
	public boolean hasMatch(Member member) {
		Member m = memberDao.findById(member.getId());
		if (m != null && m.getPassword().equals(member.getPassword())
				&& m.getState() < 3) {
			return true;
		}
		return false;
	}
	
	@Override
	public String register(Member member) {
		try {
			int id = memberDao.save(member);
			if (id < 0) {
				throw new Exception();
			}
			
			return String.valueOf(id);
		} catch (Exception e) {
			return "fail";
		}
	}
	
	public String getBankAccount(int memberId){
		Member member = memberDao.findById(memberId);
		return member.getBankAccount();
	}

	
	@Override
	public boolean recharge(int memberId, int level, double pay) {
		try {
			Member m = memberDao.findById(memberId);
			m.setLevel(level);
			m.setState(1);
			m.setBalance(m.getBalance() + pay);
			long start = new Date().getTime();
			long pause = start + ONE_YEAR;
			long stop  = pause + ONE_YEAR;
			m.setStartTime(new Timestamp(start));
			m.setPauseTime(new Timestamp(pause));
			m.setStopTime(new Timestamp(stop));
			RechargeRecord record = new RechargeRecord();
			record.setMember(m);
			record.setAmount(pay);
			record.setTime(new Timestamp(start));
			memberDao.merge(m);
			rechargeRecordDao.save(record);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean cancel(int memberId) {
		try {
			Member member = memberDao.findById(memberId);
			member.setState(4);
			memberDao.merge(member);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<PlanItem> getPlanItems(int day) {
		Date today=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<PlanItem> items = new ArrayList<PlanItem>();
		if (day == 0) {
			SimpleDateFormat time = new SimpleDateFormat("HH:mm");
			items = planItemDao.findApprovedItems(sdf.format(today), 1, time.format(today));
		} else {
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(today);
			calendar.add(Calendar.DAY_OF_YEAR, +day);
			Date tomorrow =calendar.getTime();
			items = planItemDao.findApprovedItems(sdf.format(tomorrow), 1, "00:00");
		}
		return items;
	}
	
	@Override
	public PlanItem getPlanItem(int pid) {
		return planItemDao.findById(pid);
	}

	@Override
	public List<ArrayList<Seat>> getSeatMap(Integer roomId, String soldSeatsId) {
		ArrayList<Integer> sid = new ArrayList<Integer>();
		if (soldSeatsId.length() > 0) {
			String[] ids = soldSeatsId.split(",");
			for (String id : ids) {
				sid.add(Integer.valueOf(id));
			}
		}
		List<ArrayList<Seat>> seatMap = new ArrayList<ArrayList<Seat>>();
		int row = 1;
		ArrayList<Seat> seats = (ArrayList<Seat>)seatDao.findByRoomAndRow(roomId, row);
		while (!seats.isEmpty()) {
			for (Seat seat : seats) {
				if (sid.contains(seat.getId())) {
					seat.setId(0);
				}
			}
			seatMap.add(seats);
			seats = (ArrayList<Seat>)seatDao.findByRoomAndRow(roomId, ++row);
		}
		return seatMap;
	}

	@Override
	public Member getMember(Integer mid) {
		return memberDao.findById(mid);
	}

	@Override
	public List<Seat> confirmSeat(List<Integer> selectId) {
		List<Seat> seats = new ArrayList<Seat>();
		for (int id : selectId) {
			seats.add(seatDao.findById(id));
		}
		return seats;
	}

	@Override
	public boolean purchase(Member member, double payment, PlanItem item, String seatString, int count) {
		try {
			double balance = member.getBalance() - payment;
			if (balance < 0) {
				return false;
			}
			member.setBalance(balance);
			member.setCredit(member.getCredit()+(int)Math.floor(payment));
			item.setSoldSeatsId(item.getSoldSeatsId()+seatString);
			Sales sale = new Sales();
			sale.setMember(member);
			sale.setPlanItem(item);
			sale.setPayment(payment);
			sale.setSeatsIds(seatString);
			sale.setSeatCount(count);
			sale.setTime(new Timestamp(new Date().getTime()));
			memberDao.merge(member);
			planItemDao.merge(item);
			salesDao.save(sale);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public List<PlanItem> getActivityItemList(int memberId) {
		Member member = getMember(memberId);
		List<PlanItem> items = new ArrayList<PlanItem>();
		Set<Activity> activities = member.getActivities();
		List<Integer> joinedItem = new ArrayList<Integer>();
		for (Activity act : activities) {
			joinedItem.add(act.getAnswer().getQuestion().getPlanItem().getId());
		}
		Set<Sales> sales= member.getSales();
		for (Sales sale : sales) {
			PlanItem item = sale.getPlanItem();
			if (!joinedItem.contains(item.getId()) && !items.contains(item) 
					&& item.getFilm().getOfflineTime().after(new Date())
					&& item.getQuestions().size() > 0) {
				items.add(item);
			}
		}
		return items;
	}

	@Override
	public boolean submitAnswers(List<Integer> answers, int memberId) {
		for (int aid : answers) {
			Answer answer = answerDao.findById(aid);
			answer.setCount(answer.getCount() + 1);
			Activity act = new Activity();
			act.setAnswer(answer);
			act.setMember(getMember(memberId));
			answerDao.merge(answer);
			activityDao.save(act);
		}
		return true;
	}

	@Override
	public boolean changeCredit(int memberId, int credit) {
		Member member = memberDao.findById(memberId);
		member.setCredit(member.getCredit()-credit);
		member.setBalance(member.getBalance()+(credit/100.0));
		memberDao.merge(member);
		return true;
	}

	@Override
	public List<Sales> getPurchaseRecord(int memberId) {
		Member member = getMember(memberId);
		List<Sales> list = new ArrayList<Sales>();
		list.addAll(member.getSales());
		return list;
	}

	@Override
	public List<RechargeRecord> getRechargeRecord(int memberId) {
		Member member = getMember(memberId);
		List<RechargeRecord> list = new ArrayList<RechargeRecord>();
		list.addAll(member.getRechargeRecords());
		return list;
	}

	@Override
	public Seat getSeat(int sid) {
		return seatDao.findById(sid);
	}

	@Override
	public boolean saveInfo(int memberId, Member member) {
		Member m = memberDao.findById(memberId);
		m.setName(member.getName());
		m.setGender(member.getGender());
		m.setBirthday(member.getBirthday());
		m.setAddress(member.getAddress());
		m.setBankAccount(member.getBankAccount());
		memberDao.merge(m);
		return true;
	}

	@Override
	public String changePassword(int memberId, String password, String newPassword) {
		Member member = memberDao.findById(memberId);
		if (!member.getPassword().equals(password)) {
			return "wrong";
		} else {
			member.setPassword(newPassword);
			memberDao.merge(member);
		}
		return "success";
	}

	
}
