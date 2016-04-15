<%@page import="com.medicalmaster.dal.TrainMaterial"%>
<%@page import="org.apache.commons.lang.time.DateFormatUtils"%>
<%@page import="com.medicalmaster.common.helper.PageHelper"%>
<%@page import="com.medicalmaster.dal.TrainMeeting"%>
<%@page import="java.util.List"%>
<%@page import="com.medicalmaster.web.view.training.TrainHomeView"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8"%>

<%TrainHomeView view = new TrainHomeView(request, response); %>

<link rel="stylesheet" href="resources/css/swiper.min.css" />
<link rel="stylesheet" href="resources/css/index.css" />

<div class="container" >
	<div class="row clearfix">
		<img alt="教育培训" width="100%" src="resources/images/train_barne.png" />
	</div>
</div>	
<div class="container listInfo" >
	<div class="row clearfix">
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
	</div>
	
	<div class="row clearfix" >
		<div class="diagnose">
				<h3 class="box-title">培训/教育总站</h3>
				<%List<TrainMaterial> pojos = view.getTrainMaterial(); %>
				<%request.setAttribute("pojos", pojos); %>
				<c:if test="${pojos != null && pojos.size() > 0}">
					<ul class="list-unstyled">
						<c:forEach var="pojo" items="${pojos}">
							<li>
								<p class="list-text"><a href="##">${pojo.title}</a></p>
							</li>					
						</c:forEach>
					</ul>
				</c:if>
			</div>
	</div>
</div>	
<div class="container">	
	<div class="row clearfix">
		<img alt="教育培训" width="100%" src="resources/images/train_footer.png" />
	</div>
</div>
    
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="resources/js/nav_menu.js"></script>
<script>
	navMenuChange("nav_train");
</script>        

<script src="resources/js/swiper.min.js"></script>
<script>
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