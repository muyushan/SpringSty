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
        layui.use('layer', function(){
            var layer = layui.layer;
            layer.open({
                title: '程序异常',
                content: '${exception}',
                yes:function(index,layer){
                    window.top.location.href = root;
                }
            });
        });
    });
</script>
</body>
</html>
