<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.dal.EdsUser"%>
<%
	EdsUser user = (EdsUser)session.getAttribute("user");
%>
      <form>
        <div class="form-group">
          <label for="unickNameInput"><%=user.getName()%></label>
        </div>
        <div class="form-group">
          <label for="nickName">昵称</label>
          <input type="text" class="form-control" id="nickName" name="nickName" 
          	<%if(user.getNickName() == null){%>placeholder="昵称"<% } else { %>value="<%=user.getNickName()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="mobileInput">手机号</label>
          <input type="text" class="form-control" id="mobileInput" name="mobilePhoneNumber"
          	<%if(user.getMobilePhoneNumber() == null){%>placeholder="手机号"<% } else { %>value="<%=user.getMobilePhoneNumber()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="emailInput">邮件</label>
          <input type="email" class="form-control" id="emailInput" name="email" 
         	<%if(user.getEmail() == null){%>placeholder="邮件"<% } else { %>value="<%=user.getEmail()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="hosptialId">医院</label>
          <input type="text" class="form-control" id=hosptialId name="hosptialId" 
          	<%if(user.getHosptialId() == null){%>placeholder="医院"<% } else { %>value="<%=user.getHosptialId()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="department">部门</label>
          <input type="text" class="form-control" id="department" name="department" 
          	<%if(user.getDepartment() == null){%>placeholder="部门"<% } else { %>value="<%=user.getDepartment()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="educationLevel">教育程度</label>
          <input type="text" class="form-control" id="educationLevel" name="educationLevel"
          	<%if(user.getEducationLevel() == null){%>placeholder="教育程度"<% } else { %>value="<%=user.getEducationLevel()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="professionalRank">职称</label>
          <input type="text" class="form-control" id="professionalRank" name="professionalRank" 
          	<%if(user.getProfessionalRank() == null){%>placeholder="职称"<% } else { %>value="<%=user.getProfessionalRank()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="title">职务</label>
          <input type="text" class="form-control" id="title" name="title"
          	<%if(user.getTitle() == null){%>placeholder="职务"<% } else { %>value="<%=user.getTitle()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="identityNumber">证件号</label>
          <input type="text" class="form-control" id="identityNumber" name="identityNumber"
          	<%if(user.getIdentityNumber() == null){%>placeholder="证件"<% } else { %>value="<%=user.getIdentityNumber()%>"<% } %>>
        </div>
        <div class="form-group">
          <label for="doctorNumber">医师编号</label>
          <input type="text" class="form-control" id="doctorNumber" name="doctorNumber"
          	<%if(user.getDoctorNumber() == null){%>placeholder="医师编号"<% } else { %>value="<%=user.getDoctorNumber()%>"<% } %>>
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios0" name="sex" value="true" <%if(user.getSex() == null || user.getSex()){%>checked<% } %>>男性</label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios1" name="sex" value="false" <%if(user.getSex() != null && user.getSex() == false){%>checked<% } %>>女性</label>
        </div>
        <input type="hidden" name="userid" value="<%=user.getUserId()%>">
        <input type="hidden" name="action" value="update">
        <input type="hidden" name="module" value="user">
        
        <button type="submit" class="btn btn-default">提交</button>
      </form>
 