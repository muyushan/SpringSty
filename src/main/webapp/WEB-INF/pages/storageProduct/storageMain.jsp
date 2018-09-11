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
    <title>库存管理</title>
    <script>
        var table=layui.table;
        var tableSelect=layui.tableSelect;
        var form=layui.form;

        $(document).ready(function() {
            tableSelect.render({
                elem: '#search_productName',	//定义输入框input对象
                searchKey: 'keyWord',	//搜索输入框的name值 默认keyword
                searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                table: {
                    url:webRoot+"baseProductInfo/query.do",
                    cols: [[
                        {type:'checkbox'},
                        {field: 'productCode',title: '物料编码', width:250},
                        {field: 'productName',title: '物料名称', width:200}
                    ]]
                },
                done: function (elem, data) {
                    elem.val(data.data[0]["productName"]);
                    $("#search_productCode").val(data.data[0]["productCode"]);
                }
            });

            table.render({
                    elem: '#storageProductTable',
                    id:'storageProductTable',
                    method:'post',
                    url:webRoot+"storageProduct/query.do",
                    page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                    height:'full-180',
                    cols: [[
                        {title:'序号',type:'numbers'},
                        {type:'checkbox'},
                        {field: 'productCode',title: '物料编码', width:250},
                        {field: 'productInfoUD',title: '物料名称', width:200,templet: '<span>{{d.productInfoUD.productName}}</span>' },
                        {field:'quantity',title:'库存量',width:80},
                        {field:'typeTxt',title:'库存类型',width:120},
                        {field: 'productInfoUD',title: '产品类别', width:200,templet: '<span>{{d.productInfoUD.productCategoryTxt}}</span>' },
                        {field: 'productInfoUD',title: '口味', width:200,templet: '<span>{{d.productInfoUD.flavourTxt}}</span>' },
                        {field: 'productInfoUD',title: '规格', width:200,templet: '<span>{{d.productInfoUD.specificationTxt}}</span>' },
                        {field: 'productInfoUD',title: '包装规格', width:200,templet: '<span>{{d.productInfoUD.packageSpecificationTxt}}</span>' },
                        {field: 'productInfoUD',title: '单位', width:200,templet: '<span>{{d.productInfoUD.unitTxt}}</span>' },
                        {field: 'productInfoUD',title: '包装单位', width:200,templet: '<span>{{d.productInfoUD.packageUnitTxt}}</span>' }

                    ]]
                });

            /**
             * 加载下拉框
             */
            loadCommonBoxList($("#type"));
            $("#createNewStrorageProduct").click(function(){
                layer.open({
                    type: 1,
                    closeBtn:1,
                    btn: ['保存', '关闭'],
                    yes:function(){saveNewOrEdit("add")},
                    btn2:function(index, layer){
                        layer.close(index);
//                        resetAddForm();
                    },
                    cancel: function(index, layero){
//                        resetAddForm();
                    },
                    skin: 'layui-layer-molv',
                    area: ['400px', '340px'],
                    title:'新料入库',
                    content: $('#createNewStorageProductContent')
                });

                tableSelect.render({
                    elem: '#productName',	//定义输入框input对象
                    searchKey: 'keyWord',	//搜索输入框的name值 默认keyword
                    searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                    table: {
                        url:webRoot+"baseProductInfo/query.do",
                        cols: [[
                            {type:'checkbox'},
                            {field: 'productCode',title: '物料编码', width:250},
                            {field: 'productName',title: '物料名称', width:200}
                        ]]
                    },
                    done: function (elem, data) {
                        elem.val(data.data[0]["productName"]);
                        $("#productCode").val(data.data[0]["productCode"]);
                    }
                });
            });

//            $("#editProductInfo").click(function(){
//                showEditWindow();
//
//            });


            $("#queryBtn").click(function(){
                search();
            });
        });

        function showEditWindow(){
            var checkedRow=table.checkStatus('storageProductTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择一条要编辑的记录',{time:1000});
                return;
            }
            if(checkedRow.data.length>1){
                layer.msg('只能选择一条记录',{time:1000});
                return;
            }
            $("#productId").val(checkedRow.data[0]["productId"]);
            $("#productCode").val(checkedRow.data[0]["productCode"]);
            $("#productName").val(checkedRow.data[0]["productName"]);
            $("#productCategory").val(checkedRow.data[0]["productCategory"]);
            $("#flavour").val(checkedRow.data[0]["flavour"]);
            $("#specification").val(checkedRow.data[0]["specification"]);
            $("#packageSpecification").val(checkedRow.data[0]["packageSpecification"]);
            $("#productName").addClass("layui-disabled");
            $("#productCategory").attr("disabled",true);
            $("#flavour").attr("disabled",true);
            $("#specification").attr("disabled",true);
            $("#packageSpecification").attr("disabled",true);
            $("#unit").val(checkedRow.data[0]["unit"]);
            $("#packageUnit").val(checkedRow.data[0]["packageUnit"]);
            $("#volume").val(checkedRow.data[0]["volume"]);
            $("#weight").val(checkedRow.data[0]["weight"]);
            form.render();
            $(".layui-input.layui-disabled").attr("disabled",true);//将下拉框的文本框禁止输入解决layUI问题
            layer.open({
                type: 1,
                closeBtn:1,
                btn: ['保存', '关闭'],
                yes:function(){saveNewOrEdit("edit")},
                btn2:function(index, layero){
                    layer.close(index);
                    resetAddForm();
                },
                cancel: function(index, layero){
                    resetAddForm();
                },
                skin: 'layui-layer-molv',
                area: ['680px', '340px'],
                title:'修改基础物料',
                content: $('#createNewProductInfoContent')
            });
        }

        function search(){
            var  productCode=$("#search_productCode").val();
            table.reload('storageProductTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    productCode: productCode,
                }
            });
        }


        function saveNewOrEdit(flag){
            var productCode=$("#productCode").val();
            var options=$("#type option:selected");
            var obj=options.attr('data');
            obj=JSON.parse(obj);
            var type=obj.listValue;
            var quantity=$("#quantity").val();
            var remark=$("#remark").val();
            var  storageProduct={};
            if(flag=="edit"){
                storageProduct.storageProductId=$("#storageProductId").val();
            }else{
                storageProduct.productCode=productCode;
                if(type!=""){
                    storageProduct.type=type;
                }else{
                    layer.msg('必选选择一种库存类别',{time:1000});
                    return;
                }

            }
            storageProduct.quantity=quantity;
            storageProduct.remark=remark;
            var url="";
            if(flag=="add"){
                url="<c:url value="/storageProduct/add.do"/>";
            }else if(flag=="edit"){

                url="<c:url value="/storageProduct/edit.do"/>";
            }
            $.post(url,storageProduct,function(data){
                if(data.code=="200"){
//                    resetAddForm();
                    layer.closeAll();
//                    search();
                }else{
                    layer.open({
                        type: 0,
                        title:'提示',
                        content: data.message
                    });
                }

            });
        }

        function resetAddForm(){
            $("#productCode").val("");
            $("#productName").val("");
            $("#productCategory").val("-1");
            $("#specification").val("-1");
            $("#packageSpecification").val("-1");
            $("#flavour").val("-1");
            $("#unit").val("-1");
            $("#packageUnit").val("-1");
            $("#volume").val("");
            $("#weight").val("");
            $("#productName").removeAttr("disabled");
            $("#productName").removeClass("layui-disabled");
            $("#productCategory").removeAttr("disabled");
            $("#flavour").removeAttr("disabled");
            $("#specification").removeAttr("disabled");
            $("#packageSpecification").removeAttr("disabled");
            form.render();

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
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewStrorageProduct"> <i class="layui-icon">&#xe654;</i>新料入库</button>
    <button class="layui-btn" id="adjustStorageProduct"> <i class="layui-icon">&#xe642;</i>库存调整</button>
</div>
<table id="storageProductTable" lay-filter="storageProductTable">
</table>
</body>
<div id="createNewStorageProductContent" style="display:none; padding: 10px 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
        <input type="hidden" id="productCode">
        <table class="laytable-dialog-table_2column" cellpadding="0" cellspacing="0">
            <tr>
                <td>物料</td>
                <td><input  class="layui-input"  lay-filter="productName" type="text" placeholder="点击选择物料" name="productName" id="productName"></input></td>
            </tr>
            <tr>
                <td>入库数量</td>
                <td>
                    <input  class="layui-input" lay-filter="quantity" type="number" placeholder="必填项" name="quantity" id="quantity"    autocomplete="off"></input>
                </td>
            </tr>
            <tr>
                <td>库存类别</td>
                <td><select lay-filter="type"  id="type" lay-search="" typeId="44"></select></td>
            </tr>
            <tr>
                <td>备注说明</td>
                <td>
                    <textarea placeholder="请输入内容" class="layui-textarea" id="remark" ></textarea></input>
                </td>
            </tr>
        </table>
    </form>
</div>
</html>
