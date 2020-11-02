package com.whpu.dao;

import com.whpu.entity.User;
import com.whpu.utils.JDBCUtil;

import java.sql.*;

/**
 * @ClassName: UserDao
 * @Author: Gim Gong
 * @Date: 2020/10/2 11:34
 */
public class UserDAO {
    // 获取数据库连接
    Connection conn = JDBCUtil.getConnection();
    // 添加用户
    public void addUser(User user) {
//        System.out.println(user.toString());
//        int flag;
        PreparedStatement psmt;
        String sql = "insert into user(username,password) values(?,?)";
        try {
            // 预编译sql语句，没有参数使用prepareStatement，增加sql运行速度，有参数使用Statement
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            psmt.executeUpdate();
//            System.out.println(flag);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 用户登录
    public int Login(User user) {
        int flag = 0;
        ResultSet rs;
        PreparedStatement psmt;
        String sql = "select username,password from user where username = ? and password = ?";
        try {
            psmt = conn.prepareStatement(sql);
            psmt.setString(1, user.getUsername());
            psmt.setString(2, user.getPassword());
            rs = psmt.executeQuery();
            if (rs.next()) {
                flag = 1;
            } else {
                return flag;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.closeConnection(conn);
        }
        return flag;
    }
}
