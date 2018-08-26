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
    <script>
        var table;
        $(document).ready(function() {
            layui.use('table', function(){
                table = layui.table;
                table.render({
                    elem: '#baseProductInfoTable',
                    id:'baseProductInfoTable',
                    method:'post',
                    url:webRoot+"baseProductInfo/query.do",
                    page:{limits:[10,20,50,100],prev:"上一页",next:"下一页"},
                    height:'full-180',
                    cols: [[
                        {title:'序号',type:'numbers'},
                        {type:'checkbox'},
                        {field: 'productCode',title: '物料编码', width:250},
                        {field: 'productName',title: '物料名称', width:200},
                        {field: 'productCategoryTxt',title: '物料类别', width:100},
                        {field: 'flavourTxt',title: '口味', width:100},
                        {field: 'specificationTxt',title: '规格', width:100},
                        {field: 'packageSpecificationTxt',title: '包装规格', width:100},
                        {field: 'unitTxt',title: '单位', width:100},
                        {field: 'packageUnitTxt',title: '包装单位', width:100},
                        {field: 'weight',title: '重量', width:80},
                        {field: 'volume',title: '体积', width:80}
                    ]]
                });
            });
            /**
             * 加载下拉框
             */
            loadCommonBoxList($("#flavour"));
            loadCommonBoxList($("#search_flavour"));
            loadCommonBoxList($("#specification"));
            loadCommonBoxList($("#packageSpecification"));
            loadCommonBoxList($("#search_specification"));
            loadCommonBoxList($("#unit"));
            loadCommonBoxList($("#packageUnit"));
            loadCommonBoxList($("#productCategory"));
            loadCommonBoxList($("#search_productCategory"));

            $("#createNewProductInfo").click(function(){
                layer.open({
                    type: 1,
                    closeBtn:1,
                    btn: ['保存', '关闭'],
                    yes:function(){save()},
                    btn2:function(index, layero){
                        layer.close(index);
//                        resetAddForm();
                    },
                    cancel: function(index, layero){
//                        resetAddForm();
                    },
                    skin: 'layui-layer-molv',
                    area: ['680px', '340px'],
                    title:'创建基础物料',
                    content: $('#createNewProductInfoContent')
                });
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
        function generateProductCode(){
            var productName=$("#productName").val();
            var productCategory=$("#productCategory").val();
            var flavour=$("#flavour").val();
            var specification=$("#specification").val();
            var packageSpecification=$("#packageSpecification").val();
            var productCode="";
            if(productName!=""){
               productCode=pinyin.getCamelChars(productName);
            }

            if(productCategory!=-1){
                var options=$("#productCategory option:selected");
                var obj=options.attr('data');
                obj=JSON.parse(obj);
                productCode=productCode.concat(obj.listValue);
            }
            if(flavour!=-1){
                var options=$("#flavour option:selected");
                var obj=options.attr('data');
                obj=JSON.parse(obj);
                productCode=productCode.concat(obj.listValue);
            }
            if(specification!=-1){
                var options=$("#specification option:selected");
                var obj=options.attr('data');
                obj=JSON.parse(obj);
                productCode=productCode.concat(obj.listValue);
            }
            if(packageSpecification!=-1){
                var options=$("#packageSpecification option:selected");
                var obj=options.attr('data');
                obj=JSON.parse(obj);
                productCode=productCode.concat(obj.listValue);
            }
            $("#productCode").val(productCode);
        }

        function save(){
            var productCode=$("#productCode").val();
            var productName=$("#productName").val();
            var flavour=$("#flavour").val();
            var specification=$("#specification").val();
            var packageSpecification=$("#packageSpecification").val();
            var productCategory=$("#productCategory").val();
            var unit=$("#unit").val();
            var packageUnit=$("#packageUnit").val();
            var volume=$("#volume").val();
            var weight=$("#weight").val();
            var  baseProduct={};
            baseProduct.productCode=productCode;
            baseProduct.productName=productName;
            if(productCategory!="-1"){
                baseProduct.productCategory=productCategory;
            }
            if(flavour!="-1"){
                baseProduct.flavour=flavour;
            }
            if(specification!="-1"){
                baseProduct.specification=specification;
            }
            if(packageSpecification!="-1"){
                baseProduct.packageSpecification=packageSpecification;
            }

            if(unit!="-1"){
                baseProduct.unit=unit;
            }
            if(packageUnit!="-1"){
                baseProduct.packageUnit=packageUnit;
            }
            if(volume!=""){
                baseProduct.volume=volume;
            }
            if(weight!=""){
                baseProduct.weight=weight;
            }
            var url="<c:url value="/baseProductInfo/add.do"/>";
            $.post(url,baseProduct,function(data){
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
    </script>
</head>
<body>
<div class="layui-form">
    <table class="laytable-query-table">
        <tr>
            <td>物料编码</td>
            <td><input type="text" id="search_productCode" style="width:150px; " class="layui-input"/></td>
            <td>物料名称</td>
            <td><input type="text" id="search_productName" style="width:150px; " class="layui-input"/></td>
            <td>物料类别</td>
            <td><select lay-filter="search_productCategory"  id="search_productCategory" lay-search="" typeId="42"></select>
            </td>
            <td>口味</td>
            <td><select lay-filter="flavour"  id="search_flavour"  lay-search="" typeId="35"></select></td>
            <td>产品规格</td>
            <td><select lay-filter="specification"  id="search_specification"  lay-search="" typeId="36"></select></td>
            <td><button class="layui-btn" id="queryBtn">查询</button></td>
        </tr>
    </table>
</div>
<!--分隔条-->
<hr class="layui-bg-gray">
<div class="layui-btn-group">
    <button class="layui-btn" id="createNewProductInfo"> <i class="layui-icon">&#xe654;</i>增加</button>
    <button class="layui-btn" id="editProductInfo"> <i class="layui-icon">&#xe642;</i>编辑</button>
    <button class="layui-btn" id="deleteProductInfo"> <i class="layui-icon">&#xe640;</i>删除</button>
    <button class="layui-btn" id="uploadProductInfo"> <i class="layui-icon layui-icon-upload"></i>批量上传</button>
</div>
<table id="baseProductInfoTable" lay-filter="baseProductInfoTable">
</table>
</body>
<div id="createNewProductInfoContent" style="display:none; padding: 10px 10px;">
    <form class="layui-form" action="" lay-filter="addForm">
      <table class="laytable-dialog-table_4column" cellpadding="0" cellspacing="0">
          <tr>
              <td>物料编码</td>
              <td><input  class="layui-input layui-disabled" disabled lay-filter="productCode" type="text" placeholder="无需填写自动生成" name="productCode" id="productCode"    autocomplete="off"></input></td>
              <td>物料名称</td>
              <td>
                  <input  class="layui-input" lay-filter="productName" type="text" placeholder="必填项" name="productName" id="productName"    autocomplete="off"></input>
              </td>
          </tr>
          <tr>
              <td>物料类别</td>
              <td>
                  <select lay-filter="productCategory"  id="productCategory" lay-search="" typeId="42"></select>
              </td>

              <td>规格</td>
              <td>
                  <select lay-filter="specification"  id="specification" lay-search="" typeId="36"></select>
              </td>
          </tr>
          <tr>
              <td>包装规格</td>
              <td>
                  <select lay-filter="packageSpecification"  id="packageSpecification" lay-search="" typeId="38"></select>
              </td>
              <td>口味</td>
              <td>
                  <select lay-filter="flavour"  id="flavour" lay-search="" typeId="35"></select>
              </td>
          </tr>
          <tr>
              <td>单位</td>
              <td>
                  <select lay-filter="unit"  id="unit" lay-search="" typeId="37"></select>
              </td>
              <td>包装单位</td>
              <td>
                  <select lay-filter="packageUnit"  id="packageUnit" lay-search="" typeId="40"></select>
              </td>
          </tr>
          <tr>
              <td>体积</td>
              <td>
                  <input  class="layui-input" lay-filter="volume"  id="volume" lay-filter="volume" type="number" placeholder="非必填项"></input>
              </td>
              <td>重量</td>
              <td>
                  <input  class="layui-input" lay-filter="weight"  id="weight" lay-filter="weight" type="number" placeholder="非必填项"></input>
              </td>
          </tr>
      </table>
    </form>
</div>
</html>
