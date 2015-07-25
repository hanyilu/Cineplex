<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>积分换兌</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>积分换兌</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<form action="changeCredit.action" method="post" class="form-horizontal">
  			<div class="col-md-5 col-md-offset-3">
  				<div class="form-group">
		    		<label class="col-sm-6 control-label">换兌比例</label>
			    	<div class="col-sm-6">
			    		<h5>100积分=1元</h5>
			    	</div>
			    </div>
	    		<div class="form-group">
		    		<label class="col-sm-6 control-label">剩余积分</label>
			    	<div class="col-sm-6">
			    		<h5><s:property value="member.credit" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-6 control-label">要换兌积分</label>
			    	<div class="col-sm-6">
			    		<input type="text" name="credit" class="form-control"/>
			    	</div>
			    </div>
			    <div class="form-group">
			    	<div class="col-sm-6 col-sm-offset-6">
			    		<button value="submit" class="btn btn-info">确定</button>
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
