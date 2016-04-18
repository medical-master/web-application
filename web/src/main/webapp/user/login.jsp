<%@page pageEncoding="UTF-8"%>
<%
	String path = request.getServletContext().getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<jsp:include page="../header.jsp" flush="true" />

<script src="//cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/jquery.validate.min.js"></script>
<script src="//cdn.bootcss.com/jquery-validate/1.15.0/additional-methods.min.js"></script>
<body>
	<div class="container">
		<div class="header clearfix">
			<div class="logo pull-left">
				<a href="##"></a>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column" style="margin-top:20px;">
			<div class="panel panel-primary" style="height:500px; background: url(../resources/images/login/backgroupd.png) no-repeat ;">
				<div class="panel-heading">
			      <h3 class="panel-title">账户登录</h3>
			    </div>
  				<div class="panel-body" style="margin-left:auto; margin-right:auto; margin-top:100px; width:500px;" >
					<form class="form" id="loginForm" action="<%=path%>/action" method="post">
						<div class="form-group"> 
							<div class="input-group">
						      <div class="input-group-addon">
						      	<span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
						      </div>
						      <input type="text" class="form-control" id="name" name="name" placeholder="请输入手机号/邮箱">
						    </div>
						</div> 
						<div class="form-group"> 
							<div class="input-group">
						      <div class="input-group-addon">
						      	<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
						      </div>
						      <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
						    </div>
						</div> 
						<input type="hidden" name="action" value="login"> 
						<input type="hidden" name="module" value="user">
						
						<button type="submit" class="btn btn-primary">&nbsp;&nbsp; 登录   &nbsp;&nbsp;</button>
					</form>
				</div>
			</div>		
			</div>
		</div>
	</div>
</body>

<script type="text/javascript">
		$( document ).ready( function () {
			$( "#loginForm" ).validate( {
				rules: {
					name: "required",
					password: "required"
				},
				messages: {
					name: "请输入手机号/邮箱",
					password:"请输入密码"
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "label-danger" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
				}
			} );
		} );
	</script>
</html>