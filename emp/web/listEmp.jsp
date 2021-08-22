<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/7/2
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
   <title>员工管理系统</title>
</head>
<body>
   <h1>当前用户:${sessionScope.user.username}</h1>
   <h3><a href="addEmp.jsp">新增员工</a></h3>
   <table border="2">
      <tr>
         <th>员工编号</th>
         <th>员工姓名</th>
         <th>员工职位</th>
         <th>领导编号</th>
         <th>入职日期</th>
         <th>员工工资</th>
         <th>员工奖金</th>
         <th>部门编号</th>
         <th>操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作</th>
      </tr>
      <c:forEach items="${requestScope.empList}" var="emp">
         <tr>
            <td>${pageScope.emp.empno}</td>
            <td>${pageScope.emp.ename}</td>
            <td>${pageScope.emp.job}</td>
            <td>${pageScope.emp.mgr}</td>
            <td>${pageScope.emp.hiredate}</td>
            <td>${pageScope.emp.sal}</td>
            <td>${pageScope.emp.comm}</td>
            <td>${pageScope.emp.deptno}</td>
            <td>
               <a href="deleteEmp?empno=${pageScope.emp.empno}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
               <a href="updateEmp?empno=${pageScope.emp.empno}">修改</a>
            </td>
         </tr>
      </c:forEach>
   </table>
</body>
</html>
