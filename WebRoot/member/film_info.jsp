<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>电影详情</title>
  </head>
  
  <body>
    <div class="row">
  		<div class="col-md-12 title">
  			<span>选择座位</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>

	<div class="row">
		<div class="col-md-4" style="word-wrap: break-word;">
			<form class="form-horizontal">
	    		<div class="form-group">
		    		<label class="col-sm-4 control-label">电影名称</label>
			    	<div class="col-sm-8">
			    		<h5><s:property value="item.film.name" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-4 control-label">导演</label>
			    	<div class="col-sm-8">
			    		<h5><s:property value="item.film.director" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-4 control-label">主演</label>
			    	<div class="col-sm-8">
			    		<h5><s:property value="item.film.staring" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-4 control-label">片长</label>
			    	<div class="col-sm-8">
			    		<h5><s:property value="item.film.duration" /></h5>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-4 control-label">简介</label>
			    	<div class="col-sm-8">
			    		<h5><s:property value="item.film.description" /></h5>
			    	</div>
			    </div>
			</form>
		</div>

		<div class="col-md-8">
			<s:form action="purchase.action?pid=%{pid}" theme="simple">
			<div class="table-div">
		  		<table class="table table-bordered table-condensed">
			  		<s:iterator value="seatMap" var="row" status="status">
			  			<tr>
			  			<th><s:property value="#status.index+1"/>排</th>
			  			<s:iterator value="#row" var="seat" status="st">
			  				<td>
				  				<s:if test="#seat.id==0">
				  					已售
				  				</s:if>
				  				<s:else>
				  					<input type="checkbox" name="selectId" value="<s:property value='#seat.id'/>" />
				  					<s:property value="#st.index+1" />
				  				</s:else>
			  				</td>
			  			</s:iterator>
			  			</tr>
					</s:iterator>
		  		</table>
		  		</div>
			  	<div class="form-group">
				    <div class="col-sm-offset-8 col-sm-4">
				      <button type="submit" class="btn btn-default">确定</button>
				    </div>
				</div>
	  		</s:form>
		</div>
	</div>
  	
  
  </body>
</html>
