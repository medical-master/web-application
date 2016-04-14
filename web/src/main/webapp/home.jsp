<%@page import="com.medicalmaster.common.bean.SysCategoryConstants"%>
<%@page import="com.medicalmaster.common.helper.SysPropertyHelper"%>
<%@page import="com.medicalmaster.dal.Workstation"%>
<%@page import="com.medicalmaster.dal.DiagnosticPlan"%>
<%@page import="com.medicalmaster.dal.ClinicalResearch"%>
<%@page import="org.apache.commons.lang.time.DateFormatUtils"%>
<%@page import="com.medicalmaster.common.helper.PageHelper"%>
<%@page import="com.medicalmaster.dal.TrainMeeting"%>
<%@page import="com.medicalmaster.dal.Notice"%>
<%@page import="com.medicalmaster.web.view.HomeView"%>
<%@page import="java.util.List"%>
<%@taglib prefix="hst" uri="http://java.sun.com/jsp/eds/hospital" %>
<%@taglib prefix="spt" uri="http://java.sun.com/jsp/eds/sysproperty" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page pageEncoding="UTF-8"%>


<%HomeView view = new HomeView(request, response); %>

<div class="bannerBox clearfix">
	<div class="swiper-container text-center">
		<div class="swiper-wrapper">
			<div class="swiper-slide">
				<img src="resources/images/banner/banner-bg.png" />
			</div>
			<div class="swiper-slide">
				<img src="resources/images/banner/banner-bg.png" />
			</div>
			<div class="swiper-slide">
				<img src="resources/images/banner/banner-bg.png" />
			</div>
			<div class="swiper-slide">
				<img src="resources/images/banner/banner-bg.png" />
			</div>
			<div class="swiper-slide">
				<img src="resources/images/banner/banner-bg.png" />
			</div>
		</div>
		<!-- Add Pagination -->
		<div class="swiper-pagination"></div>
		<!-- Add Pagination -->
		<div class="swiper-button-next"></div>
		<div class="swiper-button-prev"></div>
	</div>
	<div class="bannerFooter text-right">
		<a href="##" class="online-service" title="在线服务"></a> <a href="##"
			class="about-us" title="关于我们"></a>
	</div>
</div>
<div class="container listInfo">
	<div class="row">
		<div class="col-sm-6">
			<div class="major-site">
				<h3 class="box-title">专家工作站</h3>
				<div class="decsc">
					介绍：专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是专家工作站是
				</div>
				<%List<Workstation> workstations = view.getWorkstations(); %>
				<%request.setAttribute("workstations", workstations); %>
				<c:if test="${workstations != null && workstations.size() > 0 }">
				<ul class="list-unstyled">
					<c:forEach var="workstation" items="${workstations}">				
					<li>
						<h3> ${workstation.name}</h3>
						<p class="area">
						<spt:desc categoryId="27" propertyId="${workstation.illCode}"></spt:desc>
						<p class="keywords">${workstation.keywords}</p>
					</li>
					</c:forEach>			
				</ul>
				</c:if>
				<div class="more pull-right"><a href="action?view=workstation/home">更多</a></div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="diagnose">
				<h3 class="box-title">临床诊疗标准</h3>
				<%List<DiagnosticPlan> plans = view.getDiagnosticPlans(); %>
				<%request.setAttribute("plans", plans); %>
				<c:if test="${plans != null && plans.size() > 0}">
					<ul class="list-unstyled">
						<c:forEach var="plan" items="${plans}">
							<li>
								<p class="list-text"><a href="##">${plan.title}</a></p>
							</li>					
						</c:forEach>
					</ul>
					<div class="more pull-right"><a href="action?view=diagnosis/home">更多</a></div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<!-- 临床研究 -->
<%List<ClinicalResearch> researchs = view.getClinicalResearchs(); %>
<%request.setAttribute("researchs", researchs); %>
<c:if test="${researchs != null && researchs.size() > 0}">
	<div class="scientific clearfix">
		<div class="list">
			<ul class="list-unstyled">
				<c:forEach var="research" items="${researchs}">
					<li><a href="##">${research.title}</a></li>
				</c:forEach>
			</ul>
		</div>
		<div class="imgFace pull-right">
			<img src="resources/images/pic-scientific.png">
		</div>
	</div>
</c:if>


<!-- 通知 -->
<%Notice notice = view.getLastedNotice(); %>
<%request.setAttribute("notice", notice); %>
<c:if test="${notice != null}">
	<div class="important">
	  <div class="im-content">
	    <div class="im-left">
	      <h1>${notice.title}</h1>
	      <h3>Important to Release</h3>
	      <p>我们秉承整合、开放、专业的宗旨，努 力提供国内最高效的第三方医疗资源技 术服务和大数据服务。</p>
	    </div>
	    <div class="im-right">
	      <p>${notice.content}</p>
	    </div>
	  </div>
	</div>
</c:if>

<!-- 培训会议 -->
<%List<TrainMeeting> meetings = view.getTrainMeetings(); %>
<%request.setAttribute("meetings", meetings); %>
<%if(meetings != null && meetings.size() > 0){ %>
<div class="notice">
	<div class="container">
		<h3 class="tit" title="会议通知"></h3>
		<div class="notice-swiper clearfix">
			<div class="swiper-wrapper clearfix">
				<%PageHelper<TrainMeeting> pageHelper=new PageHelper(meetings, 7); %>
				<%while(pageHelper.next()){ %>
				<%List<TrainMeeting> list = pageHelper.getCurrentList(); %>
				<div class="swiper-slide">
					<ul class="list-unstyled clearfix">
						<%for(TrainMeeting meeting : list){ %>
						<li><a href="#"> <span class="date pull-left"><%=DateFormatUtils.format(meeting.getMeetingTime(), "yyyy-MM-dd") %></span>
								<span class="infoList pull-left"><%=meeting.getContent() %></span>
						</a></li>						
						<%} %>
					</ul>
				</div>
				<%} %>
			</div>
			<!-- Add Pagination -->
			<div class="swiper-pagination text-right pull-right"></div>
		</div>
	</div>
</div>
<%} %>

<div class="more-education">
	<div class="container">
		<img class="img-title" src="resources/images/bottom.png" alt="">
		<div class="row">
			<di class="col-sm-3">
			<div class="card">
				<img src="resources/images/tips-1.png" class="tag-img">
				<h3 class="text-center">规划</h3>
				<div class="text-info">说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字</div>
			</div>
			</di>
			<di class="col-sm-3">
			<div class="card">
				<img src="resources/images/tips-2.png" class="tag-img">
				<h3 class="text-center">权威</h3>
				<div class="text-info">说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字</div>
			</div>
			</di>
			<di class="col-sm-3">
			<div class="card">
				<img src="resources/images/tips-3.png" class="tag-img">
				<h3 class="text-center">效率</h3>
				<div class="text-info">说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字</div>
			</div>
			</di>
			<di class="col-sm-3 ">
			<div class="card">
				<img src="resources/images/tips-4.png" class="tag-img">
				<h3 class="text-center">院校</h3>
				<div class="text-info">说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字说明文字</div>
			</div>
			</di>
		</div>
	</div>
</div>
<div class="codeBox">
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<div class="code-container">
					<img src="resources/images/code-1.png" alt="">
				</div>
			</div>
			<div class="col-sm-4">
				<div class="code-container">
					<img src="resources/images/code-2.png" alt="">
				</div>
			</div>
			<div class="col-sm-4">
				<div class="code-container">
					<img src="resources/images/code-3.png" alt="">
				</div>
			</div>
		</div>
	</div>
</div>
<script src="resources/js/swiper.min.js"></script>
<script>
	var banner = new Swiper('.swiper-container', {
		pagination : '.swiper-pagination',
		paginationClickable : true,
		nextButton : '.swiper-button-next',
		prevButton : '.swiper-button-prev',
		autoHeight : false, //enable auto height
	});

	var notice = new Swiper('.notice-swiper',
			{
				pagination : '.swiper-pagination',
				paginationClickable : true,
				paginationBulletRender : function(index, className) {
					return '<span class="' + className + '">' + (index + 1)
							+ '</span>';
				}
			});
</script>

<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/nav_menu.js"></script>
<script>
	navMenuChange("nav_home");
</script>