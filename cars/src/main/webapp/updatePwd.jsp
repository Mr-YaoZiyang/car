<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加用户</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jQuery.min.1.9.1.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/plug/css/layui.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/plug/layui.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$('#userPwd').blur(function(){
			$.post(
				'checkPwd.do',
				{
					userId:$('#userId').val(),
					userPwd:$('#userPwd').val()
				},
				function(data){
					if(data.flag ==true){
						$('#spanPwd1').text("");
					}else{
						$('#spanPwd1').text("与原始密码不一致！！！");
					}
				},
				'json'
			);
		});
		
		$('#rePwd1').blur(function(){
			if($('#rePwd').val()==$('#rePwd1').val()){
				$('#spanPwd2').text("");
			}else{
				$('#spanPwd2').text("两次密码输入不一致");
			}
			
			
		});
		$('#sub').click(function(){
			$.post(
				'updatePwd.do',
					{
						userId:$('#userId').val(),
						userPwd:$('#rePwd').val()
					},
					function(data){
						if(data.flag ==true){
							alert("修改成功");
						}else{
							alert("修改失败");
						}
					},
					'json'
			);
		});
		
	});
</script>
<body>

	
      		<form class="layui-form" method="post" style="width:500px;height: auto;margin:100px auto;">
				<input type="hidden" value="${sessionScope.userMap.USER_ID }" id="userId" name="userId">
				<div class="layui-form-item">
					<label class="layui-form-label">原始密码</label>
					<div class="layui-input-inline">
						<input type="password" id="userPwd"  required lay-verify="required"
							placeholder="请输入原始密码" autocomplete="off" class="layui-input" >
					</div>
					<div class="layui-input-inline">
						<span id="spanPwd1"></span>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline">
						<input type="password" id="rePwd" required lay-verify="required"
							placeholder="请输入新密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">确认新密码</label>
					<div class="layui-input-inline">
						<input type="password" id="rePwd1" required
							lay-verify="required" placeholder="请再次输入新密码" autocomplete="off"
							class="layui-input">
					</div>
					<div class="layui-input-inline">
						<span id="spanPwd2"></span>
					</div>
				</div>
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" id="sub">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
    	
	
</body>
</html>