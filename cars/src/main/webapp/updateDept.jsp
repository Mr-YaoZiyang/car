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
	<form class="layui-form" action="updateDeptInfo.do" method="post">
		<input type="hidden" name="deptId"  value="${requestScope.map.DEPT_ID }">
		<div class="layui-form-item" style="margin-top:200px;">
			<label class="layui-form-label">部门名称</label>
			<div class="layui-input-inline">
				<input type="text" name="deptName" required lay-verify="required"
					placeholder="请输入部门名称" autocomplete="off" class="layui-input"
					 value="${requestScope.map.DEPT_NAME }">
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