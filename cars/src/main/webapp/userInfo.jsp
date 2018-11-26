<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html>
 <html>
  <head>
      <meta charset="utf-8"/>
       <title>武侠小说人物</title>
    <!--导入相关插件-->
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jQuery.min.1.9.1.js"></script>
    <!-- //引入 jQuery EasyUI 核心库，这里采用的是 1.3.6 -->
    <script type="text/javascript" src="easyui-1.6.3/jquery.easyui.min.js"></script>
    <!-- //引入 EasyUI 中文提示信息 -->
    <script type="text/javascript" src="easyui-1.6.3/locale/easyui-lang-zh_CN.js"></script>
   <!--  //引入 EasyUI 核心 UI 文件 CSS -->
    <link rel="stylesheet" type="text/css" href="easyui-1.6.3/themes/default/easyui.css" />
    <!-- //引入 EasyUI 图标文件 -->
    <link rel="stylesheet" type="text/css" href="easyui-1.6.3/themes/icon.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plug/css/layui.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/plug/layui.js"></script>

	<script type="text/javascript" src="${pageContext.request.contextPath }/plug/lay/modules/layer.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/plug/css/modules/layer/default/layer.css" />
   </head>
   <body>
       <table id="mytb" style="width:1000px;height:300px">
 
      </table>
		<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
	    data-options="iconCls:'icon-save',resizable:true,modal:true" closed="true">
		    Dialog Content.
		</div>
      <script type="text/javascript">
      	$('#mytb').datagrid({
           title: '用户表',  //表格名称
           iconCls: 'icon-edit',  //图标
           fitColumns:true,
           //width:1250,   //表格宽度
           height:'auto',   //表格高度，可指定高度，可自动
           border:true,  //表格是否显示边框
           url:'allUserInfo.do',   //获取表格数据时请求的地址
           columns:[[
             {field:'USER_NAME',title:'姓名',width:100,hidden:false},
             {field:'USER_ACCOUNT',title:'账号',width:100},
             {field:'USER_PWD',title:'密码',width:100},
             {field:'USER_TEL',title:'电话',width:100},
             {field:'USER_AGE',title:'年龄',width:100},
             {field:'PROVINCE_NAME',title:'省',width:100},
             {field:'CITY_NAME',title:'市',width:100},
             {field:'USER_ADDRESS',title:'地址',width:100},
             {field:'SEX',title:'性别',width:100},
             {field:'ROLE_NAME',title:'角色',width:100},
             {field:'DEPT_NAME',title:'部门',width:100}
           ]],
           pagination:true,//如果表格需要支持分页，必须设置该选项为true
           pageSize:5,   //表格中每页显示的行数
           pageList:[5,10,15],
           rownumbers:true,   //是否显示行号
           nowrap: false,   
           striped: true,  //奇偶行是否使用不同的颜色
           method:'POST',   //表格数据获取方式,请求地址是上面定义的url
           sortName: 'USER_AGE',  //按照ID列的值排序
           sortOrder: 'desc',  //使用倒序排序
           idField: 'USER_NAME',
           loadMsg:'数据正在努力加载，请稍后...',   //加载数据时显示提示信息
           frozenColumns: [[  //固定在表格左侧的栏
                       {field: 'ck', checkbox: true},
                     ]],
           toolbar: [{
                     text: '添加',
                     iconCls: 'icon-add',
                     handler: function() {
                         /* getSelectIds('mytb','没有选择'); */
						layer.open({
							type: 2,
							title: '添加用户',
							maxmin: true,
							shadeClose: true, //点击遮罩关闭层
							area : ['800px' , '520px'],
							content: 'showAddUserInfo.do'
						});
                     }
                 }, '-', {
                     text: '删除',
                     iconCls: 'icon-cut',
                     handler: function() {
                    	 var rows = $('#mytb').datagrid('getSelections'); //获取你选择的所有行 
                    	 //循环所选的行
                    	 for(var i =0;i<rows.length;i++){
                    		//获取行号，根据行号静态的移除行
                    		var index = $('#mytb').datagrid('getRowIndex',rows[i]);//获取某行的行号
                    	  	//alert(index);
                    		///获取id，根据id删除数据
                    	  	var name=rows[i].USER_ID;
                    	  	//alert(name);
                    	  	
                    	   $.post(
                    			'deleteUser.do',
                    			{userId:name},
                    			function(data){
                    				if(data.flag==true){
                    					$('#mytb').datagrid('deleteRow',index); //通过行号移除该行
                    				}else{
                    					alert("删除失败！");
                    				}
                    			},
                    			'json'
                    	  );  
                    	 }
                     }
                 }, '-', {
                     text: '修改',
                     iconCls: 'icon-save',
                     handler: function() {
                         /* getSelectIds('mytb','没有选择'); */
                         var rows = $('#mytb').datagrid('getSelections'); //获取你选择的所有行 
                         var userId = null;
                         for(var i =0;i<rows.length;i++){
                     		///获取id
                     	  	var userId=rows[i].USER_ID;
                     	  	//alert(name);

                     	 }
                    	 layer.open({
 							type: 2,
 							title: '修改用户',
 							maxmin: true,
 							shadeClose: true, //点击遮罩关闭层
 							area : ['800px' , '520px'],
 							content: 'showUpdateUserInfo.do?userId='+userId
 						});
                     }
                 }]
         });
      	//分页组件配合分页查询使用
		//分页查询的参数
		//设置分页组件的一个参数
		/* var p = $("#mytb").datagrid("getPager");
		p.pagination({
			onSelectPage:function(pageNumber, pageSize){
				$(this).pagination('loading');
				alert('url?page='+pageNumber+'&rows='+pageSize);
				$(this).pagination('loaded');
			}
		}); */
      	
       </script>
   </body>
 </html>