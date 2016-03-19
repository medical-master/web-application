<%@page pageEncoding="UTF-8"%>
      <form action="action" method="post">
        <div class="form-group">
          <label for="userNameInput">用户名</label>
          <input type="text" class="form-control" id="userNameInput" placeholder="用户名">
        </div>
        <div class="form-group">
          <label for="mobileInput">手机号</label>
          <input type="text" class="form-control" id="mobileInput" placeholder="手机号">
        </div>
        <div class="form-group">
          <label for="password Input">密码</label>
          <input type="password" class="form-control" id="passwordInput" placeholder="密码">
        </div>
        <div class="form-group">
          <label for="passwordConfirmInput">密码确认</label>
          <input type="password" class="form-control" id="passwordConfirmInput" placeholder="密码确认">
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="optionsRadios" id="optionsRadios0" value="user" checked>
                            用户
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="optionsRadios" id="optionsRadios1" value="generalist">
                            全科医生
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="optionsRadios" id="optionsRadios2" value="specialist">
                            专科医生
          </label>
        </div>
        <input type="hidden" name="action" value="register">
        <input type="hidden" name="module" value="user management">
        <button type="submit" class="btn btn-default">提交</button>
      </form>
 