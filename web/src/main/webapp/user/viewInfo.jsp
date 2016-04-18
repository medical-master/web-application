<%@taglib prefix="hst" uri="http://java.sun.com/jsp/eds/hospital"%>
<%@taglib prefix="spt" uri="http://java.sun.com/jsp/eds/sysproperty"%>
<%@page import="com.medicalmaster.common.bean.ResourceConstants" %>
<%@page pageEncoding="UTF-8"%>

<%@page import="com.medicalmaster.dal.User"%>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="well well-lg">
				<div class="form-group">
					<label>姓名：</label>
					${_USER.name}
				</div>
				<div class="form-group">
					<label>昵称：</label>
					${_USER.nickName }
				</div>
				<div class="form-group">
					<label>手机号：</label>
					${_USER.mobilePhoneNumber}
				</div>
				<div class="form-group">
					<label>邮件：</label>
					${_USER.email}
				</div>
				<div class="form-group">
					<label>医院：</label>
					<hst:name id="${_USER.hosptialId}"/>
				</div>
				<div class="form-group">
					<label>部门：</label>
					${_USER.department }
				</div>
				<div class="form-group">
					<label>教育程度：</label>
					<spt:desc categoryId="13" propertyId="${_USER.educationLevel }"/>
				</div>
				<div class="form-group">
					<label>职称：</label>
					<spt:desc categoryId="20" propertyId="${_USER.professionalRank }"/>
				</div>
				<div class="form-group">
					<label>职务：</label>
					${_USER.title }
				</div>
				<div class="form-group">
					<label>证件号：</label>
					${_USER.identityNumber }
				</div>
				<div class="form-group">
					<label>医师编号：</label>
					${_USER.doctorNumber }
				</div>
				<div class="form-group">
					<label>性别：</label>
					<spt:desc categoryId="10" propertyId="${_USER.sex }"/>
				</div>
				
				<a href="action?view=user/updateInfo">更新信息</a>
			</div>
		</div>
	</div>
</div>

