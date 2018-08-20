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
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/js/layui/css/layui.css"/>"/>
    <script type="text/javascript" src="<c:url value="/js/layui/layui.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-2.2.4.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
    <style type="text/css" > /*解决layui 表格复选框不垂直居中问题*/
        [lay-skin=primary].layui-form-checkbox i {top:5px !important;}
    </style>
    <script>
        var webRoot="<c:out value="${WebRoot}"></c:out>";
        $.ajaxSetup({
            complete: function(xhr,status) {
                var sessionStatus = xhr.getResponseHeader('sessionstatus');
                if(sessionStatus == 'timeout') {
                    layer.confirm('由于长时间未操作界面已经过期，点击【确定】按钮重新登录', {icon: 3, title:'提示'}, function(index){
                        window.top.location.href = webRoot;
                    });

                }
            }
        });
    </script>
</head>
<body>

</body>
</html>
