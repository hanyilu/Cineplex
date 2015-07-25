<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.cineplex.pojo.impl.Member"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>查看电影院使用情况</title>
  	<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/exporting.js"></script>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-3 title inverse-title">
  			<span>查看电影院使用情况</span>
  		</div>
  		<div class="col-md-9 title-nav">
	  		<ul class="nav nav-pills">
	  			<s:if test="month==1">
					<li class="active"><a href="cinemaCharts.action?month=1">上个月</a></li>
					<li><a href="cinemaCharts.action?month=0">本月</a></li>
				</s:if>
				<s:else>
					<li><a href="cinemaCharts.action?month=1">上个月</a></li>
					<li class="active"><a href="cinemaCharts.action?month=0">本月</a></li>
				</s:else>
			</ul>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
    
    <div class="row">
	    <div class="col-md-10 col-md-offset-1">
	    	<div class="row">
			    <ul class="nav nav-tabs" id="chartTabs">
				    <li class="active">
				    	<a href="#personCount" aria-controls="age" role="tab" data-toggle="tab" onclick="showPersonCountChart(<s:property value="month"/>)">日/月总人数</a>
				    </li>
				    <li>
				    	<a href="#room" aria-controls="gender" role="tab" data-toggle="tab" onclick="showRoomChart(<s:property value="month"/>)">各厅上座率</a>
				    </li>
				    <li>
				    	<a href="#film" aria-controls="address" role="tab" data-toggle="tab" onclick="showFilmChart(<s:property value="month"/>)">各电影上座率</a>
				    </li>
				    <li>
				    	<a href="#payType" aria-controls="cardState" role="tab" data-toggle="tab" onclick="showPayTypeChart(<s:property value="month"/>)">购票方式统计</a>
				    </li>
				</ul>
			</div>
			<div class="row">
				<div class="tab-content">
				    <div role="tabpanel" class="tab-pane active" id="personCount"><div id="personCountChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="room"><div id="roomChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="film"><div id="filmChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="payType"><div id="payTypeChart"></div></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/show_chart.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#chartTabs a[href="#personCount"]').click();
	});
	</script>
  </body>
</html>