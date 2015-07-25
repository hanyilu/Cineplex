package com.cineplex.employee.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.member.service.IMemberService;
import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.RechargeRecord;
import com.cineplex.pojo.impl.Sales;
import com.cineplex.pojo.impl.Seat;
import com.opensymphony.xwork2.ActionSupport;

public class AjaxInfoAction extends ActionSupport{
	
	private int mid;
	private int pid;
	private String memberInfo;
	private double itemPrice;
	private List<String> sales;
	private List<String> recharges;
	private List<String> seats;
	
	@Autowired
    private IMemberService memberService;

	@JSON(serialize=false)
    public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}
	
	@JSON(serialize=false)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(String memberInfo) {
		this.memberInfo = memberInfo;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public List<String> getSales() {
		return sales;
	}

	public void setSales(List<String> sales) {
		this.sales = sales;
	}

	public List<String> getRecharges() {
		return recharges;
	}

	public void setRecharges(List<String> recharges) {
		this.recharges = recharges;
	}
	
	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	public String loadMemberInfo(){
		Member member = memberService.getMember(mid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = sdf.format(member.getStartTime());
		setMemberInfo(member.getId()+"_"+member.getName()+"_"+member.getGender()+"_"+member.getBirthday()+"_"+member.getAddress()+"_"+member.getLevel()+"_"+member.getCredit()+"_"+member.getBalance()+"_"+startTime+"_"+member.getState());
		return SUCCESS;
    }  
	
	public String loadMemberSalesInfo(){
		List<String> result = new ArrayList<String>();
		List<Sales> record= memberService.getPurchaseRecord(mid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (Sales sale : record) {
			String str = "";
			PlanItem item = sale.getPlanItem();
			String time = sdf.format(sale.getTime());
			str += item.getPlan().getDate()+"_"+item.getFilm().getName()+"_"+item.getDuration()+"_"+item.getPlan().getRoomId()+"_"+sale.getSeatCount()+"_"+sale.getPayment()+"_"+time;
			result.add(str);
		}
		setSales(result);
		return SUCCESS;
    } 
	
	public String loadMemberRechargesInfo(){
		List<String> result = new ArrayList<String>();
		List<RechargeRecord> records = memberService.getRechargeRecord(mid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (RechargeRecord record : records) {
			String str = "";
			String time = sdf.format(record.getTime());
			str += time+"_"+record.getAmount();
			result.add(str);
		}
		setRecharges(result);
		return SUCCESS;
	}
	
	public String loadSeatMap(){
		PlanItem item = memberService.getPlanItem(pid);
		setItemPrice(item.getPrice());
		List<String> seatlist = new ArrayList<String>();
		List<ArrayList<Seat>> n = memberService.getSeatMap(item.getPlan().getRoomId(), item.getSoldSeatsId());
		for (List<Seat> row : n) {
			String rowString = "";
			for (Seat seat : row) {
				String seatString = seat.getId()+"_";
				rowString += seatString;
			}
			seatlist.add(rowString);
		}
		setSeats(seatlist);
		return SUCCESS;
	}
}
