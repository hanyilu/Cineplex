<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>修改个人信息</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>修改个人信息</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<form action="submitEditInfo.action" metthod="post" class="form-horizontal">
  			<div class="col-md-6 col-md-offset-2">
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">姓名</label>
			    	<div class="col-sm-6">
			    		<input type="text" name="member.name" class="form-control" value="<s:property value="member.name"/>" />
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">性别</label>
			    	<div class="col-sm-6">
			    		<s:if test='member.gender=="男"'>
			    			<label class="radio-inline">
							  	<input type="radio" name="member.gender" value="1" checked="checked"> 男
							</label>
							<label class="radio-inline">
							  	<input type="radio" name="member.gender" value="2"> 女
							</label>
						</s:if>
			    		<s:else>
			    			<label class="radio-inline">
							  	<input type="radio" name="member.gender" value="1"> 男
							</label>
							<label class="radio-inline">
							  	<input type="radio" name="member.gender" value="2" checked="checked"> 女
							</label>
						</s:else>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">生日</label>
			    	<div class="col-sm-6">
			    		<input type="text" name="member.birthday" class="form-control" value="<s:property value="member.birthday"/>" />
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">地址</label>
			    	<div class="col-sm-6">
			    		<input type="text" name="member.address" class="form-control" value="<s:property value="member.address"/>" />
			    	</div>
			    </div>
			    <div class="form-group">
			    	<label class="col-sm-6 control-label">银行卡账号</label>
			    	<div class="col-sm-6">
			      		<input type="text" name="member.bankAccount" class="form-control" value="<s:property value="member.bankAccount"/>" />
			    	</div>
			  	</div>
			  	<div class="form-group">
				    <div class="col-sm-offset-6 col-sm-6">
				      <button type="submit" class="btn btn-default">确定修改</button>
				    </div>
				</div>
			</div>
		</form>
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
