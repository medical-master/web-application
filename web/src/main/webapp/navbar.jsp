<%@page import="com.medicalmaster.dal.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>
<div class="container">
	<div class="header clearfix">
		<div class="logo pull-left">
			<a href="##"></a>
		</div>
		<div class="search-box pull-right">
			<form action="###">
				<input type="text" class="search-keyword"
					placeholder="请输入专家姓名、地区、疾病、科室等关键词" />
				<button class="btn-search"></button>
			</form>
		</div>
	</div>
	<div class="nav">
		<ul class="list-inline navigation text-center">
			<li id="nav_home" class="active"><a href="action?view=home">主页</a></li>
			<li id="nav_workstation"><a href="action?view=workstation/home">专家工作站</a></li>
			<li id="nav_diagnostic"><a href="action?view=diagnosis/home">诊疗方案</a></li>
			<li id="nav_clinical"><a href="action?view=research/home">临床研究</a></li>
			<li id="nav_train"><a href="action?view=training/home">教育培训</a></li>
		</ul>
		<c:if test="${_USER  == null }">
			<div class="user-card">
				<div class="user-image pull-left">
					<a href="user/login.jsp"><img
						src="resources/images/user-icon-default.png" alt="" /></a>
				</div>
				<div class="user-info pull-right">
					<h3 class="title">我的工作站点</h3>
					<p class="tip-text">点击图像登录\注册</p>
				</div>
			</div>
		</c:if>
		<c:if test="${_USER != null }">
			<div class="user-card">
				<div class="user-image pull-left">
					<a href="action?jump=user/myprofile"><img
						src="resources/images/user-icon-default.png" alt="" /></a>
				</div>
				<div class="user-info pull-right">
					<h3 class="title">${_USER.name}</h3>
				</div>
			</div>
		</c:if>
	</div>
</div>