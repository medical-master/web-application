<%@page import="com.medicalmaster.dal.Workstation"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.web.view.workstation.WorkstationView"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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

<div class="row">
	<div class="col-md-3" align="left">
		<div class="span12">
			<img src="resources/images/yushengyuan.png" alt="${workstation.name}">
			<br/>
			<br/>
		</div>
		<div class="span12">
			<a href="#" class="btn btn-primary" role="button">申请加入</a><br/>
			申请加入大师团队，您将获得大师的宝贵学习资料、诊疗标准方案，并有机会一同参与科研课题论证。
			<br/>
			<br/>
		</div>
		<div class="span12">
			工作简历：<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			社会职责：<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			教育简介：<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
			19923-至今：芳芳第三方的时间浪费<br/>
		</div>
	</div>
	<div class="col-md-9">
		<h3 align="center">于生元工作站 </h3>
		成员数：&nbsp;&nbsp;&nbsp;&nbsp;访问量：
		<hr>
		关键字：
		<p>工作站简介:</p>
		<p>工作站详情：啥地方绝对是来访接待室路附近的说了句 我似懂非懂是欧文生栋覆屋万佛法师打发掉算了</p>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs1">
		        <li class="active"><a href="#tabs-1">简介</a></li>
		        <li><a href="#tabs-2">学术研究</a></li>
		        <li><a href="#tabs-3">成就荣誉</a></li>
		    </ul>
		    <div class="tab-content">
		    	<div class="tab-pane fade in active" id="tabs-1">
		            <ul>
		                <li><a href="#">从事临床工作20余年，擅长神经系统疾病的诊治，尤其是头面痛、眩晕的诊治，以及神经影像学诊断技术。</a></li>
		            </ul>
		        </div>
		        <div class="tab-pane" id="tabs-2">
		            <ul>
		                <li><a href="#">从WordPress看开源平台的发展</a></li>
		                <li><a href="#">jQuery 2.0 beta发布，不再支持IE6/7/8，jQuery 1.8、1.9与2.0特性概览</a></li>
		                <li><a href="#">一个简洁时尚的PSD登陆表单素材</a></li>
		            </ul>
		        </div>
		        <div class="tab-pane" id="tabs-3">
		            <p>今天是联合国妇女权益和国际和平日，又称“三八妇女节”。谷歌公司决定在这个特殊的日子为女性带来不一样的一天。据悉，谷歌公司专门为此举办了为期24小时的直播演讲活动--Voices Global Conference。该大会由全球科技女性（Global Tech Women）主办。</p>
		        </div>
		    </div>
		</div>
		
		<br/>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs2">
		        <li class="active"><a href="#tabs2-1">诊疗方案</a></li>
		    </ul>
		    <div class="tab-content">
		    	<div class="tab-pane fade in active" id="tabs2-1" >
		    		
		            <ul>
		                <li><a href="#">从WordPress看开源平台的发展</a></li>
		            </ul>
		            <ul>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
		            </ul>
		        </div>
		    </div>
		</div>
	
		<br/>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs3">
		        <li class="active"><a href="#tabs3-1">灵床研究</a></li>
		    </ul>
		    <div class="tab-content">
		    	<div class="tab-pane fade in active" id="tabs3-1" >
					<ul>
						<li><a href="#">脑卒中早期规范化治疗的多中心临床研究及疾病管理云平台建设</a></li>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
						<li><a href="#">体外血脂分离技术治疗急性缺血性卒中的治疗方案优化及机制研究</a></li>
						<li><a href="#">脑卒中早期规范化治疗的多中心临床研究及疾病管理云平台建设</a></li>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
					</ul>
				</div>
		    </div>
		</div>
		
		<br/>
		<div class="span12">
		    <ul class="nav-tabs nav" id="tabs4">
		        <li class="active"><a href="#tabs4-1">教育培训</a></li>
		    </ul>
		    <div class="tab-content">
		    	<div class="tab-pane fade in active" id="tabs4-1" >
		    		<br/>
		           	视频：<br/>
		           <ul>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
		            </ul>
					PPT：<br/>
					<ul>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
		            </ul>
		            PDF：<br/>
					<ul>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
		            </ul>
		            WORD：<br/>
		            <ul>
						<li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
			            <li><a href="#">原发性头痛诊疗规范与疾病管理的应用推广研究</a></li>
		            </ul>
		        </div>
		    </div>
		</div>
	</div>
</div>

