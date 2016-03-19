<%@page pageEncoding="UTF-8"%>
      <form class="form" action="action" method="post">
        <div class="form-group">
          <label for="nameInput">姓名</label>
          <input type="text" class="form-control" id="nameInput" name="name" placeholder="姓名">
        </div>
        <div class="form-group">
          <label for="emailInput">邮件</label>
          <input type="email" class="form-control" id="emailInput" name="email" placeholder="abc@example.com">
        </div>
        <input type="hidden" name="action" value="invite">
        <input type="hidden" name="module" value="user management">
        <button type="submit" class="btn btn-default">发送邀请</button>
      </form>