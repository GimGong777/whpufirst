package com.whpu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/ServletTest")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("客户端使用Post和服务器连接上啦...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("客户端使用Get和服务器连接上啦...");
        String userAgent = request.getHeader("User-agent");
        System.out.println(userAgent);
        String Accept = request.getHeader("Accept");
        System.out.println(Accept);
        String Cookies = request.getHeader("Cookies");
        System.out.println("Cookies值：" + Cookies);

        String url = request.getRequestURI();
        System.out.println(url);
        String contextPath = request.getContextPath();
        System.out.println("请求路径：" + contextPath);
        String method = request.getMethod();
        System.out.println("请求类型：" + method);
        Enumeration<String> headerName = request.getHeaderNames();
        while (headerName.hasMoreElements()) {
            String name = headerName.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
        }
    }
}
