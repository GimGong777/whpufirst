package com.whpu.controller;
import com.whpu.dao.UserDAO;
import com.whpu.entity.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName: MyServlet
 * @Author: Gim Gong
 * @Date: 2020/9/25 11:54
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 从前端获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 创建一个user对象
        User user = new User();

        // 将前端接收到的用户名和密码设置成为user对象
        user.setUsername(username);
        user.setPassword(password);

        //  创建一个userDao对象
        UserDAO userDao = new UserDAO();

        // 调用addUser方法，添加user对象到数据库
        userDao.addUser(user);
        System.out.println("用户名:" + user.getUsername() +" "+ "密码:"+ user.getPassword());

        //跳转页面welcome.jsp
        //request.getRequestDispatcher("login.jsp").forward(request,response);
        response.sendRedirect("login.jsp");
    }
}
