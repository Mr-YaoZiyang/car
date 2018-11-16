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
    	    elem: '#violationTime' //指定元素
    	  });
    	  
  	});
</script>
</head>
<body>
	<form class="layui-form" action="updateViolationInfo.do" method="post">
		<input type="hidden" name="violationId" value="${requestScope.violationmap.VIOLATION_ID}">
		<div class="layui-form-item">
			<label class="layui-form-label">驾驶员</label>
			<div class="layui-input-block">
				<select name="driverId" lay-verify="required" id="driverId">
					<option value=""></option>
					<c:forEach items="${requestScope.driverList }" var="m">
						<c:choose>
							<c:when test="${requestScope.violationmap.DRIVER_ID==m.DRIVER_ID }">
								<option value="${m.DRIVER_ID }" selected="selected">${m.DRIVER_NAME }</option>
							</c:when>
							<c:otherwise>
								<option value="${m.DRIVER_ID }">${m.DRIVER_NAME }</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">车牌号码</label>
			<div class="layui-input-block">
				<select name="carId" lay-verify="required" id="carId">
					<option value=""></option>
					<c:forEach items="${requestScope.carList }" var="m">
						<c:choose>
							<c:when test="${requestScope.violationmap.CAR_ID==m.CAR_ID }">
								<option value="${m.CAR_ID }" selected="selected">${m.CAR_NUM }</option>
							</c:when>
							<c:otherwise>
								<option value="${m.CAR_ID }">${m.CAR_NUM }</option>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">违章日期</label>
			<div class="layui-input-block">
				<input type="text" name="violationTime" id="violationTime" required
					lay-verify="required" placeholder="请输入违章日期" autocomplete="off"
					class="layui-input" value="${requestScope.violationmap.VIOLATION_TIME }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">违章地点</label>
			<div class="layui-input-block">
				<input type="text" name="violationSite" required
					lay-verify="required" placeholder="请输入违章地点" autocomplete="off"
					class="layui-input" value="${requestScope.violationmap.VIOLATION_SITE }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">处理结果</label>
			<div class="layui-input-block">
				<input type="text" name="results" required
					lay-verify="required" placeholder="请输入处理结果" autocomplete="off"
					class="layui-input" value="${requestScope.violationmap.RESULTS }">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">违章费用</label>
			<div class="layui-input-block">
				<input type="text" name="violationCost" required
					lay-verify="required" placeholder="请输入违章费用" autocomplete="off"
					class="layui-input" value="${requestScope.violationmap.VIOLATION_COST }">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">违章信息</label>
			<div class="layui-input-block">
				<textarea name="violationInfo" placeholder="请输入违章信息" class="layui-textarea" >${requestScope.violationmap.VIOLATION_INFO }</textarea>
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