function loadInfo() {
	$(".infoDiv").hide();
	var id=$("#mid").val();
	var type=$("#infoType option:selected").val();
	switch (type){
		case "1":
			$.getJSON("loadMemberInfo.action?mid="+id, function(data) {
				if(data.memberInfo == "" || id==1) {
					alert("id不存在");
				} else {
					var info = data.memberInfo.split("_");
					$("#memberId").html(info[0]);
					$("#memberName").html(info[1]);
					$("#memberGender").html(info[2]);
					$("#memberBirthday").html(info[3]);
					$("#memberAddress").html(info[4]);
					$("#memberLevel").html(info[5]);
					$("#memberCredit").html(info[6]);
					$("#memberBalance").html(info[7]);
					$("#memberStartTime").html(info[8]);
					var state={0:"未激活",1:"正常",2:"暂停",3:"失效",4:"取消"};
					$("#memberState").html(state[info[9]]);
				}
		    });
			break;
		case "2":
			$("#salesTable").html("");
			$.getJSON("loadMemberSalesInfo.action?mid="+id, function(data) {
				$.each(data.sales, function(i, sale) {
					var info = sale.split("_");
					var tr 	= $("<tr></tr>");
					for(var j = 0; j < info.length; j++) {
						tr.append($("<td></td>").html(info[j]));
					}
			        $("#salesTable").append(tr);
		        });
		    });
			break;
		case "3":
			$("#rechargesTable").html("");
			$.getJSON("loadMemberRechargesInfo.action?mid="+id, function(data) {
				$.each(data.recharges, function(i, recharge) {
					var info = recharge.split("_");
					var tr 	= $("<tr></tr>");
					for(var j = 0; j < info.length; j++) {
						tr.append($("<td></td>").html(info[j]));
					}
			        $("#rechargesTable").append(tr);
		        });
		    });
			break;
	}
	$("#info_"+type).show();
}