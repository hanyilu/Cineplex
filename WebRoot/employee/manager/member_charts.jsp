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
  	<title>查看会员统计信息</title>
  	<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/exporting.js"></script>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-3 title inverse-title">
  			<span>查看会员统计信息</span>
  		</div>
  		<div class="col-md-9 title-nav">
	  		<ul class="nav nav-pills">
	  			<s:if test="month==1">
					<li class="active"><a href="memberCharts.action?month=1">上个月</a></li>
					<li><a href="memberCharts.action?month=0">本月</a></li>
				</s:if>
				<s:else>
					<li><a href="memberCharts.action?month=1">上个月</a></li>
					<li class="active"><a href="memberCharts.action?month=0">本月</a></li>
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
				    	<a href="#age" aria-controls="age" role="tab" data-toggle="tab" onclick="showAgeChart(<s:property value="month"/>)">年龄</a>
				    </li>
				    <li>
				    	<a href="#gender" aria-controls="gender" role="tab" data-toggle="tab" onclick="showGenderChart(<s:property value="month"/>)">性别</a>
				    </li>
				    <li>
				    	<a href="#address" aria-controls="address" role="tab" data-toggle="tab" onclick="showAddressChart(<s:property value="month"/>)">居住地</a>
				    </li>
				    <li>
				    	<a href="#cardState" aria-controls="cardState" role="tab" data-toggle="tab" onclick="showCardStateChart(<s:property value="month"/>)">会员卡状态</a>
				    </li>
				    <li>
				    	<a href="#sales" aria-controls="salesChart" role="tab" data-toggle="tab" onclick="showSalesChart(<s:property value="month"/>)">消费</a>
				    </li>
				    <li>
				    	<a href="#activity" aria-controls="activityChart" role="tab" data-toggle="tab">活动</a>
				    </li>
				</ul>
			</div>
			<div class="row">
				<div class="tab-content">
				    <div role="tabpanel" class="tab-pane active" id="age"><div id="ageChart1"></div><div id="ageChart2"></div></div>
				    <div role="tabpanel" class="tab-pane" id="gender"><div id="genderChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="address"><div id="addressChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="cardState"><div id="cardStateChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="sales"><div id="salesChart"></div></div>
				    <div role="tabpanel" class="tab-pane" id="activity">
				    	<div class="row" style="margin-top:20px;">
					    	<div class="col-md-3">
					    		<ul class="nav nav-pills nav-stacked" id="filmTabs">
					    			<s:iterator value="activity" id="act">
					    				<li id="li<s:property value="value"/>">
					    					<a onclick="showQuestionChart('<s:property value="value"/>')">
					    						<s:property value="key"/>
					    					</a>
					    				</li>
					    			</s:iterator>
								</ul>
							</div>
							<div class="col-md-9">
								<div class="tab-content" id="activityCharts">
									<s:iterator value="activity" id="act">
										<div style="display:none" class="tab-pane" id="film<s:property value="value"/>"></div>
									</s:iterator>
								</div>
							</div>
				    	</div>
				    </div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/show_chart.js"></script>
	<script type="text/javascript">
	$(function(){
		$('#chartTabs a[href="#age"]').click();
		$('#filmTabs a').first().click();
	});
	</script>
  </body>
</html>