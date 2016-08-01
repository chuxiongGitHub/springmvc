<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/1
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit"value="提交">
</form>
</body>
</html>
