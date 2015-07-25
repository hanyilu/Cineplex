<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>提示信息</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title">
  			<span>提示信息</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
    		<h5><s:property value="message" /></h5>
    	</div>
    </div>
    <div class="row">
  		<div class="col-md-8 col-md-offset-2">
    		<h5><a href="home.jsp">去首页</a></h5>
    	</div>
    </div>
    
  </body>
</html>
