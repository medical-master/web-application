<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.dal.EdsUser"%>
<%
	EdsUser user = (EdsUser)session.getAttribute("user");
%>
      <div class="form-group">
        <label for="unickNameInput"><%=user.getName()%></label>
      </div>
      <div class="form-group">
        <label for="nickName">昵称</label>
       	<%if(user.getNickName() == null){%>n/a<% } else { %><%=user.getNickName()%><% } %>
      </div>
      <div class="form-group">
        <label for="mobileInput">手机号</label>
       	<%if(user.getMobilePhoneNumber() == null){%>n/a<% } else { %><%=user.getMobilePhoneNumber()%><% } %>
      </div>
      <div class="form-group">
        <label for="emailInput">邮件</label>
       	<%if(user.getEmail() == null){%>n/a<% } else { %><%=user.getEmail()%><% } %>
      </div>
      <div class="form-group">
        <label for="hosptialId">医院</label>
       	<%if(user.getHosptialId() == null){%>n/a<% } else { %><%=user.getHosptialId()%><% } %>
      </div>
      <div class="form-group">
        <label for="department">部门</label>
       	<%if(user.getDepartment() == null){%>n/a<% } else { %><%=user.getDepartment()%><% } %>
      </div>
      <div class="form-group">
        <label for="educationLevel">教育程度</label>
       	<%if(user.getEducationLevel() == null){%>n/a<% } else { %><%=user.getEducationLevel()%><% } %>
      </div>
      <div class="form-group">
        <label for="professionalRank">职称</label>
       	<%if(user.getProfessionalRank() == null){%>n/a<% } else { %><%=user.getProfessionalRank()%><% } %>
      </div>
      <div class="form-group">
        <label for="title">职务</label>
       	<%if(user.getTitle() == null){%>n/a<% } else { %><%=user.getTitle()%><% } %>
      </div>
      <div class="form-group">
        <label for="identityNumber">证件号</label>
       	<%if(user.getIdentityNumber() == null){%>n/a<% } else { %><%=user.getIdentityNumber()%><% } %>
      </div>
      <div class="form-group">
        <label for="doctorNumber">医师编号</label>
        <%if(user.getDoctorNumber() == null){%>n/a<% } else { %><%=user.getDoctorNumber()%><% } %>
      </div>
      <div class="form-group">
        <label for="doctorNumber">性别</label>
        <%if(user.getSex() == null || user.getSex()){%>男性<% } else { %>女性<% } %>
      </div>

      <a href="action?view=user/updateInfo">更新信息</a>
 