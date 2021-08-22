<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/1
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
   <title>登录页面</title>
</head>
<body>
   <div>${requestScope.msg} </div>
   <form action="login" method="post">
      <label>账号:</label>
      <input type="text"   name="username" placeholder="请输入账号" /><br />
      <label>密码:</label>
      <input type="password"  name="password" placeholder="请输入密码" /><br />
      <input type="submit" value="提交按钮" />
      <input type="reset" value="重置按钮" />
   </form>
</body>
</html>
