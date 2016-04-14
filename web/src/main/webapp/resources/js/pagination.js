$(window).load(function() {
	$(".pagination > li > a").each(function(index) {
		$(this).on("click", function(e) {
			if($(e.target).hasClass("active")){
				return;
			}
			var _text = $(e.target).text();
			var _form = $("#form_pagination");			
			$("#pageNo").val(_text);
			_form.submit();
		});
	});
})