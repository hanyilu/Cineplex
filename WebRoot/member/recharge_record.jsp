<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>充值记录 </title>
  </head>
  
  <body>	
 	<div class="row">
  		<div class="col-md-2 title">
  			<span>充值记录 </span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<div class="col-md-6 col-md-offset-3">
	  		<s:if test="rechargeRecords.size==0">
			  	没有记录
			</s:if>
			<s:else>
				<div class="table-div">
			  		<table class="table table-condensed">
				  		<thead>
							<tr>
						  		<th>充值时间</th>
						  		<th>充值金额</th>
							</tr>
						</thead>
						<tbody>
						  	<s:iterator value="rechargeRecords" var="var">
						  		<tr>
						  			<td><s:date name="#var.time" format="yyyy-MM-dd HH:mm:ss"></s:date></td>
						  			<td><s:property value="#var.amount"/></td>
						  		</tr>
						  	</s:iterator>
					  	</tbody>
					</table>
				</div>
			</s:else>
		</div>
  	</div>
  </body>
</html>
