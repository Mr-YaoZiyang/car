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
  	    elem: '#appLeavingDate' //指定元素
  	  });
  	  
  	  laydate.render({
    	    elem: '#planedReturnTime' //指定元素
    	  });
	});
    
</script>
</head>
<body>
	<form class="layui-form" action="schedulingInfo.do" method="post">
		<input type="hidden" name="carId" value="${requestScope.carId }">
		<input type="hidden" name="userId" value="${sessionScope.userMap.USER_ID }">
		<div class="layui-form-item">
			<label class="layui-form-label">出行时间</label>
			<div class="layui-input-block">
				<input type="text" name="appLeavingDate" id="appLeavingDate" required
					lay-verify="required" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		
		<div class="layui-form-item">
			<label class="layui-form-label">返还时间</label>
			<div class="layui-input-block">
				<input type="text" name="planedReturnTime" id="planedReturnTime" required
					lay-verify="required" autocomplete="off"
					class="layui-input" >
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">目的地</label>
			<div class="layui-input-block">
				<input type="text" name="destination" id="destination" required
					lay-verify="required" placeholder="请输入目的地" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		

		<div class="layui-form-item">
			<label class="layui-form-label">用车原因</label>
			<div class="layui-input-block">
		      <textarea name="usingReason" placeholder="请输入用车原因" class="layui-textarea"></textarea>
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