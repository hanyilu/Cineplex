<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>参加活动</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-2 title">
  			<span>活动</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
	  		<s:if test="activities.size==0">
			  	没有活动可参加
			</s:if>
			<s:else>
				<div class="table-div">
			  		<table class="table table-hover">
				  		<thead>
							<tr>
						  		<th>电影名称</th>
						  		<th>放映日期</th>
						  		<th>开始时间</th>
						  		<th>参加</th>
							</tr>
						</thead>
						<tbody>
						  	<s:iterator value="activities" var="act">
						  		<tr>
						  			<td><s:property value="#act.film.name" /></td>
						  			<td><s:property value="#act.plan.date"/></td>
						  			<td><s:property value="#act.duration"/></td>
						  			<td><s:a href="getQuestions.action?pi=%{#act.id}">参加</s:a></td>
						  		</tr>
						  	</s:iterator>
					  	</tbody>
					</table>
				</div>
			</s:else>
		</div>
  	</div>
  </body>
</html>
