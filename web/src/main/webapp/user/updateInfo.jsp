<%@page import="com.medicalmaster.web.bean.WebConstants"%>
<%@page import="com.medicalmaster.dal.User"%>
<%@taglib prefix="hst" uri="http://java.sun.com/jsp/eds/hospital"%>
<%@taglib prefix="spt" uri="http://java.sun.com/jsp/eds/sysproperty"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getServletContext().getContextPath();
%>

<!DOCTYPE html>
<html lang="zh-CN">
<jsp:include page="/header.jsp" flush="true" />
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/css/select2.min.css" rel="stylesheet" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.2/js/select2.min.js"></script>
<script src="updateInfo.js"></script>

<body>
	<form action="<%=path %>/action" method="post">
		<div class="form-group">
			<label for="name">姓名 </label>
			<input type="text" class="form-control"
				id="name" name="name" disabled="disabled" value="${_USER.name}">
		</div>
		<div class="form-group">
			<label for="nickName">昵称</label> <input type="text"
				class="form-control" id="nickName" name="nickName"
				placeholder="请输入昵称" value="${_USER.nickName }">
		</div>
		<div class="form-group">
			<label for="mobilePhoneNumber">手机号</label> <input type="text"
				class="form-control" id="mobilePhoneNumber" name="mobilePhoneNumber"
				placeholder="请输入手机号" value="${_USER.mobilePhoneNumber}">
		</div>
		<div class="form-group">
			<label for="email">邮件</label> <input type="email"
				class="form-control" id="email" name="email" placeholder="邮件"
				value="${_USER.email}">
		</div>
		<div class="form-group">
			<label for="hosptialId">医院</label> <input type="text"
				class="form-control" id=hosptialId name="hosptialId"
				placeholder="医院" value="${_USER.hosptialId}">
		</div>
		<div class="form-group">
			<label for="department">部门</label> <input type="text"
				class="form-control" id="department" name="department"
				placeholder="部门" value="${_USER.department}">
		</div>
		<div class="form-group">
			<label for="educationLevel">学历</label>
			 <spt:select selectedId="${_USER.educationLevel }" name="educationLevel" categoryId="13" id="educationLevel"></spt:select>
		</div>
		<div class="form-group">
			<label for="professionalRank">职称</label> 
			<spt:select selectedId="${_USER.professionalRank }" name="professionalRank" categoryId="20" id="professionalRank"></spt:select>
		</div>
		<div class="form-group">
			<label for="title">职务</label> <input type="text" class="form-control"
				id="title" name="title" placeholder="职务" value="${_USER.title}">
		</div>
		<div class="form-group">
			<label for="identityNumber">身份证号</label> <input type="text"
				class="form-control" id="identityNumber" name="identityNumber"
				placeholder="身份证号" value="${_USER.identityNumber}">
		</div>
		<div class="form-group">
			<label for="doctorNumber">执业医师资格证号</label> <input type="text"
				class="form-control" id="doctorNumber" name="doctorNumber"
				placeholder="执业医师资格证号" value="${_USER.doctorNumber}">
		</div>
		<div class="form-group">
			<label for="sex">性别</label>
			<spt:select selectedId="${_USER.sex }" name="sex" categoryId="10" id="sex"></spt:select>			 
		</div>

		<input type="hidden" name="userid" value="${_USER.userId}"> <input
			type="hidden" name="action" value="update"> <input
			type="hidden" name="module" value="user">

		<button type="submit" class="btn btn-primary btn-lg">修    改</button>
	</form>
</body>
</html>