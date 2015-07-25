<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<title>售票</title>
  </head>
  
  <body>
  	<div class="row">
  		<div class="col-md-12 title inverse-title">
  			<span>售票</span>
  		</div>
  		<div class="col-md-12">
  			<hr>
  		</div>
  	</div>
  	<div class="row">
  		<div class="col-md-5 col-md-offset-1">
		  	<div class="list-group">
		  		<span class="list-group-item">电影</span>
				<s:iterator value="filmItems.keySet()" var="film">
					<a href="#" class="list-group-item" onclick="showItem(<s:property value="#film.id"/>)">
						<s:property value="#film.name" />
					</a>
				</s:iterator>
			</div>
		</div>
		<div class="col-md-5">
			<s:iterator value="filmItems.keySet()" var="film">
			  	<div class="list-group itemList" id="film<s:property value="#film.id"/>Item" style="display:none;">
			  		<span class="list-group-item">场次</span>
			  		<s:iterator value="filmItems.get(#film)" var="item">
			  			<a href="#" class="list-group-item" onclick="showSeats(<s:property value="#item.id"/>)">
			  				<s:property value="#item.duration"/>
			  				(厅<s:property value="#item.plan.roomId"/>)
			  			</a>
			  		</s:iterator>
				</div>
			</s:iterator>
		</div>
    </div>
    <div class="row">
    	<div class="col-md-8 col-md-offset-2">
		    <table class="table table-bordered table-condensed" id="seatTable" style="display:none;">
		  	</table>
		</div>
    </div>
	<div class="row" id="form" style="display:none;">
    	<div class="col-md-4 col-md-offset-4">
	    	<div class="form">
	    		<div class="form-group">
	    			<label id="amount"></label>
					<input type="text" class="form-control" placeholder="会员ID" id="mid" />
				</div>
				<div class="checkbox">
					<label>
						<input type="checkbox" name="crash">现金
					</label>
				</div>
				<button class="btn btn-info btn-block" onclick="sale()">确定</button>
			</div>
		</div>
    </div>
    <script type="text/javascript">
    	var pid = 0;
    	function showItem(id){
    		$("#amount").html("");
    		$(".itemList").hide();
    		$("#seatTable").hide();
    		$("#form").hide();
    		$("#film"+id+"Item").show();
    	}
    	
    	function showSeats(id){
    		$("#amount").html("");
    		$("#seatTable").html("");
    		$("#seatTable").show();
    		$("#form").show();
    		pid = id;
    		$.getJSON("loadSeatMap.action?pid="+id, function(data) {
				$.each(data.seats, function(i, row) {
					var tr = $("<tr></tr>");
					$("<th></th>").html((i+1)+"排").appendTo(tr);
					var seat = row.split("_");
					for(var j = 0; j < seat.length-1; j++) {
						var id = seat[j];
						if(id==0){
							$("<td></td>").html("已售").appendTo(tr);
						} else {
							var td = $("<td></td>");
							$("<input />",{type:"checkbox",val:id,name:"selectId",onclick:"amount("+data.itemPrice+")"}).appendTo(td);
							td.append(j+1);
							tr.append(td);
						}
					}
					$("#seatTable").append(tr);
		        });
		    });
    	}
    	
    	function sale(){
    		var mid = $("#mid").val()=="" ? "1" : $("#mid").val();
    		var selectIds = "";
    		$("input[name='selectId']:checked").each(function(){    
				selectIds += $(this).val()+",";  
			});
			var crash = $("input[name='crash']").is(':checked') ? "1" : "0";
			location.href="sales.action?mid="+mid+"&pid="+pid+"&seats="+selectIds+"&crash="+crash;
    	}
    	
    	function amount(price){
    		var amount = $("input[name='selectId']:checked").length*price;
    		$("#amount").html("共"+amount+"元");
    	}
    </script>
  </body>
</html>