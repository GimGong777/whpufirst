package com.whpu.controller;



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
 * @ClassName: ServletTest01
 * @Author: Gim Gong
 * @Date: 2020/10/31 14:15
 */
@WebServlet("/ServletTest01")
public class ServletTest01 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //response.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = response.getWriter();
//        writer.write("你好");
//        1.将图片以字节流的形式读取到程序中
        FileInputStream is = new FileInputStream("D:\\FireFoxDownload\\Wallpaper/Wallpaper4.jpg");
        System.out.println(is);
//        通过response获取字节流输出
        ServletOutputStream os = response.getOutputStream();
        //连接两个输入和输出流
        IOUtils.copy(is,os);
    }
}
