<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>公务车管理系统</title>
  <link rel="stylesheet" href="plug/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">ORACLE公务用车管理系统</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <!-- <ul class="layui-nav layui-layout-left">
      <li class="layui-nav-item"><a href="">控制台</a></li>
      <li class="layui-nav-item"><a href="">商品管理</a></li>
      <li class="layui-nav-item"><a href="">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul> -->
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
        	 ${sessionScope.userMap.USER_NAME }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="logout.do">退出</a></li>
    </ul>
  </div>

  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        
        <li class="layui-nav-item">
          <a class="" href="javascript:;">${requestScope.fatherMap.MENU_NAME }</a>
          <dl class="layui-nav-child">
          	<c:forEach items="${requestScope.sonList }" var="m" >
          		<dd><a href="${m.MENU_URL }" target="${m.TARGET }">${m.MENU_NAME }</a></dd>
          	</c:forEach>
            
           <!--  <dd><a href="carInfo.jsp"  target="main">列表二</a></dd>
            <dd><a href="userInfo.jsp" target="main">列表三</a></dd>
            <dd><a href="userInfo1.jsp" target="main">超链接</a></dd> -->
          </dl>
        </li>
        
       <!--  <li class="layui-nav-item"><a href="">云市场</a></li>
       <li class="layui-nav-item"><a href="">发布商品</a></li> -->
      </ul>
    </div>
  </div>

  <div class="layui-body">
    <!-- 内容主体区域 -->
   <!--  <div style="padding: 15px;">内容主体区域</div> -->
   <iframe src="carInfo.jsp" frameborder="no" name="main" style="width:100%;height:100%"></iframe>
  </div>

  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © Oracle  公务用车管理系统
  </div>
</div>
<script src="plug/layui.js"></script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;

});
</script>
</body>
</html>