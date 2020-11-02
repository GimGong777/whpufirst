<%--
  Created by IntelliJ IDEA.
  User: BruceKai
  Date: 2020/9/25
  Time: 11:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2 align="center">用&nbsp;户&nbsp;登&nbsp;录</h2>
 <form action="LoginServlet" name="login" method="post">
     <table align="center">
         <!-- 行标签tr -->
         <tr>
             <!-- 列标签td -->
             <td>用户名：</td>
             <td><input type="text" name="username"/></td>
         </tr>
         <tr>
             <td>密&nbsp;&nbsp;&nbsp;码：</td>
             <td><input type="password" name="password"/></td>
         </tr>
         <tr>
             <td colspan="2" align="right">
                 <a href="register.html">注册</a>
                 <input type="reset" value="重置" />
                 &nbsp;&nbsp;&nbsp;&nbsp;
                 <input type="submit" value="登录" />
             </td>
         </tr>
     </table>
 </form>
</body>
</html>
