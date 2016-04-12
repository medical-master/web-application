
function navMenuChange (menuId) {
	$(".navigation > li").each(function(index){
			if($(this).attr("id") == menuId){
				$(this).addClass("active");
			}else{
				$(this).removeClass("active");
			}
		}
	);
}
