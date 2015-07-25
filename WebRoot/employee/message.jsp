<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.min.css" />
 	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/main.css" />
    <title>工作人员登录</title>
  </head>
  
  <body>
    <div>
		<nav class="navbar navbar-default navbar-fixed-top">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="#">Cineplex</a>
		    </div>
		  </div>
		</nav>
	</div>
	<div class="page-content">
  		<s:property value="message" />
  	</div>
  	
  </body>
</html>
