package com.whpu.utils;
import java.sql.*;

/**
 * @ClassName: JDBCUtil
 * @Author: Gim Gong
 * @Date: 2020/10/2 10:53
 * @Description 数据库工具类
 */
public class JDBCUtil {
    static {
        try {
            // 加载数据库驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
                e.printStackTrace();
        }
    }

    //获取连接数据库
    public static Connection getConnection() {
        Connection conn = null;
        String url ="jdbc:mysql://localhost:3306/t_user?useUnicode=true&characterEncoding=UTF-8" +
                "&useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "ghk520wy";
        try {
            conn = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

//    关闭数据库
    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
