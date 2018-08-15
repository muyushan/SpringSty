<%@ page import="com.sane.pkg.utils.SessionUtil" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="../common.jsp"></c:import>
<html>
<body>
<script>
    $(document).ready(function(){
        var root='<%=SessionUtil.getWebRoot(request)%>';
        var ex='${exception}';
        var msgbean=ex.substring(ex.indexOf("{"));
        var ex=JSON.parse(msgbean);
        if(ex.code=='timeout'){
            layui.use('layer', function(){
                var layer = layui.layer;
                layer.confirm('由于长时间未操作界面已经过期，点击【确定】按钮重新登录', {icon: 3, title:'提示'}, function(index){
                    window.top.location.href = root;
                });
            });
        }else {
            layui.use('layer', function () {
                var layer = layui.layer;
                layer.open({
                    title: '程序异常',
                    content: ex.message

                });
            });
        }
    });
</script>
</body>
</html>
