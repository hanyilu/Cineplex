<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>会员登录</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>会员登录</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
	
	<div class="center-form">
	    <form action="login.action" method="post" class="form-horizontal">
	    	<div class="form-group">
		    	<label class="col-sm-3 control-label">用户名</label>
		    	<div class="col-sm-7">
		      		<input type="text" name="member.id" class="form-control" />
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">密码</label>
		    	<div class="col-sm-7">
		      		<input type="password" name="member.password" class="form-control" />
		    	</div>
		  	</div>
		  	<div class="form-group">
			    <div class="col-sm-offset-3 col-sm-3">
			      <button type="submit" class="btn btn-default">登录</button>
			    </div>
			    <div class="col-sm-6">
			      <a href="register.jsp">去注册</a>
			    </div>
			</div>
		</form>
	</div>
  </body>
</html>
