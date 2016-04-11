<%@page import="com.medicalmaster.dal.Workstation"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.web.view.workstation.WorkstationView"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	WorkstationView workstationView = new WorkstationView(request,response);
	List<Workstation> workstationList = workstationView.displayWorkstations();
%>
<div class="container">
	<c:forEach items="${workstationList}" var="workstation">
		<div class="col-md-6">
			<div class="thumbnail">
				<img src="resources/images/yushengyuan.png" alt="${workstation.name}">
				<div class="caption">
					<h3>
						<span class="badge">2</span> ${workstation.name}
					</h3>
					<p>解放军总医院神经内科</p>
					<p>主任医生、教授、博士生导师</p>
					<p />
					<p>访问量：</p>
					成员了数：
					<p>${workstation.description}</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">申请加入</a>
						&nbsp;&nbsp;&nbsp; <a href="action?view=workstation/workstationInfo" class="btn btn-primary" role="button">详细信息</a>
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
