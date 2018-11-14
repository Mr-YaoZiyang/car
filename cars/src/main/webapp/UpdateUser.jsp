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
<script>
    layui.use('form', function () {
        var form = layui.form;
    });
    
    function changeProvince(){
		$.post(
			'city.do',
			{
				provinceId:$('#province').val()
			},
			function(data){
				$("#city option").remove();
				//$("#city").append("<option value='0'>--请选择--</option>")
				$.each(data, function(index,obj) {
					$("#city").append("<option value='"+obj.CITY_ID+"'>"+obj.CITY_NAME+"</option>");
				});
			},
			'json'
		);
	}
</script>
</head>
<body>
	<form class="layui-form" action="UpdateUserInfo.do">
		<input type="hidden" value="${requestScope.userMap.USER_ID }" name="userId">
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-block">
				<input type="text" name="userName" required lay-verify="required"
					placeholder="请输入用户名" autocomplete="off" class="layui-input" value="${requestScope.userMap.USER_NAME }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">账号</label>
			<div class="layui-input-block">
				<input type="text" name="userAccount" required lay-verify="required"
					placeholder="请输入账号" autocomplete="off" class="layui-input" value="${requestScope.userMap.USER_ACCOUNT }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">密码</label>
			<div class="layui-input-block">
				<input type="text" name="userPwd" required
					lay-verify="required" placeholder="请输入密码" autocomplete="off"
					class="layui-input" value="${requestScope.userMap.USER_PWD }">
			</div>
			<!-- <div class="layui-form-mid layui-word-aux">辅助文字</div> -->
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">电话</label>
			<div class="layui-input-block">
				<input type="text" name="userTel" required
					lay-verify="required" placeholder="请输入电话" autocomplete="off"
					class="layui-input" value="${requestScope.userMap.USER_TEL }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年龄</label>
			<div class="layui-input-block">
				<input type="text" name="userAge" required
					lay-verify="required" placeholder="请输入年龄" autocomplete="off"
					class="layui-input" value="${requestScope.userMap.USER_AGE }">
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<%-- <div class="layui-input-inline">
				<select name="provinceId" lay-verify="required" id="province" onchange="changeProvince();">
					<option value=""></option>
					<c:forEach items="${requestScope.provinceList }" var="m">
						<option value="${m.PROVINCE_ID }">${m.PROVINCE_NAME }</option>
					</c:forEach>
				</select>
			</div> --%>
			<!-- <div class="layui-input-inline">
				<select name="cityId" lay-verify="required" id="city">
					<option value=""></option>
					
				</select>
			</div> -->
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">详细地址</label>
			<div class="layui-input-block">
				<input type="text" name="userAddress" required
					lay-verify="required" placeholder="请输入详细地址" autocomplete="off"
					class="layui-input"  value="${requestScope.userMap.USER_ADDRESS }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<c:forEach items="${requestScope.sexList }" var="m">
					<c:choose>
						<c:when test="${requestScope.userMap.SEX_ID==m.SEX_ID }">
							<input type="radio" name="sexId" value="${m.SEX_ID }" title="${m.SEX }" checked="checked">
						</c:when>
						<c:otherwise>
							<input type="radio" name="sexId" value="${m.SEX_ID }" title="${m.SEX }">
						</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-block">
				<select name="roleId" lay-verify="required">
					<option value=""></option>
					<c:forEach items="${requestScope.roleList }" var="m">
						<option value="${m.ROLE_ID }">${m.ROLE_NAME }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">部门</label>
			<div class="layui-input-block">
				<select name="deptId" lay-verify="required">
					<option value=""></option>
					<c:forEach items="${requestScope.deptList }" var="m">
						<option value="${m.DEPT_ID }">${m.DEPT_NAME }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>