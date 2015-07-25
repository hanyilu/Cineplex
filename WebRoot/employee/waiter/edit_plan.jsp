<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>修改放映计划</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>修改放映计划</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
	  	<div class="col-md-10 col-md-offset-1">
	  		<form action="submitEdit.action?pid=<s:property value="%{pid}"/>" method="post" class="form-horizontal">
	  			<div class="form-group">
			    	<label class="col-md-2 control-label">日期</label>
				   	<div class="col-md-4">
				   		<h5><s:property value="plan.date" /></h5>
				   	</div>
				   	<label class="col-md-2 control-label">放映厅</label>
				   	<div class="col-md-4">
				   		<h5><s:property value="plan.roomId" /></h5>
				   	</div>
			    </div>
			    <div class="form-group">
			    	<table class="table">
			    		<tr>
			    			<th>时间</th>
							<th>电影</th>
							<th>票价</th>
						</tr>
						<s:iterator value="new int[6]" status="status">
							<tr>
								<td>
									<div class="input-append date timepicker">
									    <input size="16" type="text" class="form-control" name="planItems[<s:property value="#status.index"/>].duration" value="<s:property value="%{planItems[#status.index].duration}"/>">
									    <span class="add-on"><i class="icon-th"></i></span>
									</div>
								</td>
								<td>
									<s:set name="fid" value="planItems.get(#status.index).film.id"></s:set>
									<select name="<s:property value="%{'planItems['+#status.index+'].film.id'}"/>" class="form-control">
										<option value="0">----请选择----</option>
										<s:iterator value="films" var="film">
											<s:if test="#film.id==#fid">
									  			<option value="<s:property value="#film.id"/>" selected="selected"><s:property value="#film.name" /></option>
									  		</s:if>
									  		<s:else>
									  			<option value="<s:property value="#film.id"/>"><s:property value="#film.name" /></option>
									  		</s:else>
									  	</s:iterator>
									</select>
								</td>
								<td>
									<input type="text" name="planItems[<s:property value="#status.index"/>].price" value="<s:property value="%{planItems[#status.index].price}"/>" class="form-control" />
								</td>
							</tr>
						</s:iterator>
			    	</table>
			    </div>
			    <div class="form-group">
			    	<div class="col-sm-4 col-sm-offset-4">
			    		<button type="submit" class="btn btn-info btn-block">提交</button>
			    	</div>
			    </div>
	  		
	  		</form>
	  	</div>
	</div>
	<%  %>
	<script type="text/javascript">
    $(".timepicker").datetimepicker({
        format: "hh:ii",
        autoclose: true,
        startDate: "${plan.date}",
        startView:1,
        minView:0,
        maxView:1
    });
	</script>
  </body>
</html>
