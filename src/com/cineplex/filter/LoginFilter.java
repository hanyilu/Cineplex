package com.cineplex.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {
	
	private static ArrayList<String> undoFilter = new ArrayList<>();

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String url = request.getRequestURI();
		if (!undoFilter.contains(url)) {
			HttpSession session = request.getSession(false);
			if (session == null || session.getAttribute("USER_TYPE") == null) {
				response.sendRedirect(request.getContextPath() + "/index.jsp");
				return;
			} else if(session.getAttribute("USER_TYPE").toString().equals("waiter") && url.indexOf("/cineplex/employee/waiter") < 0) {
				response.sendRedirect(request.getContextPath() + "/employee/waiter/home.jsp");
				return;
			} else if(session.getAttribute("USER_TYPE").toString().equals("manager") && url.indexOf("/cineplex/employee/manager") < 0) {
				response.sendRedirect(request.getContextPath() + "/employee/manager/home.jsp");
				return;
			} else if(session.getAttribute("USER_TYPE").toString().equals("member") && url.indexOf("/cineplex/member") < 0) {
				response.sendRedirect(request.getContextPath() + "/member/home.jsp");
				return;
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		undoFilter.add("/cineplex/member/login.jsp");
		undoFilter.add("/cineplex/employee/login.jsp");
		undoFilter.add("/cineplex/member/register.jsp");
		undoFilter.add("/cineplex/employee/login.action");
		undoFilter.add("/cineplex/member/login.action");
		undoFilter.add("/cineplex/member/register.action");
	}

}
