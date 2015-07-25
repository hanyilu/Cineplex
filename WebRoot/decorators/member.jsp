<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
 	<title><decorator:title default="会员" /></title>
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap-datetimepicker.min.css" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css" />
 	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.min.js"></script>
 	<script type="text/javascript" src="<%=basePath%>js/bootstrap.min.js"></script>
 	<script type="text/javascript" src="<%=basePath%>js/bootstrap-datetimepicker.min.js"></script>
  	<decorator:head />
  </head>
  
  <body class="inverse-body">
  	<div>
		<nav class="navbar navbar-inverse navbar-fixed-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Cineplex</a>
		    </div>
		
		    <div class="collapse navbar-collapse">
		      <ul class="nav navbar-nav navbar-right">
		        <li><a href="home.jsp">首页</a></li>
		        <li><a href="getFilms.action?day=0">电影院</a></li>
		        <li><a href="getActivityList.action">活动</a></li>
		        <li><a href="getAccount.action">充值</a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">查看记录 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="purchaseRecord.action">查看购票记录</a></li>
		            <li><a href="rechargeRecord.action">查看充值记录</a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">个人中心 <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li><a href="memberInfo.action">查看个人信息</a></li>
		            <li><a href="change_password.jsp">修改密码</a></li>
		            <li class="divider"></li>
		            <li><a href="getCredit.action">积分换兌</a></li>
		            <li class="divider"></li>
		            <li><a href="#" onclick="confirmLogout()">退出登录</a></li>
		          </ul>
		        </li>
		      </ul>
		    </div>
		  </div>
		</nav>
	</div>
	
	<div class="container page-content member-content">
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

