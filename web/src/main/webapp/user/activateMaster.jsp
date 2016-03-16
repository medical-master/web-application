<%@page pageEncoding="UTF-8"%>
      <form class="form" action="action" method="post">
        <div class="form-group">
          <label for="invitationInput">邀请码</label>
          <input type="text" class="form-control" id="invitationInput" name="invitionCode" placeholder="邀请码">
        </div>
        <div class="form-group">
          <label for="mobileInput">手机号</label>
          <input type="text" class="form-control" id="mobileInput" name="mobilePhoneNumber" placeholder="手机号">
        </div>
        <input type="hidden" name="action" value="activate master">
        <input type="hidden" name="domain" value="user management">
        <button type="submit" class="btn btn-default">提交</button>
      </form>
 