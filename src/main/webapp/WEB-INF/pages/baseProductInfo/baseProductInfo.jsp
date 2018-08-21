<%--
  Created by IntelliJ IDEA.
  User: Litsoft
  Date: 2018/8/21
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="../common.jsp"></c:import>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>基础物料信息维护</title>
    <style>

    </style>
    <script>
        var table;
        var form;
        layui.use('form', function(){
            form = layui.form;
        });
        $(document).ready(function(){
            $.ajax({
                type:'get',
                url: webRoot+'baseListItem/queryBaseListItem.do?page=1&limit=1000&showAll=true&typeID=35',
                success:function(data){
                    var html='';
                    $.each(data.data,function(key,value){
                        html+="<option value='"+value.listID+"'>"+value.listName+"</option>";
                    })
                    $("#flavour").html(html);
                    form.render("select");
                }
            });
            $.ajax({
                type:'get',
                url: webRoot+'baseListItem/queryBaseListItem.do?page=1&limit=1000&showAll=true&typeID=36',
                success:function(data){
                    var html='';
                    $.each(data.data,function(key,value){
                        html+="<option value='"+value.listID+"'>"+value.listName+"</option>";
                    })
                    $("#specification").html(html);
                    form.render("select");
                }
            });
        });
    </script>
</head>
<body>
<div class="layui-form">
    <table class="laytable-query-table">
        <tr>
            <td>物料编码</td>
            <td><input type="text" id="productCode" style="width:150px; " class="layui-input"/></td>
            <td>物料名称</td>
            <td><input type="text" id="productName" style="width:150px; " class="layui-input"/></td>
            <td>口味</td>
            <td><select lay-filter="flavour"  id="flavour"  lay-search=""></select></td>
            <td>产品规格</td>
            <td><select lay-filter="specification"  id="specification"  lay-search=""></select></td>
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewItem"> <i class="layui-icon">&#xe654;</i>增加</button>
    <button class="layui-btn" id="editListItem"> <i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn" id="deleteListItem"> <i class="layui-icon">&#xe640;</i>删除</button>
    <button class="layui-btn" id="uploadListItem"> <i class="layui-icon layui-icon-upload"></i>批量上传</button>
</div>
<table id="baseProductInfoTable" lay-filter="baseProductInfoTable">
</table>

</body>
</html>
