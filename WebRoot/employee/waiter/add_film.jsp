<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>添加电影</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-8 col-md-offset-2">
  			<form action="addFilm.action" method="post" class="form-horizontal">
  				<div class="form-group">
		    		<label class="col-sm-2 control-label">电影名称</label>
			    	<div class="col-sm-8">
			    		<input type="text" name="film.name" class="form-control" />
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-2 control-label">电影片长</label>
			    	<div class="col-sm-8">
			    		<input type="text" name="film.duration" class="form-control" />
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-2 control-label">导演</label>
			    	<div class="col-sm-8">
			    		<input type="text" name="film.director" class="form-control" />
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-2 control-label">主演</label>
			    	<div class="col-sm-8">
			    		<input type="text" name="film.staring" class="form-control" />
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-2 control-label">简介</label>
			    	<div class="col-sm-8">
			    		<textarea rows="4" name="film.description" class="form-control"></textarea>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-2 control-label">上线时间</label>
			    	<div class="col-sm-8">
			    		<div class="input-append date datepicker">
						    <input size="16" type="text" class="form-control" name="film.onlineTime" value="">
						    <span class="add-on"><i class="icon-th"></i></span>
						</div>
			    	</div>
			    </div>
			    <div class="form-group">
		    		<label class="col-sm-2 control-label">下线时间</label>
			    	<div class="col-sm-8">
			    		<div class="input-append date datepicker">
						    <input size="16" type="text" class="form-control" name="film.offlineTime" value="">
						    <span class="add-on"><i class="icon-th"></i></span>
						</div>
			    	</div>
			    </div>
			    <div class="form-group">
			    	<div class="col-sm-4 col-sm-offset-2">
			    		<button type="submit" class="btn btn-info btn-block">提交</button>
			    	</div>
			    </div>
  			</form>
  		</div>
  	</div>
	<script type="text/javascript">
    $(".datepicker").datetimepicker({
        format: "yyyy-mm-dd",
        autoclose: true,
        minView:2,
        maxView:4
    });
	</script>
  </body>
</html>
