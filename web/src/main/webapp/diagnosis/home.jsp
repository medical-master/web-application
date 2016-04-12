<%@page import="com.medicalmaster.common.helper.ParseHelper"%>
<%@page import="org.apache.commons.lang.time.DateFormatUtils"%>
<%@page import="org.apache.commons.lang.time.DateUtils"%>
<%@page import="com.medicalmaster.dal.DiagnosticPlanListPojo"%>
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
				<tbody>
					<%List<DiagnosticPlanListPojo> pojos = view.getDiagPlanInfos(1, 10); %>
					<%if(pojos != null && pojos.size() > 0) {%>
						<%for(DiagnosticPlanListPojo pojo : pojos){ %>
						<tr>
							<td><%=pojo.getTitle() %></td>
							<td><%=pojo.getName() %></td>
							<td><%=pojo.getHospitalName() %></td>
							<td><%=ParseHelper.formateTimestamp(pojo.getPublishTime(), "yyyy-MM-dd")%></td>
							<td><%=ParseHelper.formateNumber(pojo.getVisitCnt()) %>次</td>
						</tr>
						<%} %>
					<%} %>
				</tbody>
			</table>
			<nav align="right">
				<ul class="pagination">
					<li><a href="#" aria-label="Previous"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#" aria-label="Next"> <span
							aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/nav_menu.js"></script>
<script>
	navMenuChange("nav_diagnostic");
</script>