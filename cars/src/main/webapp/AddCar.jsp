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
    
    layui.use('laydate', function(){
    	  var laydate = layui.laydate;
    	  
    	  //执行一个laydate实例
    	  laydate.render({
    	    elem: '#regTime' //指定元素
    	  });
    	  
    	  laydate.render({
      	    elem: '#examinationTime' //指定元素
      	  });
	});
    
</script>
</head>
<body>
	<form class="layui-form" action="AddCarInfo.do" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">车牌号</label>
			<div class="layui-input-block">
				<input type="text" name="carNum" required lay-verify="required"
					placeholder="请输入车牌号" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">载客定员</label>
			<div class="layui-input-block">
				<input type="text" name="carCapacity" required lay-verify="required"
					placeholder="请输入载客定员" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车类型</label>
			<div class="layui-input-inline">
				<select name="carTypeId" lay-verify="required" id="carTypeId">
					<option value=""></option>
					<c:forEach items="${requestScope.catTypeList }" var="m">
						<option value="${m.CARTYPE_ID }">${m.CARTYPE_NAME }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车型号</label>
			<div class="layui-input-block">
				<input type="text" name="brandModel" required
					lay-verify="required" placeholder="请输入车型号" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">注册时间</label>
			<div class="layui-input-block">
				<input type="text" name="regTime" id="regTime" required
					lay-verify="required" placeholder="请输入注册时间" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">年检时间</label>
			<div class="layui-input-block">
				<input type="text" name="examinationTime" id="examinationTime" required
					lay-verify="required" placeholder="请输入年检时间" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		

		<div class="layui-form-item">
			<label class="layui-form-label">出厂编号</label>
			<div class="layui-input-block">
				<input type="text" name="factoryNumber" required
					lay-verify="required" placeholder="请输入出厂编号" autocomplete="off"
					class="layui-input">
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