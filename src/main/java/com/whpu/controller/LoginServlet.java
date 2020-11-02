package com.whpu.controller;

import com.whpu.dao.UserDAO;
import com.whpu.entity.User;
import org.apache.commons.io.IOUtils;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName: LoginServlet
 * @Author: Gim Gong
 * @Date: 2020/10/18 14:45
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public void outputPic(String name, HttpServletResponse response) throws IOException {
        String imgURL = "D:\\FireFoxDownload\\Wallpaper/";
        FileInputStream is = new FileInputStream(imgURL + name +".jpg");
//        通过response获取字节流输出
        ServletOutputStream os = response.getOutputStream();
        //连接两个输入和输出流
        IOUtils.copy(is,os);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("UTF-8");
        LoginServlet login = new LoginServlet();
        // 1.从前端获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 2.将获取的用户名和密码与数据库中的用户名和密码进行对比
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        System.out.println(user.toString());
        UserDAO userDao = new UserDAO();
        int flag =  userDao.Login(user);
        // 3.登录成功跳转到欢迎页面
        if (flag != 0) {
            login.outputPic(username, response);
            //request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            // 4.登录失败跳转到失败页面
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writers = response.getWriter();
            writers.write("登录失败，无法显示照片！");
            //response.sendRedirect("login.jsp");
        }
    }
}
