<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="common.jsp"></c:import>
<%@ page import="com.sane.pkg.utils.SessionUtil"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <style>
        ul.layui-tab-title li:first-child i{
            display: none;
        }
    </style>
</head>
<title>库存管理系统</title>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header layui-bg-black">
        <div class="layui-logo">库存管理系统</div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    <%=SessionUtil.getCurrentUserInfo()%>
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree "  lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">销售订单管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:operation.tabAdd('<c:url value="storagebill/mainPage.do"/>','销售订单管理')">销售订单管理</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">基础数据管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:operation.tabAdd('<c:url value="baseListType/showMainPage.do"/>','字典类别管理')">字典类别管理</a></dd>
                        <dd><a href="javascript:operation.tabAdd('<c:url value="baseListItem/baseListItemPage.do"/>','数据字典维护')">数据字典维护</a></dd>
                        <dd><a href="javascript:operation.tabAdd('<c:url value="baseProductInfo/baseProductInfoPage.do"/>','物料信息维护')">物料信息维护</a></dd>
                        <dd><a href="javascript:operation.tabAdd('<c:url value="customer/mainPagey.do"/>','客户信息维护')">客户信息维护</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">库存管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:operation.tabAdd('<c:url value="storageProduct/toChangeLogPage.do"/>','库存变更查询')">库存变更查询</a></dd>
                        <dd><a href="javascript:operation.tabAdd('<c:url value="storageProduct/mainPage.do"/>','出入库管理')">出入库管理</a></dd>
                        <dd><a href="javascript:operation.tabAdd('<c:url value="baseProductInfo/baseProductInfoPage.do"/>','损耗登记')">损耗登记</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>
    <div class="layui-body" style="overflow: hidden;">
        <!-- 内容主体区域 -->
            <div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="myTab">
                <ul class="layui-tab-title">
                    <li class="layui-this">首页</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">库存管理系统</div>
                </div>
            </div>
    </div>
    <div class="layui-footer">
        <center>SaneMu权所有&copy;QQ:917763727</center>
    </div>
</div>
<script>
    //JavaScript代码区域
    var element= layui.element;
    element.render();

    var operation = {
        tabAdd: function (url,title){
           var layIdLength= $("li[lay-id=tab_"+title+"]").length;
           if(layIdLength==1){
               element.tabChange("myTab", "tab_"+title);
           }else{
               var content='<iframe name="mainFrame" scrolling="no" frameborder="0"  src="'
                   + url
                   + '" style="width:100%;height:100%;"></iframe>';
               element.tabAdd('myTab',{
                   title: title,
                   content: content,
                   id: "tab_"+title
               });
               element.tabChange("myTab", "tab_"+title);
           }

        }
    }
</script>
</body>
</html>
