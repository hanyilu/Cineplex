<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>选择电影</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>可发布活动的电影</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
	</div>
	<div class="row">
		<div class="col-md-8 col-md-offset-1">
			<div class="list-group">
				<s:iterator value="films" var="var">
					<a href="getFilm.action?fid=<s:property value="#var.id"/>" class="list-group-item">
						<s:property value="#var.name" />
						（<s:date name="#var.onlineTime" format="yyyy/MM/dd"/>--<s:date name="#var.offlineTime" format="yyyy/MM/dd"/>）
					</a>
				</s:iterator>
			</div>
		</div>
	</div>
  </body>
</html>