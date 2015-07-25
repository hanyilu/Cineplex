package com.cineplex.member.service;

import java.util.ArrayList;
import java.util.List;

import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.RechargeRecord;
import com.cineplex.pojo.impl.Sales;
import com.cineplex.pojo.impl.Seat;

public interface IMemberService {
	
	public boolean hasMatch(Member member);
	public String register(Member member);
	public String getBankAccount(int memberId);
	public boolean recharge(int memberId,int level, double pay);
	public boolean cancel(int memberId);
	public List<PlanItem> getPlanItems(int day);
	public PlanItem getPlanItem(int pid);
	public List<ArrayList<Seat>> getSeatMap(Integer roomId, String soldSeatsId);
	public Member getMember(Integer mid);
	public List<Seat> confirmSeat(List<Integer> selectId);
	public boolean purchase(Member member, double payment, PlanItem item, String seatString, int seatCount);
	public List<PlanItem> getActivityItemList(int memberId);
	public boolean submitAnswers(List<Integer> answers, int memberId);
	public boolean changeCredit(int memberId, int credit);
	public List<Sales> getPurchaseRecord(int memberId);
	public List<RechargeRecord> getRechargeRecord(int memberId);
	public Seat getSeat(int sid);
	public boolean saveInfo(int memberId, Member member);
	public String changePassword(int memberId, String password, String newPassword);
}
