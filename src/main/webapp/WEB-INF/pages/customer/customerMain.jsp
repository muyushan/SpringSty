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
    <title>客户信息维护</title>
    <script>
        var table=layui.table;
        $(document).ready(function() {
                table.render({
                    elem: '#customerInfoTable',
                    id:'customerInfoTable',
                    method:'post',
//                    url:webRoot+"baseProductInfo/query.do",
                    page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                    height:'full-180',
                    cols: [[
                        {title:'序号',type:'numbers'},
                        {type:'checkbox'},
                        {field: 'productCode',title: '客户名称', width:250},
                        {field: 'productName',title: '物料名称', width:200},
                        {field: 'productCategoryTxt',title: '联系电话', width:100},
                        {field: 'flavourTxt',title: '联系地址', width:100},
                        {field: 'specificationTxt',title: '邮编', width:100},
                        {field: 'packageSpecificationTxt',title: '电子邮件地址', width:150}
                    ]]
                });
            /**
             * 加载下拉框
             */


            $("#createNewCustomerInfo").click(function(){
                layer.open({
                    type: 1,
                    closeBtn:1,
                    btn: ['保存', '关闭'],
                    yes:function(){saveNewOrEdit("add")},
                    btn2:function(index, layero){
                        layer.close(index);
//                        resetAddForm();
                    },
                    cancel: function(index, layero){
//                        resetAddForm();
                    },
                    skin: 'layui-layer-molv',
                    area: ['680px', '300px'],
                    title:'新增客户信息',
                    content: $('#createNewCustomerInfoContent')
                });
            });

            $("#editProductInfo").click(function(){
                showEditWindow();

            });

            $("#productName").blur(function(){
                generateProductCode();
            });
            layui.use('form', function(){
                var form = layui.form;
                form.on('select(flavour)', function(data){
                    generateProductCode();
                });
                form.on('select(specification)', function(data){
                    generateProductCode();
                });
                form.on('select(packageSpecification)', function(data){
                    generateProductCode();
                });
                form.on('select(productCategory)', function(data){
                    generateProductCode();
                });
            });


            $("#queryBtn").click(function(){
                search();
            });
        });

        function showEditWindow(){
            var checkedRow=table.checkStatus('baseProductInfoTable');
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
            var form = layui.form;
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
                content: $('#createNewCustomerInfoContent')
            });
        }

        function search(){
            var  productCode=$("#search_productCode").val();
            var  productName=$("#search_productName").val();
            var  productCategory=$("#search_productCategory").val();
            var  flavour=$("#search_flavour").val();
            var  specification=$("#search_specification").val();
            table.reload('baseProductInfoTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    productCode: productCode,
                    productName:productName,
                    productCategory:productCategory,
                    flavour:flavour,
                    specification:specification
                }
            });
        }


        function saveNewOrEdit(flag){
            var customerName=$("#customerName").val();
            var phoneNumber=$("#phoneNumber").val();
            var zipCode=$("#zipCode").val();
            var emailAddress=$("#emailAddress").val();
            var address=$("#address").val();

            if(customerName==""){
                layer.msg('请输联系人名称',{time:1000});
                return;
            }
            var mobile = /^1[3|5|8|7]\d{9}$/ , phone = /^0\d{2,3}-\d{7,8}(-\d{1,6})?$/;
            if(!(mobile.test(phoneNumber) || phone.test(phoneNumber))){
                layer.msg('请输入正确的联系电话',{time:1000});
                return;
            }

            var  customerInfo={};
            if(flag=="edit"){
                customerInfo.customerId=$("#customerId").val();
            }
            customerInfo.productCode=productCode;
            customerInfo.productName=productName;
            if(zipCode!=""){
                customerInfo.customerZipCode=zipCode;
            }
            if(emailAddress!=""){
                customerInfo.customerEmail=emailAddress;
            }
           if(address!=""){
               customerInfo.customerAddress=address;
           }

            var url="";
            if(flag=="add"){
                url="<c:url value="/baseProductInfo/add.do"/>";
            }else if(flag=="edit"){

                url="<c:url value="/baseProductInfo/edit.do"/>";
            }
            $.post(url,baseProduct,function(data){
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
            var form = layui.form;
            form.render();

        }
    </script>
</head>
<body>
<div class="layui-form">
    <table class="laytable-query-table">
        <tr>
            <td>客户名称</td>
            <td><input type="text" id="search_customerName" style="width:150px; " class="layui-input"/></td>
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewCustomerInfo"> <i class="layui-icon">&#xe654;</i>增加</button>
    <button class="layui-btn" id="editProductInfo"> <i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn" id="deleteProductInfo"> <i class="layui-icon">&#xe640;</i>删除</button>
</div>
<table id="customerInfoTable" lay-filter="customerInfoTable">
</table>
</body>
<div id="createNewCustomerInfoContent" style="display:none; padding: 10px 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
        <input type="hidden" id="customerId">
      <table class="laytable-dialog-table_4column" cellpadding="0" cellspacing="0">
          <tr>
              <td>客户名称</td>
              <td> <input  class="layui-input" lay-filter="customerName" type="text" placeholder="必填项" name="customerName" id="customerName"    autocomplete="off"></input>
              </td>
              <td>联系电话</td>
              <td>
                  <input  class="layui-input" lay-filter="phoneNumber" type="text" placeholder="" name="phoneNumber" id="phoneNumber"    autocomplete="off"></input>
              </td>
          </tr>
          <tr>
              <td>邮编</td>
              <td>
                  <input  class="layui-input" lay-filter="zipCode" type="text" placeholder="" name="zipCode" id="zipCode"    autocomplete="off"></input>
              </td>

              <td>电邮</td>
              <td>
                  <input  class="layui-input" lay-filter="emailAddress" type="text" placeholder="" name="emailAddress" id="emailAddress"    autocomplete="off"></input>
              </td>
          </tr>
          <tr>
              <td>联系地址</td>
              <td colspan="3">
                  <textarea placeholder="" class="layui-textarea" id="address" ></textarea></input>
              </td>

          </tr>


      </table>
    </form>
</div>
</html>
