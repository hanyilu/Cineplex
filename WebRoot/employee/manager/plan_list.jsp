<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>审批放映计划</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>审批放映计划</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<s:if test="plans.size==0">
				没有待审批放映计划
			</s:if>
			<div class="list-group">
				<s:iterator value="plans" var="var">
					<a href="viewPlan.action?pid=<s:property value="#var.id"/>" class="list-group-item">
						计划日期：<s:property value="#var.date" />&nbsp&nbsp&nbsp&nbsp
						放映厅：<s:property value="#var.roomId" />&nbsp&nbsp&nbsp&nbsp
						服务员：<s:property value="#var.waiterId"/>&nbsp&nbsp&nbsp&nbsp
						提交时间：<s:date name="#var.submitTime" format="MM/dd HH:mm:ss"/>
					</a>
				</s:iterator>
			</div>
		</div>
	</div>
  </body>
</html>