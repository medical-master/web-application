<%@page pageEncoding="UTF-8"%>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="action?view=home">医大师</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
           <li class="active"><a href="action?view=workstation/home">工作站</a></li>
            <li><a href="action?view=diagnosis/home">诊疗方案</a></li>
            <li><a href="action?view=research/home">临床研究</a></li>
            <li><a href="action?view=training/home">教育培训</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">系统维护 <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li role="separator" class="divider"></li>
                <li><a href="#">发布课题研究通知</a></li>
                <li><a href="#">发布课题研究模板</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="action?view=user/home">用户维护</a></li>
                <li><a href="#">工作站管理</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="#">在线留言管理</a></li>
                <li><a href="#">访问记录查看</a></li>
              </ul>
            </li>
          </ul>
          <form class="navbar-form navbar-right" role="search">
            <div class="form-group">
			  <a class="btn btn-primary" href="action?view=user/login">登录</a>
			  <a class="btn btn-default" href="action?view=user/registerUser">注册</a>
              <input type="text" class="form-control" placeholder="搜索">
            </div>
            <button type="submit" class="btn btn-default">确认</button>
          </form>
        </div><!--/.nav-collapse -->
      </div>
    </nav>