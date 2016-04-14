<%@page import="java.util.Date"%>
<%@page import="com.medicalmaster.web.helper.PaginationHelper"%>
<%@page import="com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsResponse"%>
<%@page import="com.medicalmaster.web.view.research.ResearchHomeView"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8"%>

<%ResearchHomeView view = new ResearchHomeView(request, response); %>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<img alt="临床研究" width="100%" src="resources/images/clinical_bar.png" />
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="page-header">
				<h1>
					<small>项目列表</small>
				</h1>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th width="70%">项目名称</th>
						<th width="30%" align="right">上传日期</th>
					</tr>
				</thead>
				<%QueryClinicalResearchsResponse researchsResponse = view.getResearchsResponse(); %>
				<%request.setAttribute("researchsResponse", researchsResponse); %>
				<c:if test="${researchsResponse.success}">				
				<tbody>
					<c:forEach items="${researchsResponse.researchs}" var="item">
					<tr>
						<td>${item.title }</td>
						<td>
							<fmt:formatDate value="${item.publishTime }" type="date"/>
						</td>
					</tr>		
					</c:forEach>		
				</tbody> 
				</c:if>
			</table>
			<%=PaginationHelper.getPaginationHtml(researchsResponse, "action?view=research/home") %>
		</div>
	</div>
</div>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/nav_menu.js"></script>
<script>
	navMenuChange("nav_clinical");
</script>
<script src="resources/js/pagination.js"></script>