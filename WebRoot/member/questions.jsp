<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>问卷</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>问卷</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
	<form action="submitAnswers.action" method="post">
	  	<s:iterator value="questionList" var="question" status="status">
	  		<div class="form-group">
			    <label class="col-md-11 col-md-offset-1 control-label"><s:property value="#question.content" /></label>
			    <div class="col-md-11 col-md-offset-1" style="margin-bottom:28px;"> 
			    	<s:iterator value="#question.answers" var="answer">
					    <label class="radio-inline">
							<input type="radio" name="<s:property value="%{'answers['+#status.index+']'}"/>" value="<s:property value="#answer.id"/>" />
							<s:property value="#answer.answer"/>
						</label>
					</s:iterator>
				</div>
			</div>
		</s:iterator>
		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-4">
				<button type="submit" class="btn btn-info btn-block" style="margin-top:30px;">提交</button>
		    </div>
		</div>
	</form>
  </body>
</html>
