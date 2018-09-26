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
    <title>库存变更记录</title>
    <script>
        var table=layui.table;
        var tableSelect=layui.tableSelect;
        var laydate = layui.laydate;

        $(document).ready(function() {
            tableSelect.render({
                elem: '#search_productName',	//定义输入框input对象
                searchKey: 'keyWord',	//搜索输入框的name值 默认keyword
                searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                table: {
                    url:webRoot+"baseProductInfo/query.do",
                    cols: [[
                        {type:'checkbox'},
                        {field: 'productName',title: '物料名称', width:100},
                        {field: 'productCategoryTxt',title: '物料类别', width:80},
                        {field: 'flavourTxt',title: '口味', width:80},
                        {field: 'specificationTxt',title: '规格', width:80},
                        {field: 'packageSpecificationTxt',title: '包装规格', width:80}
                    ]]
                },
                done: function (elem, data) {
                    elem.val(data.data[0]["productName"]);
                    $("#search_productCode").val(data.data[0]["productCode"]);
                }
            });

            table.render({
                    elem: '#storageProductChangeLogTable',
                    id:'storageProductChangeLogTable',
                    method:'post',
                    url:webRoot+"storageProduct/queryChageLog.do",
                    page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                    height:'full-180',
                    cols: [[
                        {title:'序号',type:'numbers'},
                        {type:'checkbox'},
                        {field: 'inOutCode',title: '出入库编码', width:120},
                        {field: 'productCode',title: '物料编码', width:230},
                        {field: 'productName',title: '物料名称',  width:100},
                        {field:'storageTypeTxt',title:'库存类型',width:80},
                        {field: 'productCategoryTxt',title: '产品类别', width:80},
                        {field: 'flavourTxt',title: '口味', width:80 },
                        {field: 'specificationTxt',title: '规格', width:80 },
                        {field: 'packageSpecificationTxt',title: '包装规格', width:80},
                        {field: 'unitTxt',title: '单位', width:60 },
                        {field: 'packageUnitTxt',title: '包装单位', width:60},
                        {field:'inOutType',title:'调整类型',width:60,templet:function(record){
                            if(record.inOutType=="IN"){
                                return "入库";
                            }else if(record.inOutType=="OUT"){
                                return "出库";
                            }
                        }},
                        {field: 'quantity',title: '调整量', width:60},
                        {field: 'formerQuantity',title: '调整前数量', width:60},
                        {field: 'createDate',title: '操作时间', width:180,templet:function(record){
                            return formatDateTime(record.createDate);
                        }},
                        {field: 'creator',title: '操作者', width:80}
                    ]]
                });


            $("#queryBtn").click(function(){
                search();
            });
            $("#exportChangeLogBtn").click(function(){
                exportChangeLog();
            });
            var d= new Date();
            d.setTime(d.getTime()-30*24*60*60*1000);
            laydate.render({
                elem: '#createDateBegin', //指定元素
                type:"datetime",
                value: d
            });
            laydate.render({
                elem: '#createDateEnd', //指定元素
                type:"datetime",
                value: new Date()
        });
        });

        function search(){
            var createDateBegin=$("#createDateBegin").val();
            var createDateEnd=$("#createDateEnd").val();
            var  productCode=$("#search_productCode").val();

            table.reload('storageProductChangeLogTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    productCode: productCode,
                    beginDate:createDateBegin,
                    endDate:createDateEnd
                }
            });
        }

        function exportChangeLog(){
            var checkedRow=table.checkStatus('storageProductChangeLogTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择需要导出的记录',{time:1000});
                return;
            }
            var idArray=new Array();
            for(i in checkedRow.data ){
                idArray.push(checkedRow.data[i]["inOutID"]);
            }

            window.location=webRoot+"storageProduct/exportChangeLog.do?idList[]="+idArray.join();
//            $.ajax({
//                url : webRoot+"storageProduct/exportChangeLog.do",
//                type:"POST",
//                dataType:"json",
//                contentType:"application/json",
//                data:JSON.stringify(idArray),
//                success:function(data){
//                }
//            });﻿
        }
    </script>
</head>
<body>
<div class="layui-form">
    <table class="laytable-query-table">
        <tr>
            <td>物料</td>
            <td>
                <input type="text" id="search_productName" style="width:200px; " class="layui-input"/>
                <input type="hidden" id="search_productCode">
            </td>
            <td>操作时间</td>
            <td >
                <input type="text" class="layui-input" id="createDateBegin"/>
            </td>
            <td>至</td>
            <td>
                <input type="text" class="layui-input" id="createDateEnd"/>
            </td>
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="exportChangeLogBtn"> <i class="layui-icon">&#xe654;</i>导出库存记录</button>
</div>
<table id="storageProductChangeLogTable" lay-filter="storageProductChangeLogTable">
</table>
</body>


</html>
