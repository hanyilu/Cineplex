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
	<div class="container page-content">
		<div class="row">
	  		<div class="col-md-12 title inverse-title">
	  			<span>工作人员登录</span>
	  		</div>
	  		<div class="col-md-12">
	  			<hr>
	  		</div>
	  	</div>
		
		<div class="center-form">
		    <form action="login.action" class="form-horizontal">
		    	<div class="form-group">
			    	<label class="col-sm-3 control-label">用户名</label>
			    	<div class="col-sm-7">
			      		<input type="text" name="employee.id" class="form-control" />
			    	</div>
			  	</div>
			  	<div class="form-group">
			    	<label class="col-sm-3 control-label">密码</label>
			    	<div class="col-sm-7">
			      		<input type="password" name="employee.password" class="form-control" />
			    	</div>
			  	</div>
			  	<div class="form-group">
				    <div class="col-sm-offset-3 col-sm-3">
				      <button type="submit" class="btn btn-default">登录</button>
				    </div>
				</div>
			</form>
		</div>
	</div>
  </body>
</html>
