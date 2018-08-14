<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common.jsp"></c:import>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>

<head>
    <script>
        var table;
        var form;
        layui.use('table', function(){
            table = layui.table;
            table.render({
                elem: '#listItemTable',
                id:'listItemTable',
                method:'post',
                url:webRoot+"baseListItem/queryBaseListItem.do",
                page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                height:'full-180',
                cols: [[
                    {title:'序号',type:'numbers'},
                    {type:'checkbox'},
                    {field: 'typeName',title: '类型名称', width:200},
                    {field: 'listvalue',title: '字典值', width:200},
                    {field: 'listname',title: '字典名称', width:200},
                    {field: 'creator',title: '创建者', width:100},
                    {field: 'creatdate',title: '创建时间', width:200,templet:function(record){
                        return formatDateTime(record.creatdate);
                    }},
                    {field: 'modifier',title: '修改者', width:100},
                    {field: 'modifydate',title: '修改时间', width:200,templet:function(record){
                        return formatDateTime(record.modifydate);
                    }}
                ]]
            });
        });
        layui.use('form', function(){
            form = layui.form;
        });
        $(document).ready(function(){
            $.ajax({
                type:'get',
                url: webRoot+'baseListType/queryBaseListType.do?page=1&limit=1000&showAll=true',
                success:function(data){
                    var html='';
                    $.each(data.data,function(key,value){
                        html+="<option value='"+value.typeid+"'>"+value.typename+"</option>";
                    })
                    $("#listTypeName").html(html);
                    $("#typeId").html(html);
                    form.render("select");
                }
            });

            $("#queryBtn").click(function(){
                search();
            });
            $("#deleteListItem").click(function(){
                deleteListItem();
            });
            $("#editListItem").click(function(){
                showEditWindow();
            });
            $("#uploadListItem").click(function(){
                showUploadDialog();
            });
            $("#createNewItem").click(function(){
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
                    area: ['380px', '400px'],
                    title:'创建字典项',
                    content: $('#createItem') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                });
            });
        });

        function search(){
            var  typeid=$("#listTypeName").val();
            table.reload('listItemTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    typeid: typeid
                }
            });
        }
        function save(){
            var typeId=$("#typeId").val();
            var itemName=$("#listName").val();
            var itemValue=$("#listValue").val();
            if(typeId==null||typeId==""){
                layer.msg('请选择字典类型',{time:1000});
                return false;
            }
            if(itemName==null||itemName==""){
                layer.msg('请填写字典项名称',{time:1000});
                return false;
            }
            if(itemValue==null||itemValue==""){
                layer.msg('请填写字典项值',{time:1000});
                return false;
            }
            if(isNaN(itemValue)){
                layer.msg('字典项的值必须是数字',{time:1000});
                return false;

            }
         var param={typeid:typeId,listvalue:itemValue,listname:itemName};
            var url="<c:url value="/baseListItem/add.do"/>";
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

        function deleteListItem() {
            var checkedRow=table.checkStatus('listItemTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择要删除的记录',{time:1000});
                return;
            }
            var idList=new Array();
            for(var i=0;i<checkedRow.data.length;i++){
                idList.push(checkedRow.data[i]["listid"]);
            }

            layer.confirm('确认删除所选项目?', {icon: 3, title:'确认'}, function(index){
                $.post(webRoot+"baseListItem/delete.do",{idList:idList},function(data){
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
                "listName": "",
                "listValue": ""
            });
            $("#typeId").val(-1);
            $("#typeId").removeAttr("disabled");
            form.render();
        }
        function showEditWindow(){
            var checkedRow=table.checkStatus('listItemTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择一条要编辑的记录',{time:1000});
                return;
            }
            if(checkedRow.data.length>1){
                layer.msg('只能选择一条记录',{time:1000});
                return;
            }
            form.val("addForm", {
                "listName":checkedRow.data[0]["listname"],
                "listValue": checkedRow.data[0]["listvalue"]

            });
            $("#typeId").val(checkedRow.data[0]["typeid"]);
            $("#listId").val(checkedRow.data[0]["listid"]);
            $("#typeId").attr("disabled","disabled");
            form.render();
            layer.open({
                type: 1,
                closeBtn:1,
                btn: ['保存', '关闭'],
                yes:function(){saveEditBaselistItem()},
                btn2:function(index, layero){
                    layer.close(index);
                    resetAddForm();
                },
                cancel: function(index, layero){
                    resetAddForm();
                },
                skin: 'layui-layer-molv',
                area: ['380px', '400px'],
                title:'编辑字典项',
                content: $('#createItem') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        }

        function saveEditBaselistItem() {
            var checkedRow = table.checkStatus('listItemTable');
            var baselistItem = {};
            var listid=$("#listId").val();
            var typeid=$("#typeId").val();
            var listvalue=$("#listValue").val();
            var listname=$("#listName").val();
            if(typeid==-1){
                layer.msg('请选择一项字典类型',{time:1000});
                return;

            }
            baselistItem.listid=listid;
            baselistItem.typeid=typeid;
            baselistItem.listvalue=listvalue;
            baselistItem.listname=listname;

            var url = "<c:url value="/baseListItem/edit.do"/>";
            $.post(url, baselistItem, function (data) {
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

        function showUploadDialog(){
            layer.open({
                type: 1,
                closeBtn:1,
                btn: ['上传', '关闭'],
                yes:function(){},
                btn2:function(index, layero){
                    layer.close(index);
                },
                cancel: function(index, layero){
                    resetAddForm();
                },
                skin: 'layui-layer-molv',
                area: ['380px', '200px'],
                title:'上传字典项',
                content: $('#uploadDialog')
            });
        }

    </script>
</head>
<body>
<div class="layui-form">
    <div class="layui-inline">
        <label class="layui-form-label">字典类型</label>
        <div class="layui-input-inline" >
            <select lay-filter="listTypeName"  id="listTypeName" placeholder="请选择要查询的字典类型名称" lay-search=""></select>
        </div>
        &nbsp;<button class="layui-btn" id="queryBtn">查询</button>
    </div>
</div>

<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewItem"> <i class="layui-icon">&#xe654;</i>增加</button>
    <button class="layui-btn" id="editListItem"> <i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn" id="deleteListItem"> <i class="layui-icon">&#xe640;</i>删除</button>
    <button class="layui-btn" id="uploadListItem"> <i class="layui-icon layui-icon-upload"></i>批量上传</button>
</div>
<table id="listItemTable" lay-filter="listItemTable">
</table>

</body>
    <div id="createItem" style="display:none; padding-top: 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
        <input type="hidden" lay-filter="listId" id="listId">
        <div class="layui-form-item">
            <label class="layui-form-label">字典类型</label>
            <div class="layui-input-inline">
                <select lay-filter="typeId"  id="typeId" lay-search=""></select>
            </div>
        </div>

        <div class="layui-form-item">
        <label class="layui-form-label">字典名</label>
        <div class="layui-input-inline">
            <input lay-filter="listName" type="text" name="listName" id="listName"   lay-verify="required" placeholder="请输入字典名" autocomplete="off" class="layui-input">
        </div>
        </div>

        <div class="layui-form-item">
        <label class="layui-form-label">字典值</label>
        <div class="layui-input-inline">
            <input lay-filter="listValue" type="text" name="listValue" id="listValue"   lay-verify="required" placeholder="请输入字典值" autocomplete="off" class="layui-input">
        </div>
        </div>
    </form>
</div>
<div id="uploadDialog" style="display: none; padding-top: 10px;">
    <form class="layui-form" action="" lay-filter="uploadForm">
        <input type="file" id="uploadFile" class="layui-inline" /><button type="button" class="layui-btn" id="downLoadButton">
        <i class="layui-icon layui-icon-download-circle"></i>下载上传模板
    </button>
    </form>
</div>
</html>
