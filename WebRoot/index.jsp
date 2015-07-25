<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css" />
<title>首页</title>
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
		        <li><a href="employee/login.jsp">工作人员登录</a></li>
		      </ul>
		    </div>
		</div>
		</nav>
	</div>
	<div class="container page-content">
		<div class="row index-row">
			<div class="col-md-3 col-md-offset-3 index-btn">
				<h1><s:a href="member/login.jsp">会员登录</s:a></h1>
			</div>
			<div class="col-md-3 index-btn">
				<h1><s:a href="member/register.jsp">会员注册</s:a></h1>
			</div>
		</div>
	</div>
</body>
</html>
