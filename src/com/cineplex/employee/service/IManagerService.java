package com.cineplex.employee.service;

import java.util.HashMap;
import java.util.List;

import com.cineplex.pojo.impl.Member;
import com.cineplex.pojo.impl.Plan;
import com.cineplex.pojo.impl.PlanItem;
import com.cineplex.pojo.impl.Question;

public interface IManagerService {
	// 获取未审批的计划列表
	public List<Plan> getUnapprovedPlans();
	// 查看计划中的具体计划项
	public List<PlanItem> getPlanItems(int pid);
	// 批准计划（状态置为1，其他为-1）
	public boolean approve(int pid, int mid);
	// 不通过计划（状态置为2）
	public boolean unapprove(int pid, int mid);
	// 获取所有会员信息
	public List<Member> getAllMembers();
	// 获取会员地址分布信息
	public HashMap<String, Integer> getAddressCount();
	// 获取会员卡状态情况
	public HashMap<String, Integer> getCardState();
	// 获取会员性别情况
	public HashMap<String, Integer> getGender();
	// 获取销售情况
	public HashMap<String, Double> getFilmSales(int month);
	// 获取付款方式情况
	public HashMap<String, Integer> getPayType(int month);
	// 
	public HashMap<Integer, Integer> getPersonCount(int month);
	public HashMap<Integer, Double> getRoom(int month);
	public HashMap<String, Double> getFilm(int month);
	public HashMap<String, String> getActivity(int month);
	public List<Question> getQuestion(String items);
}
