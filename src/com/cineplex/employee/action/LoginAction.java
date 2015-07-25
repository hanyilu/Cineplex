package com.cineplex.employee.action;

import java.util.Map;

import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IEmployeeService;
import com.cineplex.pojo.impl.Employee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
	private Employee employee;
	private String message;
	@Autowired
    private IEmployeeService employeeService;

    public Employee getEmployee() {  
        return employee;  
    }  
  
    public void setEmployee(Employee employee) {  
        this.employee = employee;  
    }  
	
	public String getMessage(){
		return this.message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}

    public String login(){
    	String em = employeeService.match(employee);
        if (!em.equals("fail")) {
        	setMessage("Welcome!");
        	Map session = ActionContext.getContext().getSession();
            session.put("USER_ID", employee.getId());
            session.put("USER_TYPE", em);
            return em;  
        }  
        setMessage("用户名不存在或密码错误！");
        return "message";  
    } 
    
	public String logout() {
		Map session = ActionContext.getContext().getSession();
		session.clear();
		return "success";
	}
}
