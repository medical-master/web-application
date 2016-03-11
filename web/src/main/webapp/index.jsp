<%@page pageEncoding="UTF-8"%>

<%
	String pageSelectedAtRuntime = (String)request.getAttribute("responseSection");
	if(pageSelectedAtRuntime == null)
		pageSelectedAtRuntime = "home.jsp";
%>

<!DOCTYPE html>
<html lang="zh-CN">
	<jsp:include page="header.jsp" flush="true" />
  <body>
	<jsp:include page="navbar.jsp" flush="true" />
	<div class="container">
	<jsp:include page="<%=pageSelectedAtRuntime%>" flush="true" />
	</div>
	<jsp:include page="footer.jsp" flush="true" />
  </body>
</html>
