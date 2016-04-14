<%@page import="com.medicalmaster.web.helper.PaginationHelper"%>
<%@page import="com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfosResponse"%>
<%@page import="com.medicalmaster.common.helper.HospitalHelper"%>
<%@page import="com.medicalmaster.dal.DiagPlanViewPojo"%>
<%@page import="com.medicalmaster.common.helper.ParseHelper"%>
<%@page import="org.apache.commons.lang.time.DateFormatUtils"%>
<%@page import="org.apache.commons.lang.time.DateUtils"%>
<%@page import="java.util.List"%>
<%@page import="com.medicalmaster.web.view.diagnostic.DiagHomeView"%>
<%@page pageEncoding="UTF-8"%>


<%DiagHomeView view = new DiagHomeView(request, response); %>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<img alt="医大师云平台" width="100%"
				src="resources/images/diagnostic/diagnostic-bar.png" />
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>临床诊疗方案名称</th>
						<th>制定专家</th>
						<th>所属医院名称</th>
						<th>发布时间</th>
						<th>访问次数</th>
					</tr>
				</thead>
				<%QueryDiagPlanInfosResponse infosResponse = view.getDiagPlanInfos(); %>
				<%if(infosResponse.isSuccess()){ %>
				<tbody>
					<%List<DiagPlanViewPojo> pojos = infosResponse.getPojos(); %>
					<%if(pojos != null && pojos.size() > 0) {%>
						<%for(DiagPlanViewPojo pojo : pojos){ %>
						<tr>
							<td><%=pojo.getTitle() %></td>
							<td><%=pojo.getName() %></td>
							<td><%=HospitalHelper.getName(pojo.getHosptialId())%></td>
							<td><%=ParseHelper.formateTimestamp(pojo.getPublishTime(), "yyyy-MM-dd")%></td>
							<td><%=ParseHelper.formateNumber(pojo.getVisitCnt()) %>次</td>
						</tr>
						<%} %>
					<%} %>
				</tbody>
				<%} %>
			</table>
			<%=PaginationHelper.getPaginationHtml(infosResponse, "action?view=diagnosis/home") %>
		</div>
	</div>
</div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/nav_menu.js"></script>
<script>
	navMenuChange("nav_diagnostic");
</script>
<script src="resources/js/pagination.js"></script>