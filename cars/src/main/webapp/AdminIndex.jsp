<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>公务车管理系统</title>
  <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery.min.1.9.1.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/plug/css/layui.css">
  <script type="text/javascript" src="${pageContext.request.contextPath }/plug/layui.js"></script>
  <script type="text/javascript">
  	/* $(function(){
  		$('#personalCenter').click(function(){
  			layer.open({
				type: 2,
				title: '个人资料',
				maxmin: true,
				shadeClose: true, //点击遮罩关闭层
				area : ['800px' , '520px'],
				content: 'personalCenter.do'
			});
  		});
  		
  	}); */
  </script>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">ORACLE公务用车管理系统</div>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
        	 ${sessionScope.userMap.USER_NAME }
        </a>
        <dl class="layui-nav-child">
          <dd><a href="personalCenter.do" target="main">基本资料</a></dd>
          <dd><a href="updatePwd.jsp" target="main">修改密码</a></dd>
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