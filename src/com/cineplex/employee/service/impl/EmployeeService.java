package com.cineplex.employee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IEmployeeService;
import com.cineplex.pojo.IEmployeeDao;
import com.cineplex.pojo.impl.Employee;

public class EmployeeService implements IEmployeeService {
	@Autowired
	private IEmployeeDao employeeDao;

	@Override
	public String match(Employee employee) {
		Employee em = employeeDao.findById(employee.getId());
		if (em != null && em.getPassword().equals(employee.getPassword())) {
			return em.getPosition();
		}
		return "fail";
	}

}
