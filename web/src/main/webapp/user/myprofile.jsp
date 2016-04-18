<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getServletContext().getContextPath();
%>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<%=path%>/resources/images/ico.png">

<title>医大师-用户自管理</title>
</head>

<frameset rows="100px,90%,60px" border="1" bordercolor="#2d8cfb">
	<frame src="user/header.jsp" noresize="noresize">
	<frameset cols="200px,80%" border="0" bordercolor="#2d8cfb">
		<frame src="user/menu.jsp" scrolling="auto" noresize="noresize">
		<frame src="user/updateInfo.jsp" scrolling="auto"name="content"  >
	</frameset>
	<frame src="user/footer.jsp" noresize="noresize">
</frameset>
</html>
