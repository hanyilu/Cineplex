<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>电影院</title>
  </head>
  
  <body>	
 	<div class="row">
  		<div class="col-md-12 title">
  			<span>购票记录</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	
  	<div class="row">
  		<div class="col-md-12">
	  		<s:if test="sales.size==0">
			  	没有购票记录
			</s:if>
			<s:else>
				<div class="table-div">
			  		<table class="table table-condensed">
				  		<thead>
							<tr>
						  		<th>日期</th>
						  		<th>电影</th>
						  		<th>开始时间</th>
						  		<th>放映厅</th>
						  		<th>座位</th>
						  		<th>总金额</th>
						  		<th>购票时间</th>
							</tr>
						</thead>
						<tbody>
						  	<s:iterator value="sales" var="var">
						  		<tr>
						  			<td><s:property value="#var.planItem.plan.date" /></td>
						  			<td><s:property value="#var.planItem.film.name"/></td>
						  			<td><s:property value="#var.planItem.duration"/></td>
						  			<td><s:property value="#var.planItem.plan.roomId"/></td>
						  			<td>
						  				<s:generator val="#var.seatsIds" separator="," converter="%{seat}"> 
						  					<table> 
											    <s:iterator var="seat">  
											        <tr><td><s:property /></td></tr>
											    </s:iterator> 
										    </table>  
										</s:generator> 
						  			</td>
						  			<td><s:property value="#var.payment"/></td>
						  			<td><s:date name="#var.time" format="MM-dd HH:mm:ss"></s:date></td>
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
