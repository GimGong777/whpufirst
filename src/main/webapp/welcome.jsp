
<%--
  Created by IntelliJ IDEA.
  User: Gim Gong
  Date: 2020/9/25
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>你好</p>
用户名：<%=request.getParameter("username") %>
密码：<%=request.getParameter("password")%>
</body>
</html>
