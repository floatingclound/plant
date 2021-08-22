package com.powernode.jdbc;

import com.powernode.pojo.Emp;
import com.powernode.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmpJDBC {

    public List<Emp> getAll() {
        Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        String sql = "select * from emp";
        ArrayList<Emp> empList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(sql);
             resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int empno = resultSet.getInt("empno");
                String ename = resultSet.getString("ename");
                String  job = resultSet.getString("job");
                int mgr = resultSet.getInt("mgr");
                Date hiredate = resultSet.getDate("hiredate");
                Double sal = resultSet.getDouble("sal");
                Double comm = resultSet.getDouble("comm");
                int deptno = resultSet.getInt("deptno");
                Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
                empList.add(emp);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtils.closeAll(connection,preparedStatement,resultSet);
        }


        return empList;
    }
}
