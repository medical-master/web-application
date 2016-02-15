<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h3>Insert People</h3>
<h4>Not supported for Ctrip Sql Server</h4>
<form action="resources/users" method="post">
    Name: <br/><input type="text" name="name" value="jerry"><br/>
    mobilePhoneNumber: <br/><input type="text" name="mobilePhoneNumber" value="111"><br/>
    email: <br/><input type="text" name="email" value="123@123.com"><br/>
    authentication: <br/><input type="text" name="authentication" value="adm123"><br/>
    type: <br/><input type="text" name="type" value="MASTER"><br/>
    <br/>
    Invocation mode<br/>
    <input type="radio" name="action" value="inviteMaster" checked="checked" />inviteMaster<br/>
    <input type="radio" name="action" value="register"/>register<br/>
    <input type="submit" value="submit"> <br/>
</form>
</body>
</html>