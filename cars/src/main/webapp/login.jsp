<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery.min.1.9.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plug/dist/jquery-con|firm.min.css">
<script type="text/javascript" src="${pageContext.request.contextPath }/plug/dist/jquery-confirm.min.js"></script>
<title>登录</title>
<style type="text/css">
	#form1{
		width:500px;
		height:500px;
		margin:100px auto;
	}
</style>
<script type="text/javascript">
	$(function(){
		$('#sub').click(function(){
			//alert($('#stuAccount').val()+"+"+$('#stuPwd').val());
			$.post(
				'login.do',	
				{
					userAccount:$('#stuAccount').val(),
					userPwd:$('#stuPwd').val()
				},
				function(data){
					//alert(data.flag);
					if(data.flag==true){
						window.location.href="queryMenu.do"
					}else{
						$.alert({
							title:"Error",
							content:"用户名或密码错误"
						});
					}
				},
				'json'
			);
		});
	});
</script>
</head>
<body>
	<form action="#" method="post" id="form1">
		账号：<input type="text" name="stuAccount" id="stuAccount" class="form-control"><span id="spanAccount"></span>
		密码：<input type="password" name="stuPwd" id="stuPwd" class="form-control"><span id="spanPwd"></span>
		<input type="button" id="sub" class="btn btn-info" value="登录">
	</form>
</body>
</html>