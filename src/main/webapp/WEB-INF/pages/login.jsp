<%--
  Created by IntelliJ IDEA.
  User: Litsoft
  Date: 2018/3/28
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/js/bootstrap-4.1.1-dist/css/bootstrap.css"/>"/>
    <script type="text/javascript" src="<c:url value="/js/jquery-3.3.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/popper.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap-4.1.1-dist/js/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/util.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/css/signin.css"/>"/>
    <script type="text/javascript" src="<c:url value="/js/login.js"/>"></script>
    <title>登录</title>
</head>
<body class="text-center">
<div class="form-signin">
    <h1 class="h3 mb-3 font-weight-normal">请登录</h1>
    <label for="inputEmail" class="sr-only">用户名</label>
    <input type="text" id="inputEmail" class="form-control" value="123" placeholder="用户名/邮箱" autofocus/>
    <br/>
    <label for="inputPassword" class="sr-only">密码</label>
    <input type="password" id="inputPassword" class="form-control" placeholder="密码" value="ddd" />
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> 记住我
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" id="doLoginBtn">登录</button>
    <br/>
    <div id="loginErrorAlert" class="alert alert-warning">
        <span></span>
    </div>
    <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
</div>

</body>
</html>
