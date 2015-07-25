<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <div class="row">
  		<div class="col-md-12 title">
  			<span>会员注册</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
	<div class="center-form">
	    <form action="register.action" class="form-horizontal">
	    	<div class="form-group">
		    	<label class="col-sm-3 control-label">姓名</label>
		    	<div class="col-sm-7">
		      		<input type="text" name="member.name" class="form-control require" />
		    	</div>
		    	<div class="col-sm-2">
		      		<span style="color:red" id="member-name"></span>
		    	</div>
		  	</div>
		  	
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">性别</label>
		    	<div class="col-sm-7">
		      		<label class="radio-inline">
					  <input type="radio" name="member.gender" value="1" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="member.gender" value="2"> 女
					</label>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">密码</label>
		    	<div class="col-sm-7">
		      		<input type="password" name="member.password" class="form-control require" />
		    	</div>
		    	<div class="col-sm-2">
		      		<span style="color:red" id="member-password"></span>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">确认密码</label>
		    	<div class="col-sm-7">
		      		<input type="password" name="repassword" class="form-control require" />
		    	</div>
		    	<div class="col-sm-2">
		      		<span style="color:red" id="repassword"></span>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">生日</label>
		    	<div class="col-sm-7">
		    		<div class="input-append date datepicker">
					    <input size="16" type="text" class="form-control require" name="member.birthday" value="">
					    <span class="add-on"><i class="icon-th"></i></span>
					</div>
		    	</div>
		    	<div class="col-sm-2">
		      		<span style="color:red" id="member-birthday"></span>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">银行卡账号</label>
		    	<div class="col-sm-7">
		      		<input type="text" name="member.bankAccount" class="form-control require"/>
		    	</div>
		    	<div class="col-sm-2">
		      		<span style="color:red" id="member-bankAccount"></span>
		    	</div>
		  	</div>
		  	<div class="form-group">
		    	<label class="col-sm-3 control-label">居住地</label>
		    	<div class="col-sm-7">
		    		<select class="form-control" name="member.address" >
				    	<option value="0">鼓楼区</option>
						<option value="1">玄武区</option>
						<option value="2">秦淮区</option>
						<option value="3">建邺区</option>
						<option value="4">白下区</option>
						<option value="5">下关区</option>
						<option value="6">雨花台区</option>
						<option value="7">浦口区</option>
						<option value="8">栖霞区</option>
						<option value="9">江宁区</option>
						<option value="10">六合区</option>
						<option value="11">其他地区</option>
					</select>
				</div>
		  	</div>
		  	<div class="form-group">
			    <div class="col-sm-offset-3 col-sm-3">
			      <button type="submit" class="btn btn-default">注册</button>
			    </div>
			    <div class="col-sm-6">
			      <a href="login.jsp">直接登录</a>
			    </div>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	$(".datepicker").datetimepicker({
        format: "yyyy-mm-dd",
        autoclose: true,
        startView:4,
        minView:2,
        maxView:4
    });
    $(".require").blur(function(){
    	var name = $(this).attr("name").replace(".","-");
    	if($(this).val()==""){
	    	$("#"+name).html("必填");
    	} else {
    		$("#"+name).html("");
    		if(name == "repassword" && $(this).val() != $("input[name='member.password']").val()) {
    			$("#"+name).html("要一致");
    		}
    	}
    });
	</script>
  </body>
</html>
