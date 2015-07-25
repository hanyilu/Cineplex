function showAgeChart(month) {
	if($('#ageChart1').html() != "") return;
	$.getJSON("memberAgeChart.action?month="+month, function(data) {
		var count = new Array();
		$.each(data.ageCount,function(i, c){
			count[i] = c;
		});
		var percent = new Array();
		$.each(data.agePercent,function(i, p){
			percent[i] = p;
		});
		var cate = new Array();
		$.each(data.ageCate,function(i, t){
			cate[i] = t;
		});
		var percentDate = new Array();
		for(var j = 0; j<5; j++) {
			percentDate[j] = [cate[j],percent[j]];
		}
		
		$('#ageChart1').highcharts({
	        chart: {
	            type: 'column',
	            margin: [ 50, 50, 100, 80]
	        },
	        title: {
	            text: '会员年龄及各年龄段百分比'
	        },
	        xAxis: {
	            categories: cate,
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '人数 '
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '人数: <b>{point.y:.1f} 人</b>',
	        },
	        series: [{
	            name: 'Population',
	            data: count,
	            dataLabels: {
	                enabled: true,
	                rotation: 0,
	                color: '#ffffff',
	                align: 'center',
	                x: 0,
	                y: 20,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif',
	                    textShadow: '0 0 3px black'
	                }
	            }
	        }]
	    });
		
		createPie("ageChart2", "", percentDate);
	});
}

function showGenderChart(month) {
	if($('#genderChart').html() != "") return;
	$.getJSON("memberGenderChart.action?month="+month, function(data) {
		var percentDate = new Array();
		var index = 0;
		$.each(data.gender,function(key,value){
			percentDate[index] = [key, value];
            index++;
        });
		
		new Highcharts.Chart({
	        chart: {
	            renderTo: 'genderChart',
	            type: 'pie'
			    },
	        title :{
	            text:'会员性别比例'
	        },
	        tooltip: {
	    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	        },
	        plotOptions: {
	            pie: {
	                startAngle: -90,
	                endAngle:90,  
	                center: ['50%', '70%'],
	                dataLabels: {
	                    enabled: true,
	                    color: '#000000',
	                    connectorColor: '#000000',
	                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
	                }
	            }
	        },
	        series: [{
	        	name: '百分比',
	            data: percentDate
	        }]
	    });
	});
}

function showAddressChart(month) {
	if($('#addressChart').html() != "") return;
	$.getJSON("memberAddressChart.action?month="+month, function(data) {
		var percentDate = new Array();
		var index = 0;
		$.each(data.address,function(key,value){
			percentDate[index] = [key, value];
            index++;
        });
		createPie("addressChart", "会员居住地分布", percentDate);
	});
}

function showCardStateChart(month) {
	if($('#cardStateChart').html() != "") return;
	$.getJSON("memberCardStateChart.action?month="+month, function(data) {
		var percentDate = new Array();
		var index = 0;
		$.each(data.cardState,function(key,value){
			percentDate[index] = [key, value];
            index++;
        });
		createPie("cardStateChart", "会员卡状态情况", percentDate);
    });
}

function showSalesChart(month) {
	if($('#salesChart').html() != "") return;
	$.getJSON("filmSalesChart.action?month="+month, function(data) {
		var count = new Array();
		var cate = new Array();
		var index = 0;
		$.each(data.filmSales,function(key,value){
			count[index] = value;
			cate[index] = key;
            index++;
        });
		
		$('#salesChart').highcharts({
	        chart: {
	            type: 'column',
	            margin: [ 50, 50, 100, 80]
	        },
	        title: {
	            text: '电影总消费分布'
	        },
	        xAxis: {
	            categories: cate,
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '人民币（元）'
	            }
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            pointFormat: '人民币: <b>{point.y:.1f} 元</b>',
	        },
	        series: [{
	            name: 'Population',
	            data: count,
	            dataLabels: {
	            	enabled: true,
	                rotation: 0,
	                color: '#ffffff',
	                align: 'center',
	                x: 0,
	                y: 20,
	                style: {
	                    fontSize: '13px',
	                    fontFamily: 'Verdana, sans-serif',
	                    textShadow: '0 0 3px black'
	                }
	            }
	        }]
	    });
	});
}

function showQuestionChart(items) {
	$("#activityCharts .tab-pane").hide();
	$("#film"+items).show();
	$("#filmTabs li").removeClass("active");
	$("#li"+items).addClass("active");
	if($("#film"+items).html() != "") return;
	$.getJSON("questionChart.action?items="+items, function(data) {
		$.each(data.question,function(key,question){
			var id = items+"q"+key;
			var title = question.content;
			$("#film"+items).append($("<div style='width:498px;'><h4>● "+title+"</h4></div>"));
			$("#film"+items).append($("<div style='width:498px;margin-bottom:25px;' id='"+id+"'></div>"));
			var percentDate = new Array();
			$.each(question.answers,function(i,answer){
				percentDate[i] = [answer.answer,answer.count];
			});
			createPie(id, "", percentDate);
        });
	});
}

function showPersonCountChart(month){
	if($('#personCountChart').html() != "") return;
	$.getJSON("personCountChart.action?month="+month, function(data) {
		var monthCount = data.personMonthCount;
		var count = new Array();
		var cate = new Array();
		var index = 0;
		$.each(data.personDayCount,function(key,value){
			count[index] = value;
			cate[index] = key;
            index++;
        });
		
		$('#personCountChart').highcharts({
	        title: {
	            text: '日总人数折线统计图',
	            x: -20 //center
	        },
	        subtitle: {
	            text: '月总人数：'+monthCount,
	            x: -20
	        },
	        xAxis: {
	        	title: {
	                text: '日期'
	            },
	            categories: cate
	        },
	        yAxis: {
	            title: {
	                text: '人数 (人)'
	            },
	            plotLines: [{
	                value: 0,
	                width: 1,
	                color: '#808080'
	            }]
	        },
	        legend: {
	            enabled: false
	        },
	        tooltip: {
	            valueSuffix: '人'
	        },
	        series: [{
	        	name:"人数",
	            data: count
	        }]
	    });
	});
}

function showRoomChart(month){
	if($('#roomChart').html() != "") return;
	$.getJSON("roomChart.action?month="+month, function(data) {
		var datas = new Array();
		var cate = new Array();
		var index = 0;
		$.each(data.room,function(key,value){
			datas[index] = value;
			cate[index] = key;
            index++;
        });
	    $('#room').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '各厅上座率'
	        },
	        xAxis: {
	        	title: {
	                text: '厅号'
	            },
	            categories: cate
	        },
	        yAxis: {
	            title: {
	                text: '上座率(%)'
	            }
	        },
	        legend: {
		            enabled: false
		        },
	        plotOptions: {
	            column: {
	                dataLabels: {
	                    enabled: true,
	                    style: {
	                        fontWeight: 'bold'
	                    },
	                    format: '{point.y:.1f} %'
	                }
	            }
	        },
	        tooltip: {
		            pointFormat: '上座率: <b>{point.y:.1f} %</b>',
		        },
	        series: [{
	            name: '厅号',
	            data: datas
	        }],
	        exporting: {
	            enabled: false
	        }
	    });
	});
}

function showFilmChart(month){
	if($('#filmChart').html() != "") return;
	$.getJSON("filmChart.action?month="+month, function(data) {
		var datas = new Array();
		var cate = new Array();
		var index = 0;
		$.each(data.film,function(key,value){
			datas[index] = value;
			cate[index] = key;
            index++;
        });
	    $('#film').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '各电影上座率'
	        },
	        xAxis: {
	        	title: {
	                text: '电影名称'
	            },
	            categories: cate
	        },
	        yAxis: {
	            title: {
	                text: '上座率(%)'
	            }
	        },
	        legend: {
		            enabled: false
		        },
	        plotOptions: {
	            column: {
	                dataLabels: {
	                    enabled: true,
	                    style: {
	                        fontWeight: 'bold'
	                    },
	                    format: '{point.y:.1f} %'
	                }
	            }
	        },
	        tooltip: {
		            pointFormat: '上座率: <b>{point.y:.1f} %</b>',
		        },
	        series: [{
	            name: '电影名称',
	            data: datas
	        }],
	        exporting: {
	            enabled: false
	        }
	    });
	});
}

function showPayTypeChart(month) {
	if($('#payTypeChart').html() != "") return;
	$.getJSON("payTypeChart.action?month="+month, function(data) {
		var percentData = new Array();
		var index = 0;
		$.each(data.payType,function(key,value){
			percentData[index] = [key, value];
            index++;
        });
		createPie("payTypeChart", "购票方式统计", percentData);
	});
}


function createPie(id, title, percentData) {
    $('#'+id).highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false
        },
        title: {
            text: title
        },
        tooltip: {
    	    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
            pie: {
                allowPointSelect: true,
                cursor: 'pointer',
                dataLabels: {
                    enabled: true,
                    color: '#000000',
                    connectorColor: '#000000',
                    format: '<b>{point.name}</b>: {point.percentage:.1f} %'
                }
            }
        },
        series: [{
            type: 'pie',
            name: '百分比',
            data: percentData
        }]
    });
}