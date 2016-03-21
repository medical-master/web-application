<%@page pageEncoding="UTF-8"%>
      <form class="form" action="action" method="post">
        <div class="form-group">
          <label for="usernameInput">用户名</label>
          <input type="text" class="form-control" id="usernameInput" name="name" placeholder="用户名">
        </div>
        <div class="form-group">
          <label for="passwordInput">密码</label>
          <input type="password" class="form-control" id="passwordInput" name="password" placeholder="密码">
        </div>
        <input type="hidden" name="action" value="login">
        <input type="hidden" name="module" value="user">
        <button type="submit" class="btn btn-default">登录</button>
      </form>