$(document).ready(function() {
	$('#menu').DataTable({
		"iDisplayLength" : 10,// 默认每页数量
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
			"url" : "../user/list",
			"data" : function(d) {
				//d.myKey = "myValue";
				// d.custom = $('#myInput').val();
			}
		},
		columns : [
			 {
			"data" : "id",
			"width": "20%"
		}, {
			"data" : "name",
			"width": "20%"
		}, {
			"data" : "phone",
		    "width": "10%"
		}, {
			"data" : "email",
			"width": "10%"
		}, {
			"data" : "role",
			"width": "10%"	
		}, {
			"data" : "qq",
			"width": "10%"	
		} , {
			"data" : "github",
			"width": "10%"	
		}   , {
			"data" : "id",
			orderable : false,  
            bSortable : false,
            render : function(data, type, row, meta) {  
                var content = ' <button type="button" class="am-btn am-btn-default" onclick="edit(\''+data+'\')" >  编辑</button>';
                content += ' <button type="button" class="am-btn am-btn-default" onclick="remove(\''+data+'\')" >  删除</button>';
                return content;  
            }
		} ]
		,  
        drawCallback : function() {  
           
        }

	});
	
	

	$('#add').on('click', function() {
		window.location = "/user/edit"
	});

	
	$('#delete').on('click', function() {
		var checkbox = $("tbody :checkbox"); 
		if(checkbox.filter(':checked').length<=0){
           AMUI.dialog.alert({ title: '错误提示', content: "请选择一项进行修改", onConfirm: function() { 
				
			} });
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
					AMUI.dialog.alert({ title: '错误提示', content: "修改失败", onConfirm: function() { 
						
					} });
				}
			},"json");
			
		} catch (e) {
           AMUI.dialog.alert({ title: '错误提示', content: e, onConfirm: function() { 
				
			} });
		}
	});
	


});

function edit(id){
	window.location = "/user/edit?id="+id;
}
function remove(id){
	window.location = "/user/edit?id="+id;
}

