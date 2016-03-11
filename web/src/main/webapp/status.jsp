<%@page pageEncoding="UTF-8"%>

<%
    String result = (String)request.getAttribute("result");
%>

    <div class="container">

      <div class="starter-template">
        <h1>执行结果</h1>
        <p class="lead"><%=result%></p>
      </div>

    </div><!-- /.container -->