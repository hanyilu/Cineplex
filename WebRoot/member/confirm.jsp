<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>确认购票</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>确认购票信息</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<form action="pay.action" method="post" class="form-horizontal">
  			<div class="row">	
	  			<div class="col-md-3 col-md-offset-2">
		    		<div class="form-group">
			    		<label class="col-sm-6 control-label">电影名称</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="item.film.name" /></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">开始时间</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="item.duration" /></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">片长</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="item.film.duration" /></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">单价</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="item.price" /></h5>
				    	</div>
				    </div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
			    		<label class="col-sm-6 control-label">放映厅</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="item.plan.roomId"/></h5>
				    	</div>
				    </div>
					<div class="form-group">
			    		<label class="col-sm-6 control-label">已选座位(<s:property value="%{selectSeats.size}"/>张)</label>
				    	<div class="col-sm-6">
				    		<s:iterator value="selectSeats" var="seat">
			  					<h5><s:property value="#seat.rowNum"/>排<s:property value="#seat.columnNum"/>座</h5>
			  				</s:iterator>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">会员折扣</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="%{discountMap.get(member.level)}"/></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">总价</label>
				    	<div class="col-sm-6">
				    		<h5><s:property value="%{item.price*selectSeats.size*discountMap.get(member.level)}"/></h5>
				    	</div>
				    </div>
				</div>
			</div>
			<div class="row">	
	  			<div class="col-md-6 col-md-offset-1">
	  				<div class="form-group">
	  					<label class="col-sm-5 control-label">登录密码</label>
				    	<div class="col-sm-5">
				    		<input type="password" name="password" class="form-control" />
				    	</div>
				    	<div class="col-sm-2">
				    		<button type="submit" class="btn btn-default">确认购票</button>
				    	</div>
				    </div>
	  			</div>
	  		</div>
		</form>
  	</div>
  </body>
</html>
