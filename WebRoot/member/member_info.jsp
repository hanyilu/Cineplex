<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>个人信息</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>个人信息</span>
  			<h6 style="display:inline;margin-left:20px;"><s:a href="editInfo.action">修改个人信息</s:a></h6>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<form class="form-horizontal">
  			<div class="col-md-4 col-md-offset-2">
	    		<div class="form-group">
		    		<label class="col-sm-6 control-label">会员ID</label>
			    	<div class="col-sm-6">
			    		<h5><s:property value="member.id" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">姓名</label>
			    	<div class="col-sm-6">
			    		<h5><s:property value="member.name" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">性别</label>
			    	<div class="col-sm-6">
			    		<h5><s:property value="member.gender" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">生日</label>
			    	<div class="col-sm-6">
			    		<h5><s:property value="member.birthday" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">地址</label>
			    	<div class="col-sm-6">
			    		<h5><s:property value="member.address" /></h5>
			    	</div>
			    </div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
		    		<label class="col-sm-5 control-label">会员等级</label>
			    	<div class="col-sm-7">
			    		<h5><s:property value="member.level" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-5 control-label">积分</label>
			    	<div class="col-sm-7">
			    		<h5>
			    			<s:property value="member.credit" />&nbsp&nbsp
			    			<button class="btn btn-info btn-xs"><s:a href="getCredit.action" style="color:white">换兌</s:a></button>
			    		</h5>
					</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-5 control-label">余额</label>
			    	<div class="col-sm-7">
			    		<h5><s:property value="member.balance" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-5 control-label">开始时间</label>
			    	<div class="col-sm-7">
			    		<h5><s:date name="member.startTime" format="yyyy/MM/dd HH:mm" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-5 control-label">会员状态</label>
			    	<div class="col-sm-7">
			    		<s:if test="member.state==0">
			    			<h5>未激活</h5>
			    		</s:if>
			    		<s:elseif test="member.state==1">
			    			<h5>正常</h5>
			    		</s:elseif>
			    		<s:elseif test="member.state==2">
			    			<h5>暂停</h5>
			    		</s:elseif>
			    		<s:elseif test="member.state==3">
			    			<h5>失效</h5>
			    		</s:elseif>
			    		<s:elseif test="member.state==4">
			    			<h5>取消</h5>
			    		</s:elseif>
			    	</div>
			    </div>
			</div>
		</form>
	</div>
	<div class="row" style="margin-top:40px;">
		<div class="col-md-3 col-md-offset-8">
			<button class="btn btn-danger btn-xs" onclick="confirmCancel()">注销会员资格</button>
		</div>
	</div>
	
	<script type="text/javascript">
	  	function confirmCancel(){
			if(window.confirm('该操作无法注销。是否确定注销会员资格？')){
	  			location.href="cancelMember.action";
	  		}
		}
	</script>
  </body>
</html>
