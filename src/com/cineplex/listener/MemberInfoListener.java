package com.cineplex.listener;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MemberInfoListener implements ServletContextListener,
		ServletContextAttributeListener {
	
	private static final long STATE_INTERVAL = 30 * 60 * 1000;
	private static final long CREDIT_INTERVAL = 24 * 60 * 60 * 1000;
	private static Timer stateTimer=new Timer();
	private static Timer creditTimer=new Timer();
	
	private static final int HOUR = 3;  
    private static final int MINUTE = 0;
    private static final int SECOND = 0;  
	
	@Override
	public void contextInitialized(ServletContextEvent cse) {
		stateTimer.schedule(new MemberStateTask(),new Date(),STATE_INTERVAL);
		Calendar calendar = Calendar.getInstance();       
        calendar.set(Calendar.HOUR_OF_DAY, HOUR);  
        calendar.set(Calendar.MINUTE, MINUTE);  
        calendar.set(Calendar.SECOND, SECOND);   
		creditTimer.schedule(new MemberCreditTask(),calendar.getTime(),CREDIT_INTERVAL);
	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {

	}

	@Override
	public void contextDestroyed(ServletContextEvent cse) {
		System.out.println("Application shut down");
	}
}