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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/res/bootstrap/css/bootstrap.css">
</head>
<script type="application/javascript">
    $(function(){
       var urlStr= "<%=request.getContextPath()%>/json/user";
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
                $("#user-username").text(user.username);
                //使用class选择器
                $(".user-password").html(user.password);
            }
        });

    });
</script>
<body>
<table class="table table-hover ">
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <th>密码</th>
    </tr>
    <tr>
        <td id="user-id"></td>
        <td id="user-username"></td>
        <td class="user-password"></td>
    </tr>
</table>
</body>
</html>
