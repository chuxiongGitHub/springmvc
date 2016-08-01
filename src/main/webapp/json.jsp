<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/1
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="application/javascript" src="<%=request.getContextPath()%>/res/js/jquery-3.1.0.js"></script>
</head>
<script type="application/javascript">
    $(function(){
       var urlStr= <%=request.getContextPath()%>/json/<%=request.getParameter("userId")%>
        console.info("回调之前的地址是："+urlStr);

        $.ajax({
           method:"GET",
            url:urlStr,
            success:function(data,status,jqXHR){
                console.info("success:"+data);
                var user=data;
                var path="<%=request.getContextPath()%>/";
                //使用id选择器
                $("#user-id").html(user.id);
                $("#user-username").html(user.username);
                //使用class选择器
                $(".user-password").html(user.password);

            }
        });

    });
</script>
<body>
<div id="user-id"></div>
<div id="user-username"></div>
<div class="user-password"></div>
</body>
</html>
