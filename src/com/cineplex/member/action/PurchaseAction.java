package com.cineplex.member.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bank.service.IBankService;

import com.cineplex.member.service.IMemberService;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Seat;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseAction extends ActionSupport{
	
	private int day;
	private int pid;
	private List<PlanItem> planItems;
	private PlanItem item;
	private List<ArrayList<Seat>> seatMap;
	private List<Integer> selectId;
	private List<Seat> selectSeats;
	private Member member;
	private String password;
	private HashMap<Integer, Double> discountMap = new HashMap<Integer, Double>();
	private String message;
	
	@Autowired
	private IMemberService memberService;
	@Autowired
    private IBankService bankService;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<PlanItem> getPlanItems() {
		return planItems;
	}

	public void setPlanItems(List<PlanItem> planItems) {
		this.planItems = planItems;
	}

	public PlanItem getItem() {
		return item;
	}

	public void setItem(PlanItem item) {
		this.item = item;
	}

	public List<ArrayList<Seat>> getSeatMap() {
		return seatMap;
	}

	public void setSeatMap(List<ArrayList<Seat>> seatMap) {
		this.seatMap = seatMap;
	}

	public List<Integer> getSelectId() {
		return selectId;
	}

	public void setSelectId(List<Integer> selectId) {
		this.selectId = selectId;
	}

	public List<Seat> getSelectSeats() {
		return selectSeats;
	}

	public void setSelectSeats(List<Seat> selectSeats) {
		this.selectSeats = selectSeats;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public HashMap<Integer, Double> getDiscountMap() {
		discountMap.put(0, 1.0);
		discountMap.put(1, 0.9);
		discountMap.put(2, 0.75);
		discountMap.put(3, 0.6);
		discountMap.put(4, 0.5);
		return discountMap;
	}
	public void setDiscountMap(HashMap<Integer, Double> discountMap) {
		this.discountMap = discountMap;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFilms() {
		List<PlanItem> items = memberService.getPlanItems(day);
		setPlanItems(items);
		return "success";
	}
	 
	public String getFilmInfo() {
		PlanItem item = memberService.getPlanItem(pid);
		if (!item.equals(null)) {
			setItem(item);
			setSeatMap(memberService.getSeatMap(item.getPlan().getRoomId(),item.getSoldSeatsId()));
			return "success";
		} else {
			setMessage("请求失败 请重试");
			return "message";
		}
	}
	
	public String purchase(){
		Map session = ActionContext.getContext().getSession();
		setMember(memberService.getMember((Integer)session.get("USER_ID")));
		List<Seat> seats = memberService.confirmSeat(selectId);
		session.put("SEATS", seats);
		setSelectSeats(seats);
		PlanItem item = memberService.getPlanItem(pid);
		session.put("ITEM", item);
		setItem(item);
		return "success";
	}
	
	public String pay(){
		Map session = ActionContext.getContext().getSession();
		Member m = memberService.getMember((Integer)session.get("USER_ID"));
		if (!password.equals(m.getPassword())) {
			setMessage("密码错误");
		} else {
			List<Seat> seats = (List<Seat>) session.get("SEATS");
			String seatString = "";
			for (Seat seat : seats) {
				seatString += seat.getId()+",";
			}
			PlanItem item = (PlanItem) session.get("ITEM");
			double payment = getDiscountMap().get(m.getLevel())*seats.size()*item.getPrice();
			if (memberService.purchase(m, payment, item, seatString, seats.size())) {
				setMessage("购买成功");
			} else {
				setMessage("余额不足");
			}
		}
		return "message";
	}
}
