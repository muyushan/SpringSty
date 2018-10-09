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
    <title>销售订单管理</title>
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
                        {field: 'productName',title: '物料名称', width:200},
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
                    elem: '#storageProductTable',
                    id:'storageProductTable',
                    method:'post',
                    url:webRoot+"storageProduct/query.do",
                    page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                    height:'full-180',
                    cols: [[
                        {title:'序号',type:'numbers'},
                        {type:'checkbox'},
                        {field: 'productName',title: '单据号', width:100},
                        {field: 'productCategoryTxt',title: '单据状态', width:80},
                        {field: 'productCategoryTxt',title: '订单商品总量', width:80},
                        {field: 'productCategoryTxt',title: '已出库数量', width:80},
                        {field: 'productCategoryTxt',title: '未出库数量', width:80},
                        {field: 'specificationTxt',title: '客户', width:80},
                        {field: 'specificationTxt',title: '备注', width:80},
                        {field: 'flavourTxt',title: '创建时间', width:80},
                        {field: 'flavourTxt',title: '创建人', width:80},
                        {field: 'flavourTxt',title: '修改时间', width:80},
                        {field: 'flavourTxt',title: '修改人', width:80},
                        {field: 'flavourTxt',title: '查看详情', width:80},
                        {field: '',title: '包装单位', width:90,templet: function(d){return d.productInfoUD.packageUnitTxt}}
                    ]]
                });
            /**
             * 加载下拉框
             */
            loadCommonBoxList($("#type"));
            $("#createNewSaleBill").click(function(){
                layer.open({
                    type: 1,
                    closeBtn:1,
                    btn: ['保存', '关闭'],
                    yes:function(){saveNew()},
                    btn2:function(index, layero){
                        layer.close(index);
                        resetAddForm();
                    },
                    cancel: function(index, layero){
                        resetAddForm();
                    },
                    skin: 'layui-layer-molv',
                    area: ['600px', '400px'],
                    title:'新料入库',
                    content: $('#createNewSaleBillContent')
                });

                tableSelect.render({
                    elem: '#customerName',	//定义输入框input对象
                    searchKey: 'keyword',	//搜索输入框的name值 默认keyword
                    searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                    table: {
                        url:webRoot+"customer/query.do",
                        cols: [[
                            {type:'checkbox'},
                            {field: 'customerName',title: '客户名称', width:150},
                            {field: 'customerPhone',title: '联系电话', width:100}
                        ]]
                    },
                    done: function (elem, data) {
                        elem.val(data.data[0]["customerName"]);
                        $("#customerCode").val(data.data[0]["customerCode"]);
                    }
                });
            });

            $("#adjustStorageProduct").click(function(){
                showEditWindow();
            });

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
            $("#storageProductId").val(checkedRow.data[0]["storageProductId"]);
            $("#editProductName").val(checkedRow.data[0]["productInfoUD"]["productName"]);
            $("#editProductCategory").val(checkedRow.data[0]["productInfoUD"]["productCategoryTxt"]);
            $("#editFlavour").val(checkedRow.data[0]["productInfoUD"]["flavourTxt"]);
            $("#editSpecification").val(checkedRow.data[0]["productInfoUD"]["specificationTxt"]);
            $("#editPackageSpecification").val(checkedRow.data[0]["productInfoUD"]["packageSpecificationTxt"]);
            $("#editUnit").val(checkedRow.data[0]["productInfoUD"]["unitTxt"]);
            $("#editPackageUnit").val(checkedRow.data[0]["productInfoUD"]["packageUnitTxt"]);
            $("#editType").val(checkedRow.data[0]["typeTxt"]);
            $("#editQuantity").attr("placeholder","当前库存量"+checkedRow.data[0]["quantity"]);
            form.render();
            $(".layui-input.layui-disabled").attr("disabled",true);//将文本框禁止输入解决layUI问题
            layer.open({
                type: 1,
                closeBtn:1,
                btn: ['保存', '关闭'],
                yes:function(){saveEdit()},
                btn2:function(index, layero){
                    layer.close(index);
                    resetEditForm();
                },
                cancel: function(index, layer){
                    resetEditForm();
                },
                skin: 'layui-layer-molv',
                area: ['600px', '430px'],
                title:'库存调整',
                content: $('#editStorageProductContent')
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

        function saveNew(){
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
            var  url="<c:url value="/storageProduct/add.do"/>";
            $.post(url,storageProduct,function(data){
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

        function saveEdit(){
            var storageProductId=$("#storageProductId").val();
            var changeType=$("#changeType").val();
            var quantity= $("#editQuantity").val();
            var  remark=$("#editRemark").val();
            var change={};
            change.storageProductId=storageProductId;
            change.quantity=quantity;
            change.changeType=changeType;
            change.remark=remark;

            var  url="<c:url value="/storageProduct/adjustQuantity.do"/>";
            $.post(url,change,function(data){
                if(data.code=="200"){
                    resetEditForm();
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

        function resetAddForm(){
            $("#productCode").val("");
            $("#productName").val("");
            $("#quantity").val("");
            $("#remark").val("");
            $("#type").val("-1");
            form.render();
        }
        function resetEditForm(){
            $("#storageProductId").val("");
            $("#changeType").val(-1);
            $("#editQuantity").val("");
            $("#editRemark").val("");
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
    <button class="layui-btn" id="createNewSaleBill"> <i class="layui-icon">&#xe654;</i>新建销售单</button>
    <button class="layui-btn" id="editSaleBill"> <i class="layui-icon">&#xe654;</i>新建销售单</button>
    <button class="layui-btn" id="auditSaleBill"> <i class="layui-icon">&#xe642;</i>销售单审核</button>
    <button class="layui-btn" id="antiAuditSaleBill"> <i class="layui-icon">&#xe642;</i>销售单反审核</button>
</div>
<table id="storageProductTable" lay-filter="storageProductTable">
</table>
</body>
<div id="createNewSaleBillContent" style="display:none; padding: 10px 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
        <input type="hidden" id="customerCode">
        <table class="laytable-dialog-table_2column" cellpadding="0" cellspacing="0">
            <tr>
                <td >客户</td>
                <td><input  class="layui-input"  lay-filter="customerName" type="text" placeholder="点击选择客户" name="customerName" id="customerName"></input></td>
            </tr>
            <tr>
                <td colspan="2">
                    <table class="layui-table" lay-even="" lay-skin="nob">
                        <colgroup>
                            <col width="300">
                            <col width="80">
                            <col>
                        </colgroup>
                        <thead>
                        <tr>
                            <th>产品</th>
                            <th>数量</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>点击选择产品</td>
                            <td>5</td>
                        </tr>
                        </tbody>
                    </table>

                </td>
            </tr>
            <tr>
                <td style="text-align: left;">备注说明</td>
                <td>
                    <textarea placeholder="请输入内容" class="layui-textarea" id="remark" ></textarea></input>
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="editStorageProductContent" style="display:none; padding: 10px 10px;">
    <form class="layui-form" action="" lay-filter="editForm">
        <input type="hidden" id="storageProductId">
        <table class="laytable-dialog-table_4column" cellpadding="0" cellspacing="0">
            <tr>
                <td>物料</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editProductName"></input></td>
                <td>库存类别</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editType"></input></td>
            </tr>
            <tr>
                <td>物料类别</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editProductCategory"></input></td>
                <td>口味</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editFlavour"></input></td>
            </tr>
            <tr>
                <td>规格</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editSpecification"></input></td>
                <td>包装规格</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editPackageSpecification"></input></td>
            </tr>
            <tr>
                <td>单位</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editUnit"></input></td>
                <td>包装单位</td>
                <td><input  class="layui-input layui-disabled"   type="text"   id="editPackageUnit"></input></td>
            </tr>
            <tr>
                <td>调整类型</td>
                <td>
                    <select id="changeType" lay-filter="aihao">
                        <option value="IN" selected>调增</option>
                        <option value="OUT" >调减</option>
                    </select>
                </td>
                <td>调整数量</td>
                <td>
                    <input  class="layui-input"  type="number" placeholder="必填项"  id="editQuantity"    autocomplete="off"></input>
                </td>
            </tr>
            <tr>
            </tr>
            <tr>
                <td>备注说明</td>
                <td colspan="3">
                    <textarea placeholder="请输入库存调整说明" class="layui-textarea" id="editRemark" ></textarea></input>
                </td>
            </tr>
        </table>
    </form>
</div>
</html>
