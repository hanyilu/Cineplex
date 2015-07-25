<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>制定活动</title>
  </head>
  
  <body>
	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>制定活动</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
  			<form action="addActivity?fid=<s:property value="film.id"/>" method="post" class="form-horizontal">
  				<s:iterator value="new int[3]" status="status">
  					<div class="form-group">
			    		<label class="col-md-2 control-label">问题<s:property value="#status.index+1"/></label>
				    	<div class="col-md-8">
				    		<textarea rows="2" name="questions[<s:property value="#status.index"/>].content" class="form-control"></textarea>
				    	</div>
				    </div>
				    <div class="form-group">
			    		<label class="col-md-2 control-label">选项</label>
				    	<div class="col-md-8">
				    		<s:iterator value="#{0:'A、',1:'B、',2:'C、' }" var="var">
				    			<div class="row">
				    				<label class="col-md-2 control-label"><s:property value="%{#var.value}" /></label>
				    				<div class="col-md-10">
				    					<input type="text" name="answers<s:property value="#status.index"/>[<s:property value="#var.key"/>].answer" class="form-control" />
				    				</div>
				    			</div>
							</s:iterator>
				    	</div>
				    </div>
  				</s:iterator>
  				<div class="form-group">
		    		<label class="col-md-2 control-label">放映计划</label>
			    	<div class="col-md-8">
			    		<s:iterator value="film.planItems" var="item">
			    			<div class="checkbox">
			    			<label>
								<input type="checkbox" name="selectItemId" value="<s:property value='#item.id'/>">
								<s:property value="#item.plan.date" />
	                            <s:property value="#item.duration" />
							</label>
							</div>
                        </s:iterator>
			    	</div>
			    </div>
			    <div class="form-group">
			    	<div class="col-sm-4 col-sm-offset-4">
			    		<button type="submit" class="btn btn-info btn-block">提交</button>
			    	</div>
			    </div>
			</form>
  		</div>
  	</div>
  </body>
</html>
