<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>修改密码</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
	
	<div class="center-form">
	    <form action="changePassword.action" method="post" class="form-horizontal">
	    	<div class="form-group">
		    	<label class="col-sm-3 control-label">原密码</label>
		    	<div class="col-sm-7">
		      		<input type="password" name="password" class="form-control" />
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">新密码</label>
		    	<div class="col-sm-7">
		      		<input type="password" name="newPassword" class="form-control" />
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">重复密码</label>
		    	<div class="col-sm-7">
		      		<input type="password" name="rePassword" class="form-control" />
		    	</div>
		  	</div>
		  	<div class="form-group">
			    <div class="col-sm-offset-3 col-sm-3">
			      <button type="submit" class="btn btn-default">登录</button>
			    </div>
			</div>
		</form>
	</div>
  </body>
</html>
