<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>查看会员信息</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>查看会员信息</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
		  	<div class="form-inline">
				<div class="form-group">
				    <label>查看会员</label>
				    <input type="text" class="form-control" placeholder="会员ID" id="mid" />
				</div>
				<div class="form-group">
				    <select class="form-control" id="infoType">
						<option value="1">个人信息</option>
						<option value="2">消费记录</option>
						<option value="3">缴费记录</option>
					</select>
				</div>
				<button class="btn btn-info" onclick="loadInfo()">查看</button>
			</div>
		</div>
    </div>
    
    <div class="row" id="info">
    	<div class="row infoDiv" id="info_1" style="display:none;">
	  		<form class="form-horizontal">
	  			<div class="col-md-5 col-md-offset-1">
		    		<div class="form-group">
			    		<label class="col-sm-6 control-label">会员ID</label>
				    	<div class="col-sm-6">
				    		<h5 id="memberId"></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">姓名</label>
				    	<div class="col-sm-6">
				    		<h5 id="memberName"></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">性别</label>
				    	<div class="col-sm-6">
				    		<h5 id="memberGender"></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">生日</label>
				    	<div class="col-sm-6">
				    		<h5 id="memberBirthday"></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-6 control-label">地址</label>
				    	<div class="col-sm-6">
				    		<h5 id="memberAddress"><s:property value="member.address" /></h5>
				    	</div>
				    </div>
				</div>
				<div class="col-md-5">
					<div class="form-group">
			    		<label class="col-sm-5 control-label">会员等级</label>
				    	<div class="col-sm-7">
				    		<h5 id="memberLevel"><s:property value="member.level" /></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-5 control-label">积分</label>
				    	<div class="col-sm-7">
				    		<h5 id="memberCredit"></h5>
						</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-5 control-label">余额</label>
				    	<div class="col-sm-7">
				    		<h5 id="memberBalance"></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-5 control-label">开始时间</label>
				    	<div class="col-sm-7">
				    		<h5 id="memberStartTime"></h5>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-sm-5 control-label">会员状态</label>
				    	<div class="col-sm-7">
				    		<h5 id="memberState"></h5>
				    	</div>
				    </div>
				</div>
			</form>
		</div>
		<div class="row infoDiv" id="info_2" style="display:none;">
			<div class="col-md-10 col-md-offset-1">
				<table class="table table-condensed">
			  		<thead>
						<tr>
					  		<th>日期</th>
					  		<th>电影</th>
					  		<th>开始时间</th>
					  		<th>放映厅</th>
					  		<th>票数</th>
					  		<th>总金额</th>
					  		<th>购票时间</th>
						</tr>
					</thead>
					<tbody id="salesTable"></tbody>
				</table>
			</div>
		</div>
		<div class="row infoDiv" id="info_3" style="display:none;">
			<div class="col-md-8 col-md-offset-2">
				<table class="table table-condensed">
			  		<thead>
						<tr>
					  		<th>充值时间</th>
					  		<th>充值金额</th>
						</tr>
					</thead>
					<tbody id="rechargesTable"></tbody>
				</table>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="<%=basePath%>js/member_info.js"></script>
  </body>
</html>