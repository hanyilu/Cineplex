<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>需要修改的计划</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
	</div>
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="list-group">
				<s:iterator value="plans" var="var">
					<a href="editPlan.action?pid=<s:property value="#var.id"/>" class="list-group-item">
						放映日期：<s:property value="#var.date" />&nbsp&nbsp&nbsp&nbsp
						放映厅：<s:property value="#var.roomId" />
					</a>
				</s:iterator>
			</div>
		</div>
	</div>
  </body>
</html>
