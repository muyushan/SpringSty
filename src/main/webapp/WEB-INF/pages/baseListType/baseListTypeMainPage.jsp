<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common.jsp"></c:import>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>

<head>
    <script>
        var table=layui.table;
        var form=layui.form;

        $(document).ready(function(){

            table.render({
                elem: '#listTypeTable',
                id:'listTypeTable',
                method:'post',
                url:webRoot+"baseListType/queryBaseListType.do",
                page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                height:'full-180',
                cols: [[
                    {title:'序号',type:'numbers'},
                    {type:'checkbox'},
                    {field: 'typeName',title: '类型名称', width:200},
                    {field: 'typeValue',title: '类型编码', width:200},
                    {field: 'creator',title: '创建者', width:100},
                    {field: 'creatDate',title: '创建时间', width:200,templet:function(record){
                        return formatDateTime(record.creatDate);
                    }},
                    {field: 'modifier',title: '修改者', width:100},
                    {field: 'modifyDate',title: '修改时间', width:200,templet:function(record){
                        return formatDateTime(record.modifyDate);
                    }},
                    {field: 'enaled',title: '是否启用',align:'center',width: 100,templet:function(record){
                        if(record.enaled=="1"){
                            return "是";
                        }else{
                            return "否";
                        }
                    }}
                ]]
            });

            $("#queryBtn").click(function(){
                search();
            });
            $("#deleteListType").click(function(){
                deleteBaseListType();
            });
            $("#editListType").click(function(){
                showEditWindow();
            });
            $("#createNewType").click(function(){
                layer.open({
                    type: 1,
                    closeBtn:1,
                    btn: ['保存', '关闭'],
                    yes:function(){save()},
                    btn2:function(index, layero){
                        layer.close(index);
                        resetAddForm();
                    },
                    cancel: function(index, layero){
                        resetAddForm();
                    },
                    skin: 'layui-layer-molv',
                    area: ['380px', '220px'],
                    title:'创建字典类型',
                    content: $('#createType') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                });
            });
        });

        function search(){
            var  typeName=$("#listTypeName").val();
            table.reload('listTypeTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    typeName: typeName
                }
            });
        }
        function save(){
            var name=$("#typeName").val();
            var enabled=$("#enabled")[0]['checked'];
            if(name==""){
                layer.msg('请填写类型名称',{time:1000});
                return false;
            }
            if(enabled){
                enabled=1;
            }else {
                enabled=0;
            }
         var param={typeName:name,enaled:enabled};
            var url="<c:url value="/baseListType/add.do"/>";
            $.post(url,param,function(data){
                if(data.code=="200"){
                    resetAddForm();
                    layer.closeAll();
                    search();
                }else{
                    layer.open({
                        type: 0,
                        title:'提示',
                        content: data.message
                    });
                }

            });
        }

        function deleteBaseListType() {
            var checkedRow=table.checkStatus('listTypeTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择要删除的记录',{time:1000});
                return;
            }
            var idList=new Array();
            for(var i=0;i<checkedRow.data.length;i++){
                idList.push(checkedRow.data[i]["typeID"]);
            }

            layer.confirm('确认删除所选项目?', {icon: 3, title:'确认'}, function(index){

                $.post(webRoot+"baseListType/delete.do",{idList:idList},function(data){
                    if(data.code=="200"){
                        layer.msg('删除成功',{time:1000});
                        layer.close(index);
                        search();
                    }else{
                        layer.alert(data.message, {icon: 1});
                    }
                });

            });
        }
        function resetAddForm(){
            form.val("addForm", {
                "enabled": false,
                "typeName": ""
            });
            form.render();
        }
        function showEditWindow(){
            var checkedRow=table.checkStatus('listTypeTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择一条要编辑的记录',{time:1000});
                return;
            }
            if(checkedRow.data.length>1){
                layer.msg('只能选择一条记录',{time:1000});
                return;
            }
            form.val("addForm", {
                "enabled": checkedRow.data[0]["enaled"]==1?true:false,
                "typeName": checkedRow.data[0]["typeName"]
            });
            form.render();
            layer.open({
                type: 1,
                closeBtn:1,
                btn: ['保存', '关闭'],
                yes:function(){saveEditBaselistType()},
                btn2:function(index, layero){
                    layer.close(index);
                    resetAddForm();
                },
                cancel: function(index, layero){
                    resetAddForm();
                },
                skin: 'layui-layer-molv',
                area: ['380px', '220px'],
                title:'编辑字典类型',
                content: $('#createType') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        }

        function saveEditBaselistType() {
            var checkedRow = table.checkStatus('listTypeTable');
            var baselistType = {};

            var name = $("#typeName").val();
            var enabled = $("#enabled")[0]['checked'];
            if (name == "") {
                layer.msg('类型名称不能为空', {time: 1000});
                return false;
            }
            if (enabled) {
                enabled = 1;
            } else {
                enabled = 0;
            }
            baselistType.typeID = checkedRow.data[0]["typeID"];
            baselistType.typeName = name;
            baselistType.enaled = enabled;
            var url = "<c:url value="/baseListType/edit.do"/>";
            $.post(url, baselistType, function (data) {
                if (data.code == "200") {
                    resetAddForm();
                    layer.closeAll();
                    search();
                } else {
                    layer.open({
                        type: 0,
                        title: '提示',
                        content: data.message
                    });
                }
            });
        }

    </script>
</head>
<body>
<div class="layui-form-item">
    <table class="laytable-query-table">
        <tr>
            <td>字典类型</td>
            <td><input type="text" id="listTypeName" placeholder="请填入要查询的字典类型名称" style="width:200px; " class="layui-input"></td>
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewType"> <i class="layui-icon">&#xe654;</i>增加</button>
    <button class="layui-btn" id="editListType"> <i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn" id="deleteListType"> <i class="layui-icon">&#xe640;</i>删除</button>
</div>
<table id="listTypeTable" lay-filter="listTypeTable">
</table>

</body>
<div id="createType" style="display:none; padding-top: 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
    <div class="layui-form-item " >
        <label class="layui-form-label">类别名称</label>
        <div class="layui-input-inline">
            <input id="typeName" type="text" name="typeName" lay-filter="typeName"  required  lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否启用</label>
        <div class="layui-input-block layui-form">
            <input type="checkbox" name="enabled" id="enabled" lay-skin="switch" checked  lay-text="启用|禁用" lay-filter="enabled"/>
        </div>
    </div>
    </form>
</div>
</html>
