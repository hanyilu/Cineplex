<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
 	<title><decorator:title default="服务员" /></title>
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap-datetimepicker.min.css" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css" />
 	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
 	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
 	<script type="text/javascript" src="<%=basePath%>js/bootstrap-datetimepicker.min.js"></script>
  	<decorator:head />
  </head>
  
  <body>
  	<div>
		<nav class="navbar navbar-default navbar-fixed-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Cineplex</a>
		    </div>
		
		    <div class="collapse navbar-collapse">
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="home.jsp">首页</a></li>
		        <li><a href="getTodayPlanItems.action">售票</a></li>
		        <li><a href="member_info.jsp">会员信息</a></li>
		        <li><a href="add_film.jsp">添加电影</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">放映计划<span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="makePlan.action">制定计划</a></li>
		            <li><a href="getEditPlan.action">修改计划</a></li>
		          </ul>
		        </li>
		        <li><a href="getOnlineFilms.action">发布活动</a></li>
		        <li><a href="#" onclick="confirmLogout()">退出登录</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</div>
	
	<div class="container page-content employee-content">
    	<decorator:body />
    </div>
  </body>
  <script type="text/javascript">
	$('.dropdown-toggle').dropdown();
  </script>
  <script type="text/javascript">
	function confirmLogout(){
		if(window.confirm('是否确定退出？')){
			location.href="logout.action";
		}
	}
  </script>
</html>