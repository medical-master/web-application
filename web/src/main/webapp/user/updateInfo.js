//用户个人资料修改
$(document).ready(function(){
	$("#educationLevel").select2({
		  placeholder: "学历水平",
		  allowClear: true
		});
	$("#professionalRank").select2({
		  placeholder: "职称",
		  allowClear: true
		});
	$("#sex").select2({
		  placeholder: "性别",
		  allowClear: true
		});
	
	$("#hosptialId").select2({
		  placeholder: "所属医院",
		  allowClear: true
		});
});