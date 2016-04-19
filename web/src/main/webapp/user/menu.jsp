<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getServletContext().getContextPath();
%>
<!-- Bootstrap core CSS -->
<link rel="stylesheet"
	href="<%=path%>/resources/bootstrap/css/bootstrap.min.css">

<div class="container" >
	<ul class="nav nav-pills nav-stacked">
	  <li role="presentation"><a href="#">工作站管理</a></li>
	  <li role="presentation"><a href="#"  target="content">诊疗方案</a></li>
	  <li role="presentation"><a href="#"  target="content">临床研究</a></li>
	  <li role="presentation"><a href="#"  target="content">会议培训</a></li>
	  <li role="presentation"><a href="#"  target="content">工作站成员</a></li>
	  <li role="presentation" class="active"><a href="updateInfo.jsp" target="content">个人资料</a></li>
	  <li role="presentation"><a href="#"  target="content">修改密码</a></li>
	</ul>
</div>