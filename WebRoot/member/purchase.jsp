<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>电影院</title>
  </head>
  
  <body>	
 	<div class="row">
  		<div class="col-md-2 title">
  			<span>购买电影票</span>
  		</div>
  		<div class="col-md-10 title-nav">
  			<ul class="nav nav-pills">
			  <li><s:a href="getFilms.action?day=0">今天</s:a></li>
			  <li><s:a href="getFilms.action?day=1">明天</s:a></li>
			  <li><s:a href="getFilms.action?day=2">后天</s:a></li>
			</ul>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
	  		<s:if test="planItems.size==0">
			  	没有电影
			</s:if>
			<s:else>
				<div class="table-div">
			  		<table class="table table-hover">
				  		<thead>
							<tr>
						  		<th>开始时间</th>
						  		<th>电影</th>
						  		<th>时长</th>
						  		<th>放映厅</th>
						  		<th>票价</th>
						  		<th>购票</th>
							</tr>
						</thead>
						<tbody>
						  	<s:iterator value="planItems" var="var">
						  		<tr>
						  			<td><s:property value="#var.duration" /></td>
						  			<td><s:property value="#var.film.name"/></td>
						  			<td><s:property value="#var.film.duration"/></td>
						  			<td><s:property value="#var.plan.roomId"/></td>
						  			<td><s:property value="#var.price"/></td>
						  			<td><s:a href="getFilmInfo.action?pid=%{#var.id}">购票</s:a></td>
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
