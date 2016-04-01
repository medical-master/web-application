<%@page pageEncoding="UTF-8"%>
<%@page import="com.medicalmaster.dal.User"%>
<div class="container-fluid" style="background-color: #e4e4e4;">
  <div class="row">
    <div class="col-md-6">
      <img alt="ImedMaster" width="150px" height="100px" style="
    margin-left: 40px;" src="resources/images/head-logo.png" />
    </div>
    <div class="col-md-6" style="margin-top:50px;">
      <form role="form">
        <div class="input-group" style="margin-right:40px;">
          <input type="text" class="form-control" placeholder="请输入专家姓名、地区、疾病、科室等关键词">
          <span class="input-group-btn">
            <button class="btn btn-default" type="button">
              <span class="glyphicon glyphicon-search"></span>
            </button>
          </span>
        </div>
      </form>
    </div>
  </div>
  <div class="row">
    <div class="col-md-12" >
      <nav class="navbar navbar-default">
        <div class="container">
          <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
              <li class="active">
                <a href="action?view=home">主页</a>
              </li>
              <li>
                <a href="action?view=workstation/home">专家工作站</a>
              </li>
              <li>
                <a href="action?view=diagnosis/home">诊疗方案</a>
              </li>
              <li>
                <a href="action?view=research/home">临床研究</a>
              </li>
              <li>
                <a href="action?view=training/home">教育培训</a>
              </li>
            </ul>
            <form class="navbar-form navbar-right" role="search">
              <div class="form-group">
                <%
  User user = session == null?null:(User)session.getAttribute("user");
%>
                <%if(user == null) {%>
                <a class="btn btn-primary" href="action?view=user/login">登录</a>
                <a class="btn btn-default" href="action?view=user/registerUser">注册</a>
                <% } else { %>
                <a class="btn btn-primary" href="action?view=user/viewInfo">
                  <%=user.getName()%></a>
                <a class="btn btn-default" href="action?module=user&action=logout">退出</a>
                <% } %>
            </form>
          </div>
        </div>
      </nav>
    </div>
  </div>
</div>