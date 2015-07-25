<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>充值/激活</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="center-form">
	    <form action="recharge.action" class="form-horizontal">
	    	<div class="form-group">
		    	<label class="col-sm-4 control-label">提示</label>
		    	<div class="col-sm-8">
		      		<h6>充值200元，1级会员，9折 </h6>
				  	<h6>充值500元，2级会员，7.5折 </h6>
				  	<h6>充值800元，3级会员，6折</h6>
				  	<h6>充值1000元，4级会员，5折 </h6>
		    	</div>
		    </div>
		    <div class="form-group">
		    	<label class="col-sm-4 control-label">银行卡账号</label>
		    	<div class="col-sm-8">
		    		<h5><s:property value="#session.BANK_ACCOUNT" /></h5>
		    	</div>
		    </div>
		    <div class="form-group">
		    	<label class="col-sm-4 control-label">金额</label>
		    	<div class="col-sm-8">
		    		<select name="level" class="form-control">
					  <option value="1">200</option>
					  <option value="2">500</option>
					  <option value="3">800</option>
					  <option value="4">1000</option>
					</select>
		    	</div>
		    </div>
		    <div class="form-group">
		    	<label class="col-sm-4 control-label">银行卡密码</label>
		    	<div class="col-sm-8">
		    		<input type="password" name="bank.password" class="form-control"/>
		    	</div>
		    </div>
		    <div class="form-group">
			    <div class="col-sm-offset-4 col-sm-4">
			      <button type="submit" class="btn btn-default">充值</button>
			    </div>
			</div>
		</form>
	</div>
  </body>
</html>
