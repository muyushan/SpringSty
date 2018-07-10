<%--
  Created by IntelliJ IDEA.
  User: Litsoft
  Date: 2018/6/16
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/js/layui/css/layui.css"/>"/>
    <script type="text/javascript" src="<c:url value="/js/layui/layui.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
    <style type="text/css" > /*解决layui 表格复选框不垂直居中问题*/
        [lay-skin=primary].layui-form-checkbox i {top:5px !important;}
    </style>
    <script>
        var webRoot="<c:out value="${WebRoot}"></c:out>";
    </script>
</head>
<body>

</body>
</html>
