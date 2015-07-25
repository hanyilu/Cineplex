<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>查看放映计划</title>
  </head>
  
  <body>
    <div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>查看放映计划</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<table class="table">
		  		<tr>
			  		<th>电影</th>
			  		<th>开始时间</th>
			  		<th>票价</th>
				</tr>
				<s:iterator value="planItems" var="var">
			  		<tr>
				  		<td><s:property value="#var.film.name"/></td>
				  		<td><s:property value="#var.duration"/></td>
				  		<td><s:property value="#var.price"/></td>
				  	</tr>
			  	</s:iterator>
			</table>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2 col-md-offset-3">
			<a href="getUnapprovedPlans.action" class="button"><button class="btn btn-info btn-block">返回</button></a>
		</div>
		<div class="col-md-2">
			<a href="unapprovePlan.action?pid=<s:property value="%{pid}"/>" class="button"><button class="btn btn-warning btn-block">不通过</button></a>
		</div>
		<div class="col-md-2">
			<a href="approvePlan.action?pid=<s:property value="%{pid}"/>" class="button"><button class="btn btn-success btn-block">批准</button></a>
		</div>
	</div>
  </body>
</html>