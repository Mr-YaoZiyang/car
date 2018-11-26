<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html>
 <html>
  <head>
      <meta charset="utf-8"/>
       <title></title>
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
       <table id="mytb" style="margin:20px auto;text-align: center;">

      </table>
		<div id="dd" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
	    data-options="iconCls:'icon-save',resizable:true,modal:true" closed="true">
		    Dialog Content.
		</div>
		<script type="text/javascript">		
      	$('#mytb').datagrid({
           title: '车辆表',  //表格名称
           iconCls: 'icon-edit',  //图标
           fitColumns:true,
           //width:925,   //表格宽度
           height:'auto',   //表格高度，可指定高度，可自动
           border:true,  //表格是否显示边框
           url:'allUserCarInfo.do',   //获取表格数据时请求的地址
           columns:[[
             {field:'BRAND_MODEL',title:'品牌型号',width:100,hidden:false},
             {field:'CAR_NUM',title:'车牌号码',width:100},
             {field:'FACTORY_NUMBER',title:'出厂编号',width:100},
             {field:'CARTYPE_NAME',title:'车辆类型',width:100},
             {field:'REG_TIME',title:'注册时间',width:100},
             {field:'EXAMINATION_TIME',title:'年检时间',width:100},
             {field:'CAR_CAPACITY',title:'载客定员',width:100}
           ]],
           pagination:true,//如果表格需要支持分页，必须设置该选项为true
           pageSize:5,   //表格中每页显示的行数
           pageList:[5,10,15],
           rownumbers:true,   //是否显示行号
           nowrap: false,   
           striped: true,  //奇偶行是否使用不同的颜色
           method:'POST',   //表格数据获取方式,请求地址是上面定义的url
           sortName: 'CAR_ID',  //按照ID列的值排序
           sortOrder: 'desc',  //使用倒序排序
           idField: 'CAR_ID',
           loadMsg:'数据正在努力加载，请稍后...',   //加载数据时显示提示信息
           frozenColumns: [[  //固定在表格左侧的栏
                       {field: 'ck', checkbox: true},
                     ]],
           toolbar: [{
                     text: '申请用车',
                     iconCls: 'icon-save',
                     handler: function() {
                         /* getSelectIds('mytb','没有选择'); */
                         var rows = $('#mytb').datagrid('getSelections'); //获取你选择的所有行 
                         var carId = null;
                         for(var i =0;i<rows.length;i++){
                     		///获取id
                     	  	var carId=rows[i].CAR_ID;
                     	  	//alert(name);

                     	 }
                    	 layer.open({
 							type: 2,
 							title: '申请用车',
 							maxmin: true,
 							shadeClose: true, //点击遮罩关闭层
 							area : ['800px' , '520px'],
 							content: 'showApplyForCarInfo.do?carId='+carId
 						});
                     }
                 }]
         });

      	
       </script>
   </body>
 </html>