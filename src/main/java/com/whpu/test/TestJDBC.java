package com.whpu.test;

import com.whpu.utils.JDBCUtil;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName: TestJDBC
 * @Author: Gim Gong
 * @Date: 2020/10/24 14:38
 */
public class TestJDBC {
    Connection conn = JDBCUtil.getConnection();
     @Test
     //查询
    public void select() throws SQLException {
        String sql = "select * from user";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println(username+ "---" +password);
        }
    }

    @Test
    //添加
    public void add() throws SQLException {
        String sql = "insert into user (username, password) values (?,?)";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,"zhaoyufan");
        psmt.setString(2,"1234");
        int i = psmt.executeUpdate();
        System.out.println(i >= 1? "新增成功":"新增失败");
    }

    @Test
    //修改
    public void update() throws SQLException {
        String sql = "update user set username = ?,password = ? where id = ?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1,"sunsahngxiang");
        psmt.setString(2,"123456");
        psmt.setInt(3,13);
        int i = psmt.executeUpdate();
        System.out.println(i >= 1? "修改成功" : "修改失败");
    }

    @Test
    // 删除
    public void delete() throws SQLException {
         String sql = "delete from user where id = ?";
         PreparedStatement psmt = conn.prepareStatement(sql);
         psmt.setInt(1,13);
         int i = psmt.executeUpdate();
         System.out.println(i >= 1 ? "删除成功" : "删除失败");
    }
}
