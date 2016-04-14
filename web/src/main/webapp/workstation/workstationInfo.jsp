<%@page import="com.medicalmaster.dal.TrainMaterialViewPojoPojo"%>
<%@page import="com.medicalmaster.dal.UserMienViewPojo"%>
<%@page import="com.medicalmaster.web.view.user.UserView"%>
<%@page import="com.medicalmaster.dal.ClinicalResearch"%>
<%@page import="com.medicalmaster.dal.DiagnosticPlan"%>
<%@page import="com.medicalmaster.dal.Workstation"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.medicalmaster.web.view.workstation.WorkstationView"%>
<%@page import="com.medicalmaster.dal.WorkstationViewPojoPojo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
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
	String id = request.getParameter("id");
	String userId = request.getParameter("uid");
	WorkstationView workstationView = new WorkstationView(request,response);
	WorkstationViewPojoPojo workstationViewPojo = workstationView.getWorkstationInfo(id);
	List<DiagnosticPlan> diagnosticPlanList = workstationView.findWorkStationDiagnosticPlans(id);
	List<ClinicalResearch> clinicalResearchList = workstationView.getClinicalResearchs(id);
	UserView userView = new UserView(request,response);
	List<UserMienViewPojo> userMienList = userView.getUserMienInfo(userId);
	List<TrainMaterialViewPojoPojo> trainMeetingList = workstationView.getTrainMeetings(id);
	request.setAttribute("workstationViewPojo",workstationViewPojo);
	request.setAttribute("diagnosticPlanList",diagnosticPlanList);
	request.setAttribute("clinicalResearchList",clinicalResearchList);
	request.setAttribute("userMienList",userMienList);
	request.setAttribute("trainMeetingList",trainMeetingList);
%>
<c:if test="${workstationViewPojo!= null}">
<div class="row">
	<div class="col-md-3" align="left">
		<div class="span12">
			<img src="resources/images/yushengyuan.png" alt="${workstationViewPojo.wksName}" class="img-circle">
			<br/>
			<br/>
		</div>
		<div class="span12">
			<a href="#" class="btn btn-primary" role="button">申请加入</a><br/>
			<font color="red">申请加入大师团队，您将获得大师的宝贵学习资料、诊疗标准方案，并有机会一同参与科研课题论证。</font>
			<br/>
			<br/>
		</div>
		<div class="span12">
			<c:if test="${userMienList != null}">
				<div class="span12">
					工作简历：<br/>
				</div>
				<div class="span12">
					<c:forEach items="${userMienList}" var="userMien">
						<c:if test="${userMien.mienType == 20}">
							${userMien.begYear}年~${userMien.begYear}年：${userMien.description}<br/>
						</c:if>
					</c:forEach>
				</div>
				
				<div class="span12">
					<br/>
					社会职责：<br/>
				</div>
				<div class="span12">
					<c:forEach items="${userMienList}" var="userMien">
						<c:if test="${userMien.mienType == 60}">
							${userMien.description}<br/>
						</c:if>
					</c:forEach>
				</div>
				
				<div class="span12">
					<br/>
					教育简介：<br/>
				</div>
				<div class="span12">
					<c:forEach items="${userMienList}" var="userMien">
						<c:if test="${userMien.mienType == 10}">
							${userMien.begYear}年~${userMien.begYear}年：${userMien.description}<br/>
						</c:if>
					</c:forEach>
				</div>
			</c:if>
		</div>
	</div>
	<div class="col-md-9">
		<h3 align="center">${workstationViewPojo.wksName}</h3>
		成员数：${workstationViewPojo.members}&nbsp;&nbsp;&nbsp;&nbsp;访问量：
		<hr>
		关键字：${workstationViewPojo.keywords}
		<p>工作站简介：${workstationViewPojo.summery}</p>
		<p>工作站详情：${workstationViewPojo.description}</p>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs1">
		        <li class="active"><a href="#tabs-1">简介</a></li>
		        <li><a href="#tabs-2">学术研究</a></li>
		        <li><a href="#tabs-3">成就荣誉</a></li>
		    </ul>
		    <div class="tab-content">
		    	<div class="tab-pane fade in active" id="tabs-1">
		            <ul>
		                <li>${workstationViewPojo.expertArea}</li>
		            </ul>
		        </div>
		        <div class="tab-pane" id="tabs-2">
		            <ul>
						<c:forEach items="${userMienList}" var="userMien">
							<c:if test="${userMien.mienType == 40}">
								 <li>${userMien.description}</li>
							</c:if>
						</c:forEach>
		            </ul>
		        </div>
		        <div class="tab-pane" id="tabs-3">
		        	<ul>
			            <c:forEach items="${userMienList}" var="userMien">
							<c:if test="${userMien.mienType == 50}">
								<li>${userMien.begYear}年~${userMien.begYear}年：${userMien.description}<br/></li>
							</c:if>
						</c:forEach>
					</ul>
		        </div>
		    </div>
		</div>
		
		<br/>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs2">
		        <li class="active"><a href="#tabs2-1">诊疗方案</a></li>
		    </ul>
		    
		    <c:if test="${diagnosticPlanList !=null && diagnosticPlanList.size() !=0 }">
			    <div class="tab-content">
			    	<div class="tab-pane fade in active" id="tabs2-1" >
			            <ul>
			            	<c:forEach items="${diagnosticPlanList}" var="diagnosticPlanList">
								<li><a href="#">${diagnosticPlanList.title}</a></li>
				            </c:forEach>
			            </ul>
			        </div>
			    </div>
		    </c:if>
		</div>
	
		<br/>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs3">
		        <li class="active"><a href="#tabs3-1">临床研究</a></li>
		    </ul>
			<c:if test="${clinicalResearchList !=null && clinicalResearchList.size() !=0 }">
			    <div class="tab-content">
			    	<div class="tab-pane fade in active" id="tabs3-1" >
			            <ul>
			            	<c:forEach items="${clinicalResearchList}" var="clinicalResearchList">
								<li><a href="#">${clinicalResearchList.title}</a></li>
				            </c:forEach>
			            </ul>
			        </div>
			    </div>
		    </c:if>
		</div>
		
		<br/>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs4">
		        <li class="active"><a href="#tabs4-1">教育培训</a></li>
		    </ul>
		    <div class="tab-content">
		    	<div class="tab-pane fade in active" id="tabs4-1" >
		    		<c:if test="${trainMeetingList !=null && trainMeetingList.size()!=0}">
		    			<c:forEach items="${trainMeetingList }" var="trainMeeting">
							<ul>
								<li><a href="#">${trainMeeting.title}</a></li>
					        </ul>
		    			</c:forEach>
		    		</c:if>
		        </div>
		    </div>
		</div>
	</div>
</div>
</c:if>
