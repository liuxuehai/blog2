$(document).ready(function() {
	
	$("#chn").on('click', function() {
		$("#blog-eng").css("display","none");
		$("#blog-chn").css("display","block");
		
		
		$("#chn").css("color","gray");
		$("#eng").css("color","#27ae60");
		$("#all").css("color","#27ae60");
		
		$("#blog-chn").css("width","100%");
		$("#blog-eng").css("width","100%");
		$(".blog-g-fixed").css("max-width","1200px");
		$(".blog-sidebar").css("display","block");
		$(".admin-content-body").parent().removeClass("am-u-md-12");
		$(".admin-content-body").parent().addClass("am-u-md-8");
	})
	
	$("#eng").on('click', function() {
		$("#blog-eng").css("display","block");
		$("#blog-chn").css("display","none");
		
		$("#chn").css("color","#27ae60");
		$("#all").css("color","#27ae60");
		$("#eng").css("color","gray");
		
		$("#blog-chn").css("width","100%");
		$("#blog-eng").css("width","100%");
		$(".blog-g-fixed").css("max-width","1200px");
		$(".blog-sidebar").css("display","block");
		$(".admin-content-body").parent().removeClass("am-u-md-12");
		$(".admin-content-body").parent().addClass("am-u-md-8");
	})
	$("#all").on('click', function() {
		
		$("#blog-eng").css("display","block");
		$("#blog-chn").css("display","block");
		$("#blog-chn").css("float","left");
		$("#blog-eng").css("float","right");
		$("#blog-chn").css("width","50%");
		$("#blog-eng").css("width","50%");
		
		$("#all").css("color","gray");
		$("#chn").css("color","#27ae60");
		$("#eng").css("color","#27ae60");
		
		$(".blog-g-fixed").css("max-width","1600px");
		
		$(".blog-sidebar").css("display","none");
		
		$(".admin-content-body").parent().removeClass("am-u-md-8");
		$(".admin-content-body").parent().addClass("am-u-md-12");
		
	})
})