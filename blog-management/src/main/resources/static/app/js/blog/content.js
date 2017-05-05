$(document).ready(function() {
	 var editor = UE.getEditor('myue');
	$('#blog').validator({
		
		submit: function() {
			// 同步编辑器数据
		      editor.sync();
			var formValidity = this.isFormValid();
			if (formValidity) {
			   // 验证成功的逻辑
			    var $subbtn = $("#submitBtn");
			    $subbtn.button('loading');
			    var  param =$("#blog").serialize();
				$.post("/blog/content",param,function(data){
					if(data.result>0){
						window.location = "/blog/index";
					}else{
						alert("eee");
					}
				},"json");

			} else {
			    // 验证失败的逻辑
			}
			//阻止原生form提交
			return false;
		},
	    onValid: function(validity) {
	      $(validity.field).closest('.am-form-group').find('.am-alert').hide();
	    },

	    onInValid: function(validity) {
	      var $field = $(validity.field);
	      var $group = $field.closest('.am-form-group');
	      var $alert = $group.find('.am-alert');
	      // 使用自定义的提示信息 或 插件内置的提示信息
	      var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

	      if (!$alert.length) {
	        $alert = $('<div class="am-alert am-alert-danger"></div>').hide().
	          appendTo($group);
	      }

	      $alert.html(msg).show();
	    }
	  });
	
	
	 // 编辑器内容变化时同步到 textarea
	  editor.addListener('contentChange', function() {
	      editor.sync();

	       // 触发验证
	       $('[name=context]').trigger('change');
	  });
	
	/*$("#submit").on('click', function() {
		try {
			
			$('#blog').validator({
				  validate: function(validity) {
					  var  param =$("#blog").serialize();
						$.post("/blog/edit",param,function(data){
							if(data.result>0){
								window.location = "/blog/index";
							}else{
								alert("eee");
							}
						},"json");
				  }
			  }
			)
			
			
		} catch (e) {
			alert(e)
		}
			
	});*/
})