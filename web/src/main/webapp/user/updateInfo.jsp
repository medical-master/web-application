<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.dal.User"%>
<%
	User user = (User)session.getAttribute("user");
%>
      <form>
        <div class="form-group">
          <label for="unickNameInput"><%=user.getName()%></label>
        </div>
        <div class="form-group">
          <label for="nickName">昵称</label>
          <input type="text" class="form-control" id="nickName" name="nickName" value="<%=user.getNickName()%>">
        </div>
        <div class="form-group">
          <label for="mobileInput">手机号</label>
          <input type="text" class="form-control" id="mobileInput" name="mobilePhoneNumber" placeholder="手机号">
        </div>
        <div class="form-group">
          <label for="emailInput">邮件</label>
          <input type="email" class="form-control" id="emailInput" name="email" value="<%=user.getEmail()%>">
        </div>
        <div class="form-group">
          <label for="hosptialId">医院</label>
          <input type="text" class="form-control" id=hosptialId name="hosptialId" value="<%=user.getHosptialId()%>">
        </div>
        <div class="form-group">
          <label for="department">部门</label>
          <input type="text" class="form-control" id="department" name="department" value="<%=user.getDepartment()%>">
        </div>
        <div class="form-group">
          <label for="educationLevel">教育程度</label>
          <input type="text" class="form-control" id="educationLevel" name="educationLevel" value="<%=user.getEducationLevel()%>">
        </div>
        <div class="form-group">
          <label for="professionalRank">职称</label>
          <input type="text" class="form-control" id="professionalRank" name="professionalRank" value="<%=user.getProfessionalRank()%>">
        </div>
        <div class="form-group">
          <label for="title">职务</label>
          <input type="text" class="form-control" id="title" name="title" value="<%=user.getTitle()%>">
        </div>
        <div class="form-group">
          <label for="identityNumber">证件号</label>
          <input type="text" class="form-control" id="identityNumber" name="identityNumber" value="<%=user.getIdentityNumber()%>">
        </div>
        <div class="form-group">
          <label for="doctorNumber">医师编号</label>
          <input type="text" class="form-control" id="doctorNumber" name="doctorNumber" value="<%=user.getDoctorNumber()%>">
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios0" name="sex" value="true" checked>男性</label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios1" name="sex" value="false">女性</label>
        </div>
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="module" value="user management">
        
        <button type="submit" class="btn btn-default">提交</button>
      </form>
 