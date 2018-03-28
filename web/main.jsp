<%--
  Created by IntelliJ IDEA.
  User: Litsoft
  Date: 2018/3/28
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<form enctype="multipart/form-data" action="main.do" method="post">
    <input name="uname" type="text">
    <input type="file" name="pic" accept="image/jpeg,image/gif,image/png"/><input type="submit" value="注册">
</form>
</body>
</html>
