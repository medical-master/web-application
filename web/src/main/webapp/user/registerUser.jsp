<%@page pageEncoding="UTF-8"%>
      <form action="action" method="post">
        <div class="form-group">
          <label for="userNameInput">用户名</label>
          <input type="text" class="form-control" id="userNameInput" name="name" placeholder="用户名">
        </div>
        <div class="form-group">
          <label for="mobileInput">手机号</label>
          <input type="text" class="form-control" id="mobileInput" name="mobilePhoneNumber" placeholder="手机号">
        </div>
        <div class="form-group">
          <label for="emailInput">邮件</label>
          <input type="email" class="form-control" id="emailInput" name="email" placeholder="abc@example.com">
        </div>
        <div class="form-group">
          <label for="password Input">密码</label>
          <input type="password" class="form-control" id="passwordInput" name="password" placeholder="密码">
        </div>
        <div class="form-group">
          <label for="passwordConfirmInput">密码确认</label>
          <input type="password" class="form-control" id="passwordConfirmInput" name="passwordConfirm" placeholder="密码确认">
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios0" name="type" value="NORMAL" checked>用户</label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios1" name="type" value="GENERALIST">全科医生</label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" id="optionsRadios2" name="type" value="SPECIALIST">专科医生</label>
        </div>
        <input type="hidden" name="action" value="register">
        <input type="hidden" name="module" value="user management">
        <button type="submit" class="btn btn-default">提交</button>
      </form>
 