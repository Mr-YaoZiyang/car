<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
    <title></title>
    <script type="text/javascript" src="easyui-1.6.3/jquery.min.js"></script>
    <!-- //引入 jQuery EasyUI 核心库，这里采用的是 1.3.6 -->
    <script type="text/javascript" src="easyui-1.6.3/jquery.easyui.min.js"></script>
    <!-- //引入 EasyUI 中文提示信息 -->
    <script type="text/javascript" src="easyui-1.6.3/locale/easyui-lang-zh_CN.js"></script>
   <!--  //引入 EasyUI 核心 UI 文件 CSS -->
    <link rel="stylesheet" type="text/css" href="easyui-1.6.3/themes/default/easyui.css" />
    <!-- //引入 EasyUI 图标文件 -->
    <link rel="stylesheet" type="text/css" href="easyui-1.6.3/themes/icon.css" />
    
    
    
</head>
<body>
    <h2>用户表</h2>

    <div style="margin:20px 0;"></div>

    <table id="dg" class="easyui-datagrid" title="用户表" style="width:1000px;height:auto"
            data-options="
                iconCls: 'icon-edit',
                singleSelect: true,
                toolbar: '#tb',
                url: 'allUserInfo.do',
                method: 'post',
                onClickCell: onClickCell,
                onEndEdit: onEndEdit
            ">
        <thead>
            <tr>
                <th data-options="field:'USER_NAME',align:'center',width:100">用户名</th>
                <th data-options="field:'USER_ACCOUNT',align:'center',width:120">账号</th>
                <th data-options="field:'USER_PWD',align:'center',width:100">密码</th>
                <th data-options="field:'USER_TEL',width:100,align:'center'">电话</th>
                <th data-options="field:'USER_AGE',width:80,align:'center'">年龄</th>
                <th data-options="field:'USER_ADDRESS',width:250,align:'center'">地址</th>
                <th data-options="field:'SEX',width:80,align:'center'">角色</th>
                <th data-options="field:'ROLE_NAME',width:80,align:'center'">性别</th>
                <th data-options="field:'DEPT_NAME',width:80,align:'center'">部门</th>
            </tr>
        </thead>
       
    </table>

    <div id="tb" style="height:auto">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addUser()">
           	 添加
        </a>
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"  onclick="removeit()">     
        	删除
        </a>
       <!--  <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="Edit()">
          	保存
        </a> -->
       <!--  <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="cancel()">取消</a> -->
        
        <!-- <input type="text" name="">
        <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true"  onclick="getChanges()">
            	搜索
        </a> -->
    </div>

    <script type="text/javascript">
        var editIndex = undefined;
        function endEditing(){
           if (editIndex == undefined){return true}
            if ($('#dg').datagrid('validateRow', editIndex)){
                $('#dg').datagrid('endEdit', editIndex);
                editIndex = undefined;
                return true;
            } else {
                return false;
            } 
        }
        function onClickCell(index, field){
             if (editIndex != index){
                if (endEditing()){
                    $('#dg').datagrid('selectRow', index)
                            .datagrid('beginEdit', index);
                    var ed = $('#dg').datagrid('getEditor', {index:index,field:field});
                    if (ed){
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    setTimeout(function(){
                        $('#dg').datagrid('selectRow', editIndex);
                    },0);
                }
            } 
        }
        
        function onEndEdit(index, row){
           /*  var ed = $(this).datagrid('getEditor', {
                index: index,
                field: 'userName'
            });
            row.productname = $(ed.target).combobox('getText'); */
        }
        
        function addUser(){
            /* if (endEditing()){
                $('#dg').datagrid('appendRow',{status:'P'});
                editIndex = $('#dg').datagrid('getRows').length-1;
                $('#dg').datagrid('selectRow', editIndex)
                        .datagrid('beginEdit', editIndex);
            } */
        }
        
        function removeit(){
            if (editIndex == undefined){return}
            $('#dg').datagrid('cancelEdit', editIndex)
                    .datagrid('deleteRow', editIndex);
            editIndex = undefined;
        }
        
        function Edit(){
            /* if (endEditing()){
                $('#dg').datagrid('acceptChanges');
            } */
        }
        function cancel(){
           /*  $('#dg').datagrid('rejectChanges');
            editIndex = undefined;  */
        }
        
        function getChanges(){
          /*   var rows = $('#dg').datagrid('getChanges');
            alert(rows.length+' rows are changed!'); */
        }
        
        

    </script>



</body>
</html>