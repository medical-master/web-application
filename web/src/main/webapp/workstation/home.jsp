<%@page import="com.medicalmaster.dal.WorkstationViewPojoPojo"%>
<%@page import="com.medicalmaster.dal.Workstation"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.web.view.workstation.WorkstationView"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
	WorkstationView workstationView = new WorkstationView(request,response);
	List<WorkstationViewPojoPojo> workstationList = workstationView.displayWorkstations();
	request.setAttribute("workstationList",workstationList);
%>
<div class="container">
	<c:forEach items="${workstationList}" var="workstation">
		<div class="col-md-6">
			<div class="thumbnail">
				<img src="resources/images/yushengyuan.png" alt="${workstation.wksName}">
				<div class="caption">
					<h3>
						<span class="badge">2</span> ${workstation.wksName}
					</h3>
					<p>${workstation.hospitalName}${workstation.department}</p>
					<p>${workstation.pte}</p>
					<p />
					<p>访问量：</p>
					成员总数：${workstation.members}
					<p>${workstation.description}</p>
					<p>
						<a href="#" class="btn btn-primary" role="button">申请加入</a>
						&nbsp;&nbsp;&nbsp; <a href="action?view=workstation/workstationInfo&id=${workstation.workstationId}"
						 class="btn btn-primary" role="button">详细信息</a>
					</p>
				</div>
			</div>
		</div>
	</c:forEach>
</div>
