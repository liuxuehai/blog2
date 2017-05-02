$(document).ready(function() {
	$('#blog').DataTable({
		"iDisplayLength" : 20,// 默认每页数量
		"bPaginate" : true, // 翻页功能
		"bLengthChange" : false, // 改变每页显示数据数量
		"bFilter" : false, // 过滤功能
		"ordering" : false,
		"bSort" : false, // 排序功能
		"bInfo" : true,// 页脚信息
		"bAutoWidth" : true,// 自动宽度
		"stateSave" : true,
		"retrieve" : true,
		"processing" : true,
		"serverSide" : true,
		"bPaginate" : true,
		"jQueryUI" : true,
		"searching" : false,
		"pagingType" : "full_numbers",
		// "bProcessing": true//服务器端进行分页处理的意思
		ajax : {
			"url" : "../blog/list",
			"data" : function(d) {
				//d.myKey = "myValue";
				// d.custom = $('#myInput').val();
			}
		},
		columns : [
			CONSTANT.DATA_TABLES.COLUMN.CHECKBOX,
			 {
			"data" : "id"
		}, {
			"data" : "title"
		}, {
			"data" : "category"
		}, {
			"data" : "author"
		}, {
			"data" : "postDate",
			"render": function(data, type, row) {
                return getDate(data);
            }
		}, {
			"data" : "status",
			"render": function(data, type, row) {
				var text=data;
				if(data==0){
					text="未审核";
				}else if(data==1){
					text="已审核";
				}else if(data==2){
					text="已删除";
				}
                return text;
            }
		} , {
			"data" : "status"
		} ]
		,  
        drawCallback : function() {  
            // 取消全选  
            $(":checkbox[name='groupCheck']").prop('checked', false);  
        }

	});
	
	$('.am-form').on("change", ":checkbox", function() {  
        // 列表复选框  
        if ($(this).is("[name='groupCheck']")) {  
            // 全选  
            $(":checkbox").prop("checked",$(this).prop("checked"));  
        }else{  
            // 一般复选  
            var checkbox = $("tbody :checkbox");  
            $(":checkbox[name='groupCheck']").prop('checked', checkbox.length == checkbox.filter(':checked').length);  
        }  
    })

	$('#add').on('click', function() {
		window.location = "/blog/edit"
	});
	
	$('#edit').on('click', function() {
		var checkbox = $("tbody :checkbox"); 
		if(checkbox.filter(':checked').length<=0){
			alert("请选择一项进行修改")
			return;
		}
		var id=checkbox.filter(':checked')[0].value;
		window.location = "/blog/edit?id="+id;
	});
	
	$('#approve').on('click', function() {
		var checkbox = $("tbody :checkbox"); 
		if(checkbox.filter(':checked').length<=0){
			alert("请选择一项进行修改")
			return;
		}
		
		try {
			var data="";
			for(var i=0;i<checkbox.filter(':checked').length;i++){
				data+=checkbox.filter(':checked')[i].value+",";
			}
			var  param ={};
			param["data"]=data.substring(0,data.length-1);
			$.post("/blog/approve",param,function(data){
				if(data.result>0){
					window.location = "/blog/index";
				}else{
					alert("eee");
				}
			},"json");
			
		} catch (e) {
			alert(e)
		}
	});
	
	$('#delete').on('click', function() {
		var checkbox = $("tbody :checkbox"); 
		if(checkbox.filter(':checked').length<=0){
			alert("请选择一项进行修改")
			return;
		}
		
		try {
			var data="";
			for(var i=0;i<checkbox.filter(':checked').length;i++){
				data+=checkbox.filter(':checked')[i].value+",";
			}
			var  param ={};
			param["data"]=data.substring(0,data.length-1);
			$.post("/blog/delete",param,function(data){
				if(data.result>0){
					window.location = "/blog/index";
				}else{
					alert("eee");
				}
			},"json");
			
		} catch (e) {
			alert(e)
		}
	});
	
	

});