package com.cineplex.employee.service;

import com.cineplex.pojo.impl.Employee;

public interface IEmployeeService {
	// 登录时查找是否有匹配的账号和密码
	public String match(Employee employee);
}
