<%@page import="com.medicalmaster.common.workstation.QueryWorkstationResponse"%>
<%@page import="com.medicalmaster.web.helper.PaginationHelper"%>
<%@page import="javax.mail.Header"%>
<%@page import="com.medicalmaster.web.helper.PaginationHelper"%>
<%@page import="com.medicalmaster.common.helper.HospitalHelper"%>
<%@page import="com.medicalmaster.common.helper.SysPropertyHelper"%>
<%@page import="com.medicalmaster.dal.WorkstationViewPojoPojo"%>
<%@page import="com.medicalmaster.dal.Workstation"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.web.view.workstation.WorkstationView"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	WorkstationView workstationView = new WorkstationView(request,response);
%>
<script>
	$(function() {
		$("#tabs1 a").click(function(e) {
			$(this).tab('show');
		});
		$("#tabs2 a").click(function(e) {
			$(this).tab('show');
		});
		$("#tabs3 a").click(function(e) {
			$(this).tab('show');
		});
	});
</script>
<%
	QueryWorkstationResponse workstationResponse = workstationView.displayWorkstations();
	request.setAttribute("workstationResponse",workstationResponse);
%>
<c:if test="${workstationResponse.isSuccess()}">
	<c:if test="${workstationResponse.getPojos() != null && workstationResponse.getPojos().size() >0}">
		<div class="container">
			<c:forEach items="${workstationResponse.getPojos()}" var="workstation">
				<div class="col-md-6">
					<div class="thumbnail">
						<img src="resources/images/yushengyuan.png" alt="${workstation.wksName}">
						<div class="caption">
							<h3>
								<span class="badge">2</span> ${workstation.wksName}
							</h3>
							<p>
								<c:set var="hosptialId" value="${workstation.hosptialId}" scope="page"></c:set>
								<%=HospitalHelper.getName((Integer)pageContext.getAttribute("hosptialId"))%>
							</p>
							<p>
								<c:set var="professionalRank" value="${workstation.professionalRank}" scope="page"></c:set>
								<%=SysPropertyHelper.getDesc(26, (Integer)pageContext.getAttribute("professionalRank"))%>、
								${workstation.title}、
								<c:set var="educationLevel" value="${workstation.educationLevel}" scope="page"></c:set>
								<%=SysPropertyHelper.getDesc(13, (Integer)pageContext.getAttribute("educationLevel"))%>
							<p />
							<p>访问量：${workstation.visitCnt}</p>
							成员总数：${workstation.members}
							<p>${workstation.summery}</p>
							<p>
								<a href="#" class="btn btn-primary" role="button">申请加入</a>
								&nbsp;&nbsp;&nbsp; <a href="action?view=workstation/workstationInfo&id=${workstation.workstationId}&uid=${workstation.userId}"
								 class="btn btn-primary" role="button">详细信息</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<%=PaginationHelper.getPaginationHtml(workstationResponse, "action?view=workstation/home","paginationTwo.html") %>
	</c:if>
</c:if>
<script>
	navMenuChange("nav_workstation");
</script>
<script src="resources/js/pagination.js"></script>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/nav_menu.js"></script>

