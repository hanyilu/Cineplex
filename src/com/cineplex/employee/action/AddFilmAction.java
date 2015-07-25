package com.cineplex.employee.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.employee.service.IWaiterService;
import com.cineplex.pojo.impl.Film;
import com.opensymphony.xwork2.ActionSupport;

public class AddFilmAction extends ActionSupport{

	private Film film;
	private String message;
	@Autowired
	private IWaiterService waiterService;
	
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String addFilm(){
		if(waiterService.addFilm(film)){
			setMessage("添加成功");
		} else {
			setMessage("添加失败");
		}
		return "message";
	}
}
