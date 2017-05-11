$(document).ready(function() {
	var page = window.location.search.match(/start=(\d+)/);
	var count = 10;

	$("#pagination").page({
		pages : Math.ceil(pages / count),
		curr : page ? page[1] : 1,
		jump : window.location.href.split('?')[0] + "?start=%page%"
	});
})