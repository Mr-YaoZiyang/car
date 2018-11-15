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
    
</script>
</head>
<body>
	<form class="layui-form" action="updateDriverInfo.do" method="post">
		<input type="hidden" value="${requestScope.driverMap.DRIVER_ID }" name="driverId">
		<div class="layui-form-item">
			<label class="layui-form-label">驾驶员姓名</label>
			<div class="layui-input-block">
				<input type="text" name="driverName" required lay-verify="required"
					placeholder="请输入用户名" autocomplete="off" class="layui-input" value="${requestScope.driverMap.DRIVER_NAME }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">驾驶证号码</label>
			<div class="layui-input-block">
				<input type="text" name="driverNum" required lay-verify="required"
					placeholder="请输入账号" autocomplete="off" class="layui-input" value="${requestScope.driverMap.DRIVER_NUM }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">
				<c:forEach items="${requestScope.sexList }" var="m">
					<c:choose>
						<c:when test="${requestScope.driverMap.SEX_ID==m.SEX_ID }">
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
			<label class="layui-form-label">年龄</label>
			<div class="layui-input-block">
				<input type="text" name="driverAge" required
					lay-verify="required" placeholder="请输入年龄" autocomplete="off"
					class="layui-input" value="${requestScope.driverMap.DRIVER_AGE }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">驾驶员编号</label>
			<div class="layui-input-block">
				<input type="text" name="driverNumber" required
					lay-verify="required" placeholder="请输入驾驶员编号" autocomplete="off"
					class="layui-input" value="${requestScope.driverMap.DRIVER_NUMBER }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">联系电话</label>
			<div class="layui-input-block">
				<input type="text" name="driverTel" required
					lay-verify="required" placeholder="请输入联系电话" autocomplete="off"
					class="layui-input"  value="${requestScope.driverMap.DRIVER_TEL }">
			</div>
		</div>
		

		<div class="layui-form-item">
			<label class="layui-form-label">家庭住址</label>
			<div class="layui-input-block">
				<input type="text" name="driverAddress" required
					lay-verify="required" placeholder="请输入家庭住址" autocomplete="off"
					class="layui-input"  value="${requestScope.driverMap.DRIVER_ADDRESS }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">准驾车型</label>
			<div class="layui-input-block">
				<input type="text" name="driverType" required
					lay-verify="required" placeholder="请输入准驾车型" autocomplete="off"
					class="layui-input"  value="${requestScope.driverMap.DRIVER_TYPE }">
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