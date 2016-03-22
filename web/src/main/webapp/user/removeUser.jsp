<%@page pageEncoding="UTF-8"%>
      <form class="form" action="action" method="post">
        <div class="form-group">
          <label for="usernameInput">用户ID</label>
          <input type="text" class="form-control" id="usernameInput" name="userId" placeholder="用户ID">
        </div>
        <input type="hidden" name="action" value="remove">
        <input type="hidden" name="module" value="user">
        <button type="submit" class="btn btn-default">删除</button>
      </form>