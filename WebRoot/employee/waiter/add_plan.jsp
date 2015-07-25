<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>制定放映计划</title>
</head>
 
<body>
	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>制定放映计划</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
	  	<div class="col-md-10 col-md-offset-1">
	  		<form action="addPlan.action" method="post" class="form-horizontal">
	  			<div class="form-group">
			    	<label class="col-md-2 control-label">日期</label>
				   	<div class="col-md-4">
				   		<div class="input-append date datepicker">
						    <input size="16" type="text" class="form-control" name="plan.date" value="">
						    <span class="add-on"><i class="icon-th"></i></span>
						</div>
				   	</div>
				   	<label class="col-md-2 control-label">放映厅</label>
				   	<div class="col-md-4">
				   		<select name="plan.roomId" class="form-control" id="chooseRoom">
				   			<option value="0">----请选择----</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
				   	</div>
			    </div>
			    <div class="form-group">
			    	<table class="table">
			    		<tr>
			    			<th>时间</th>
							<th>电影id</th>
							<th>票价</th>
						</tr>
						<s:iterator value="new int[6]" status="status">
							<tr>
								<td>
								<div class="input-append date timepicker">
								    <input size="16" type="text" class="form-control" name="<s:property value="%{'planItems['+#status.index+'].duration'}"/>" value="">
								    <span class="add-on"><i class="icon-th"></i></span>
								</div>
								</td>
								<td>
									<select name="<s:property value="%{'planItems['+#status.index+'].film.id'}"/>" class="form-control">
										<option value="0">----请选择----</option>
										<s:iterator value="films" var="film">
									  		<option value="<s:property value="#film.id"/>"><s:property value="#film.name" /></option>
									  	</s:iterator>
									</select>
								</td>
								<td>
									<input type="text" name="<s:property value="%{'planItems['+#status.index+'].price'}"/>" class="form-control" />
								</td>
							</tr>
						</s:iterator>
			    	</table>
			    </div>
			    <div class="form-group">
			    	<div class="col-sm-4 col-sm-offset-4">
			    		<button type="submit" class="btn btn-info btn-block" disabled="disabled">提交</button>
			    	</div>
			    </div>
	  		</form>
	  	</div>
	</div>
	<script type="text/javascript">
    $(".datepicker").datetimepicker({
        format: "yyyy-mm-dd",
        autoclose: true,
        startDate: new Date(),
        minView:2,
        maxView:3
    });
    $(".timepicker").datetimepicker({
        format: "hh:ii",
        autoclose: true,
        startView:1,
        minView:0,
        maxView:1
    });
    $("#chooseRoom").change(function(){
        if($("#chooseRoom").val() > 0){
        	$(".btn").removeAttr("disabled");
        } else {
        	$(".btn").attr("disabled","disabled");
        }
    });
	</script>
</body>
</html>
