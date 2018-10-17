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
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>销售订单管理</title>
    <link rel="stylesheet" href="<c:url value="/css/print.min.css"/>"/>
    <script type="text/javascript" src="<c:url value="/js/print.min.js"/>"></script>
    <script>
        var table = layui.table;
        var tableSelect = layui.tableSelect;
        var form = layui.form;
        var laydate = layui.laydate;
        $(document).ready(function () {
            tableSelect.render({
                elem: '#search_customerName',	//定义输入框input对象
                searchKey: 'keyword',	//搜索输入框的name值 默认keyword
                searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                table: {
                    url: webRoot + "customer/query.do",
                    cols: [[
                        {type: 'checkbox'},
                        {field: 'customerName', title: '客户名称', width: 150},
                        {field: 'customerPhone', title: '联系电话', width: 200}
                    ]]
                },
                done: function (elem, data) {
                    elem.val(data.data[0]["customerName"]);
                    $("#search_customerCode").val(data.data[0]["customerCode"]);
                }
            });
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
            setDefaultDate();

            table.render({
                elem: '#storageBillTable',
                id: 'storageBillTable',
                method: 'post',
                url: webRoot + "storagebill/queryStorageBill.do",
                page: {limits: [10, 20, 50, 100], prev: "上一页", next: "下一页"},
                height: 'full-180',
                cols: [[
                    {title: '序号', type: 'numbers'},
                    {type: 'checkbox'},
                    {
                        field: 'storageProductBillCode', title: '单据号', width: 150, templet: function (record) {
                        return "<a href=javascript:showBillDetail('" + record.storageProductBillCode + "') class=\"layui-table-link\">" + record.storageProductBillCode + "</a>"
                    }
                    },
                    {field: 'billStatusTxt', title: '单据状态', width: 100},
                    {field: 'quantity', title: '订单总量', width: 100},
                    {field: 'outQuantity', title: '已出库数量', width: 100},
                    {field: 'residualQuantity', title: '待出库数量', width: 100},
                    {field: 'customerName', title: '客户', width: 100},
                    {field: 'remark', title: '备注', width: 150},
                    {
                        field: 'createDate', title: '创建时间', width: 180, templet: function (record) {
                        return formatDateTime(record.createDate);
                    }
                    },
                    {field: 'creator', title: '创建人', width: 100},
                    {
                        field: 'modifyDate', title: '修改时间', width: 180, templet: function (record) {
                        return formatDateTime(record.modifyDate);
                    }
                    },
                    {field: 'modifyer', title: '修改人', width: 100}
                ]]
            });
            //加载下拉框
            loadCommonBoxList($("#search_BillStatus"));
            $("#createNewSaleBill").click(function () {
                showCreateNewWindow("create");
            });
            $("#editSaleBill").click(function () {
                showEditWindow();
            });
            $("#queryBtn").click(function () {
                search();
            });
            $("#resetBtn").click(function () {
                setDefaultDate();
                 $("#search_productCode").val("");
                 $("#search_productName").val("");
                 $("#search_BillStatus").val("-1");
                 $("#search_BillCode").val("");
                 $("#search_customerCode").val("");
                 $("#search_customerName").val("");

            });

            $("#antiAuditSaleBill").click(function () {
                var checkedRow = table.checkStatus('storageBillTable');
                if (checkedRow.data.length == 0) {
                    layer.msg('请选择要编辑的记录', {time: 1000});
                    return;
                }

                var codeList = new Array();
                for (var i in checkedRow.data) {
                    codeList.push(checkedRow.data[i]["storageProductBillCode"]);
                }
                showLoading();
                $.get(webRoot + "storagebill/antiAuditSaleBill.do?billCodeList[]=" + codeList.join(), function (returnData) {

                    if (returnData.code == "200") {
                        layer.msg('反审核完成', {time: 1000});
                        search();
                    } else {
                        layer.open({
                            title: '反审核失败'
                            , content: returnData.message
                        });
                    }
                });
            });
            $("#auditSaleBill").click(function () {
                var checkedRow = table.checkStatus('storageBillTable');
                if (checkedRow.data.length == 0) {
                    layer.msg('请选择要编辑的记录', {time: 1000});
                    return;
                }

                var codeList = new Array();
                for (var i in checkedRow.data) {
                    codeList.push(checkedRow.data[i]["storageProductBillCode"]);
                }

                showLoading();
                $.get(webRoot + "storagebill/auditSaleBill.do?billCodeList[]=" + codeList.join(), function (returnData) {
                    if (returnData.code == "200") {
                        layer.msg('审核完成', {time: 1000});
                        search();
                    } else {
                        layer.open({
                            title: '审核失败'
                            , content: returnData.message
                        });
                    }
                });
            });
            $("#confirmBillOut").click(function () {
                var checkedRow = table.checkStatus('storageBillTable');
                if (checkedRow.data.length == 0) {
                    layer.msg('请选择要编辑的记录', {time: 1000});
                    return;
                }

                var codeList = new Array();
                for (var i in checkedRow.data) {
                    codeList.push(checkedRow.data[i]["storageProductBillCode"]);
                }

                showLoading();
                $.get(webRoot + "storagebill/confirmBillByCode.do?billCodeList[]=" + codeList.join(), function (returnData) {
                    if (returnData.code == "200") {
                        layer.msg('出库确认完成', {time: 1000});
                        search();
                    } else {
                        layer.open({
                            title: '出库确认失败'
                            , content: returnData.message
                        });
                    }
                });
            });
        });
        function showCreateNewWindow(flag) {
            var title = "";
            if (flag == "create") {
                title = "创建销售出库单";
            } else if (flag == "edit") {
                title = "修改销售出库单";
            }
            layer.open({
                type: 1,
                closeBtn: 1,
                scrollbar: true,
                offset: '40px',
                btn: ['保存', '关闭'],
                yes: function () {
                    saveNew();
                },
                btn2: function (index, layero) {
                    layer.close(index);
                    resetAddForm();
                },
                cancel: function (index, layero) {
                    resetAddForm();
                },
                skin: 'layui-layer-molv',
                area: ['700px', '400px'],
                title: title,
                content: $('#createNewSaleBillContent')
            });

            tableSelect.render({
                elem: '#productName1',	//定义输入框input对象
                searchKey: 'keyWord',	//搜索输入框的name值 默认keyword
                searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                table: {
                    url: webRoot + "baseProductInfo/query.do",
                    cols: [[
                        {type: 'checkbox'},
                        {field: 'productName', title: '物料名称', width: 200},
                        {field: 'productCategoryTxt', title: '物料类别', width: 80},
                        {field: 'flavourTxt', title: '口味', width: 80},
                        {field: 'specificationTxt', title: '规格', width: 80},
                        {field: 'packageSpecificationTxt', title: '包装规格', width: 80}
                    ]]
                },
                done: function (elem, data) {
                    elem.val(data.data[0]["productName"]);
                    $("#selectedProductCode").val(data.data[0]["productCode"]);
                    $("#selectedProductName").val(data.data[0]["productName"]);
                    $("#selectedFlavourTxt").val(data.data[0]["flavourTxt"]);
                    $("#selectedSpecificationTxt").val(data.data[0]["specificationTxt"]);
                }
            });
            tableSelect.render({
                elem: '#customerName',	//定义输入框input对象
                searchKey: 'keyword',	//搜索输入框的name值 默认keyword
                searchPlaceholder: '关键词搜索',	//搜索输入框的提示文字 默认关键词搜索
                table: {
                    url: webRoot + "customer/query.do",
                    cols: [[
                        {type: 'checkbox'},
                        {field: 'customerName', title: '客户名称', width: 150},
                        {field: 'customerPhone', title: '联系电话', width: 200}
                    ]]
                },
                done: function (elem, data) {
                    elem.val(data.data[0]["customerName"]);
                    $("#selectedCustomerCode").val(data.data[0]["customerCode"]);
                }
            });

            $("#quantity1").keydown(function (event) {
                if (event.keyCode == 13) {
                    var quantity = $("#quantity1").val();
                    if (!isNaN(quantity) && parseInt(quantity) > 0) {
                        var productCode = $("#selectedProductCode").val();
                        if ($("span#" + productCode).length > 0) {
                            layer.msg('该物料产品已经存在，不能重复选择', {time: 1000});
                            return;
                        }
                        ;
                        var productName = $("#selectedProductName").val();
                        var flavourTxt = $("#selectedFlavourTxt").val();
                        var specificationTxt = $("#selectedSpecificationTxt").val();
                        var sumText = "";
                        if (productCode != "") {
                            sumText = productName + "," + flavourTxt + "," + specificationTxt + "," + quantity;
                            var sp = "<span class=\"layui-badge layui-badge-cursor\" id='" + productCode + "'quantity='" + quantity + "'ondblclick ='removeSelected(this)'>" + sumText + "</span>";
                            $("#selectedBox").append(sp);
                        }
                    }

                }
            });
        }
        function removeSelected(cur) {
            $(cur).remove();
        }
        function showBillDetail(billCode) {
            var url = webRoot + "storagebill/queryStorageBillDetail.do?billCode=" + billCode;
            table.render({
                elem: '#storageBillDetailTable',
                id: 'storageBillDetailTable',
                method: 'post',
                url: url,
                height: 330,
                cols: [[
                    {title: '序号', type: 'numbers'},
                    {field: 'productName', title: '产品名称', width: 100},
                    {field: 'flavourTxt', title: '口味', width: 100},
                    {field: 'specificationTxt', title: '规格', width: 100},
                    {field: 'packageSpecificationTxt', title: '包装规格', width: 100},
                    {field: 'quantity', title: '订单总量', width: 100},
                    {field: 'outQuantity', title: '已出库数量', width: 100},
                    {field: 'unitTxt', title: '单位', width: 100},
                    {field: 'packageUnitTxt', title: '包装单位', width: 100}
                ]]
            });

            layer.open({
                type: 1,
                closeBtn: 1,
                skin: 'layui-layer-molv',
                offset: '10px',
                area: ['890px', '440px'],
                btn: ['打印出库单', '关闭'],
                yes: function () {
                    printJS('printTable', 'html');
                },
                btn2: function (index, layero) {
                    layer.close(index);
                },
                title: '销售出库单' + billCode + "详情",
                content: $('#showSaleBillDetailContent')
            });
        }
        function showEditWindow() {
            var checkedRow = table.checkStatus('storageBillTable');
            if (checkedRow.data.length == 0) {
                layer.msg('请选择一条要编辑的记录', {time: 1000});
                return;
            }
            if (checkedRow.data.length > 1) {
                layer.msg('只能选择一条记录', {time: 1000});
                return;
            }
            var billCode = checkedRow.data[0]["storageProductBillCode"];
            var url = webRoot + "storagebill/queryStorageBillDetail.do?billCode=" + billCode;
            $.get(url, function (returnData) {
                var detailList = returnData.data;
                for (var i in detailList) {
                    var sumText = detailList[i]["productName"] + "," + detailList[i]["flavourTxt"] + "," + detailList[i]["specificationTxt"] + "," + detailList[i]["quantity"];
                    var sp = "<span class=\"layui-badge layui-badge-cursor\" id='" + detailList[i]["productCode"] + "'quantity='" + detailList[i]["quantity"] + "'ondblclick ='removeSelected(this)'>" + sumText + "</span>";
                    $("#selectedBox").append(sp);
                }
            });
            $("#selectedCustomerBillCode").val(billCode);
            $("#selectedCustomerCode").val(checkedRow.data[0]["customerCode"]);
            $("#customerName").val(checkedRow.data[0]["customerName"]);
            $("#remark").val(checkedRow.data[0]["remark"]);
            $.get(webRoot + "storagebill/queryBillByCode.do", {billCode: billCode}, function (returnData) {
                if (returnData.billStatus == "AJAA") {
                    showCreateNewWindow("edit");
                } else {
                    layer.msg('只有新建待审核的出库单才能修改', {time: 1000});
                    resetAddForm();
                    return;
                }

            });

        }
        function search() {
            var productCode = $("#search_productCode").val();
            var options=$("#search_BillStatus option:selected");
            var obj=options.attr('data');
            obj=JSON.parse(obj);
            var billStatus=obj.listValue;
            var storageProductBillCode=$("#search_BillCode").val();
            var customerCode=$("#search_customerCode").val();
            var createDateBegin=$("#createDateBegin").val();
            var createDateEnd=$("#createDateEnd").val();
            table.reload('storageBillTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    beginDate:createDateBegin,
                    endDate:createDateEnd,
                    customerCode:customerCode,
                    productCode: productCode,
                    storageProductBillCode:storageProductBillCode,
                    billStatus:billStatus
                }
            });
        }
        function saveNew() {
            var customerBill = {};
            var detailArr = new Array();
            var customerCode = $("#selectedCustomerCode").val();
            var customerBillCode = $("#selectedCustomerBillCode").val();

            if (customerCode == "") {
                layer.msg('请选择一个客户', {time: 1000});
                return;
            }
            var remark = $("#remark").val();
            if (customerBillCode != "") {
                customerBill.storageProductBillCode = customerBillCode;
            }
            customerBill.customerCode = customerCode;
            customerBill.remark = remark;
            var arr = $("span.layui-badge-cursor");
            if (arr.length == 0) {
                layer.msg('请至少选择一个物料', {time: 1000});
                return;
            }
            $("span.layui-badge-cursor").each(function () {
                var detail = {};
                detail.productCode = $(this).attr("id");
                detail.quantity = $(this).attr("quantity");
                detailArr.push(detail);

            });
            var url = "<c:url value="/storagebill/addOrEditStorageBill.do"/>";

            var obj = {customerBill: customerBill, customerBillDetailList: detailArr};
            showLoading();
            $.ajax({
                url: url,
                type: "post",
                data: JSON.stringify(obj),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
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
                }
            });
        }
        function resetAddForm() {
            $("#selectedCustomerBillCode").val("");
            $("#selectedCustomerCode").val("");
            $("#selectedProductCode").val("");
            $("#selectedProductName").val("");
            $("#selectedFlavourTxt").val("");
            $("#selectedSpecificationTxt").val("");
            $("#customerName").val("");
            $("#remark").val("");
            $("#quantity1").val("");
            $("#selectedBox").html("");
            form.render();
        }
        function  setDefaultDate() {
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
        }
    </script>
</head>
<body>
<div class="layui-form">
    <table class="laytable-query-table">
        <tr>
            <td>出库单号</td>
            <td>
                <input type="text" id="search_BillCode" style="width:100px; " class="layui-input"/>
            </td>
            <td>出库单状态</td>
            <td>
                <select lay-filter="search_BillStatus"  id="search_BillStatus"  lay-search="" typeId="45"></select>
            </td>
            <td>物料</td>
            <td>
                <input type="text" id="search_productName" style="width:100px; " class="layui-input"/>
                <input type="hidden" id="search_productCode">
            </td>
            <td>客户</td>
            <td>
                <input type="text" id="search_customerName" style="width:100px; " class="layui-input"/>
                <input type="hidden" id="search_customerCode">
            </td>
                <td>创建时间</td>
                <td >
                    <input type="text" class="layui-input" id="createDateBegin"/>
                </td>
                <td>至</td>
                <td>
                    <input type="text" class="layui-input" id="createDateEnd"/>
                </td>
            <td >
                <button class="layui-btn" id="queryBtn">查询</button>
                <button class="layui-btn" id="resetBtn">重置</button>
            </td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewSaleBill"><i class="layui-icon">&#xe654;</i>新建</button>
    <button class="layui-btn" id="editSaleBill"><i class="layui-icon">&#xe642;</i>修改</button>
    <button class="layui-btn" id="auditSaleBill"><i class="layui-icon">&#x1005;</i>审核</button>
    <button class="layui-btn" id="antiAuditSaleBill"><i class="layui-icon">&#x1006;</i>反审核</button>
    <button class="layui-btn" id="confirmBillOut"><i class="layui-icon">&#x1005;</i>出库确认</button>
</div>
<table id="storageBillTable" lay-filter="storageBillTable">
</table>
</body>
<div id="createNewSaleBillContent" style="display:none; padding: 10px 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
        <table class="laytable-dialog-table_2column" cellpadding="0" cellspacing="0">
            <tr>
                <td style="width: 40px;">客户</td>
                <td><input class="layui-input" lay-filter="customerName" autocomplete="off" type="text"
                           placeholder="点击选择客户" name="customerName" id="customerName"></input></td>
            </tr>
            <tr>
                <td colspan="2" style="padding-left: 40px;">
                    <input id="selectedCustomerBillCode" type="hidden"></input>
                    <input id="selectedCustomerCode" type="hidden"></input>
                    <input id="selectedProductCode" type="hidden"></input>
                    <input id="selectedProductName" type="hidden"></input>
                    <input id="selectedFlavourTxt" type="hidden"></input>
                    <input id="selectedSpecificationTxt" type="hidden"></input>
                    <input type="text" class="layui-input" autocomplete="off" style="width: 380px; display: inline;"
                           placeholder="点击选择物料" id="productName1">
                    &nbsp;&nbsp;<input type="number" class="layui-input" id="quantity1"
                                       style="width: 180px; display: inline;" placeholder="输入数量，回车确认">
                </td>
            </tr>
            <tr>
                <td colspan="2" style="height: 100px;padding-left: 40px;">
                    <fieldset class="layui-elem-field">
                        <legend>已选择物料及数量，双击可移除</legend>
                        <div class="layui-field-box" id="selectedBox">

                        </div>
                    </fieldset>


                </td>
            </tr>
            <tr>
                <td style="width: 40px;">备注说明</td>
                <td>
                    <textarea placeholder="请输入内容" class="layui-textarea" id="remark"></textarea></input>
                </td>
            </tr>
        </table>
    </form>
</div>

<div id="showSaleBillDetailContent" style="display:none; padding: 10px 10px;">
    <table id="storageBillDetailTable" lay-filter="storageBillDetailTable">
    </table>
</div>
<table id="printTable" border="1px" width="100%" style="visibility: hidden;">
    <thead>
    <tr>
        <th>河南维淼饮品有限公司出库清单</th>
    </tr>
    </thead>
</table>
</html>
