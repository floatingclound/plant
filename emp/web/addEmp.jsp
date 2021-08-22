<%--
  Created by IntelliJ IDEA.
  User: summer
  Date: 2021/7/7
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增员工</title>
</head>
<body>
<form>
    员工姓名：<input type="text" name="ename" placeholder="请输入姓名"/> <br>

    员工职位：
    <select name="job">
        <option value="CLERK"> CLERK</option>
        <option value="SALESMAN"> SALESMAN</option>
        <option value="MANAGER"> MANAGER</option>
    </select>
    <br>

    领导编号：<input type="number" name="mgr" placeholder="请输入领导编号"/> <br>

    入职时间：<input type="date" name="hiredate" placeholder="请输入入职日期"/> <br>

    员工工资：<input type="number" name="sal" placeholder="请输入员工工资"/> <br>

    员工奖金：<input type="number" name="comm" placeholder="请输入奖金"/> <br>

    部门编号：<input type="number" name="deptno" placeholder="请输入部门编号"> <br>

    <input type="submit" value="增加员工"/>
    <input type="reset" value="重置数据"/>
    <br>
</form>

</body>
</html>
