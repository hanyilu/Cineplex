<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>查看统计图</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>查看统计图</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
		  	<div class="form-inline">
				<div class="form-group">
				    <select class="form-control" id="chartType">
				    	<option value="0">请选择查看项</option>
						<option value="1">会员年龄及各年龄段百分比</option>
						<option value="2">会员性别</option>
						<option value="3">会员居住地</option>
						<option value="3">会员消费情况</option>
						<option value="3">会员参加活动情况</option>
						<option value="3">会员卡状态</option>
					</select>
				</div>
				<button class="btn btn-info" onclick="loadChart()">查看</button>
			</div>
		</div>
    </div>
    
    <div class="row">
    	<div class="col-md-8 col-md-offset-2" id="chart">
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/highcharts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/exporting.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/show_chart.js"></script>
  </body>
</html>