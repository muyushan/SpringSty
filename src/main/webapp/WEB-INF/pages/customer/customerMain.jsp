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
        var form = layui.form;
        $(document).ready(function() {
            table.render({
                    elem: '#customerInfoTable',
                    id:'customerInfoTable',
                    method:'post',
                    url:webRoot+"customer/query.do",
                    page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                    height:'full-180',
                    cols: [[
                        {title:'序号',type:'numbers'},
                        {type:'checkbox'},
                        {field: 'customerName',title: '客户名称', width:200},
                        {field: 'customerPhone',title: '联系电话', width:150},
                        {field: 'customerAddress',title: '联系地址', width:300},
                        {field: 'customerZipCode',title: '邮编', width:100},
                        {field: 'customerEmail',title: '电子邮件地址', width:230}
                    ]]
                });

            $("#createNewCustomerInfo").click(function(){
                layer.open({
                    type: 1,
                    closeBtn:1,
                    btn: ['保存', '关闭'],
                    yes:function(){saveNewOrEdit("add")},
                    btn2:function(index, layero){
                        layer.close(index);
                        resetAddForm();
                    },
                    cancel: function(index, layero){
                        resetAddForm();
                    },
                    skin: 'layui-layer-molv',
                    area: ['680px', '300px'],
                    offset:'10px',
                    title:'新增客户信息',
                    content: $('#createNewCustomerInfoContent')
                });
            });

            $("#editCustomerInfo").click(function(){
                showEditWindow();
            });

            $("#queryBtn").click(function(){
                search();
            });
            $("#deleteCustomerInfo").click(function(){
                deleteCustomer();
            });

        });
        function showEditWindow(){
            var checkedRow=table.checkStatus('customerInfoTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择一条要编辑的记录',{time:1000});
                return;
            }
            if(checkedRow.data.length>1){
                layer.msg('只能选择一条记录',{time:1000});
                return;
            }
            $("#customerId").val(checkedRow.data[0]["customerId"]);

            $("#customerName").val(checkedRow.data[0]["customerName"]);
            $("#phoneNumber").val(checkedRow.data[0]["customerPhone"]);
            $("#zipCode").val(checkedRow.data[0]["customerZipCode"]);
           $("#emailAddress").val(checkedRow.data[0]["customerEmail"]);
            $("#address").val(checkedRow.data[0]["customerAddress"]);
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
                offset:'10px',
                title:'修改客户信息',
                content: $('#createNewCustomerInfoContent')
            });
        }
        function search(){
            var  customerName=$("#search_customerName").val();
            var  phoneNo=$("#search_phone").val();

            table.reload('customerInfoTable', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                ,where: {
                    customerName: customerName,
                    customerPhone:phoneNo
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
            customerInfo.customerPhone=phoneNumber;
            if(flag=="edit"){
                customerInfo.customerId=$("#customerId").val();
            }
            customerInfo.customerName=customerName;
            if(zipCode!=""){
                customerInfo.customerZipCode=zipCode;
            }
            if(emailAddress!=""){
                customerInfo.customerEmail=emailAddress;
            }
           if(address!=""){
               customerInfo.customerAddress=address;
           }

            var url="<c:url value="/customer/addOredit.do"/>";
            $.post(url,customerInfo,function(data){
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
            $("#customerName").val("");
            $("#customerId").val("");
            $("#phoneNumber").val("");
            $("#zipCode").val("");
            $("#emailAddress").val("");
            $("#address").val("");
            form.render();

        }
        function deleteCustomer(){
            var checkedRow=table.checkStatus('customerInfoTable');
            if(checkedRow.data.length==0){
                layer.msg('请选择要删除的联系人记录',{time:1000});
                return;
            }
            var ids=new Array();
            for(i=0;i<checkedRow.data.length;i++){
                ids.push(checkedRow.data[i]["customerId"]);
            }
            var url="<c:url value="/customer/delete.do"></c:url>";
            $.post(url,{idList:ids},function(data){
                if(data.code=="200"){
                    search();
                }
            });
        }

    </script>
</head>
<body>
<div class="layui-form">
    <table class="laytable-query-table">
        <tr>
            <td>客户名称</td>
            <td><input type="text" id="search_customerName" style="width:150px; " class="layui-input"/></td>
            <td>客户电话</td>
            <td><input type="text" id="search_phone" style="width:150px; " class="layui-input"/></td>
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewCustomerInfo"> <i class="layui-icon">&#xe654;</i>增加</button>
    <button class="layui-btn" id="editCustomerInfo"> <i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn" id="deleteCustomerInfo"> <i class="layui-icon">&#xe640;</i>删除</button>
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
                  <input  class="layui-input" lay-filter="phoneNumber" type="text" placeholder="必填项" name="phoneNumber" id="phoneNumber"    autocomplete="off"></input>
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
