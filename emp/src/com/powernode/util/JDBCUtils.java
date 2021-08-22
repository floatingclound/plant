package com.powernode.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 将JDBC中重复的代码提取出来
 * 注册驱动
 * 建立连接
 * 关闭资源
 */
public class JDBCUtils {
    private static String driver  = null;
    private static String url  = null;
    private static String username  = null;
    private static String password  = null;
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            //注册驱动
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 提供一个连接数据库的对象
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    /**
     * 关闭JDBC中所有的对象
     */
    public static void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 可以不添加
     * 针对DML语句进行一个同一的处理:将六个步骤全部的放在工具类
     * @param sql 要处理的SQL语句
     * @param args sql语句中的占位符
     */
    public static  int myExecuteUpdate(String sql,Object...args){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            //判断占位符是否存在?
            if(args != null){
                //占位符赋值
                for(int i=0;i<args.length;i++){
                    preparedStatement.setObject(i+1,args[i]);
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,preparedStatement,null);
        }
        return  -1;
    }
}
