package com.whpu.controller;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @ClassName: ServeltTest02
 * @Author: Gim Gong
 * @Date: 2020/10/31 15:08
 */
@WebServlet("/ServletTest02")
public class ServletTest02 extends HttpServlet {

    public void outputPic(String name, HttpServletResponse response) throws IOException {
        String imgURL = "D:\\FireFoxDownload\\Wallpaper/";
        FileInputStream is = new FileInputStream(imgURL + name +".jpg");
//        通过response获取字节流输出
        ServletOutputStream os = response.getOutputStream();
        //连接两个输入和输出流
        IOUtils.copy(is,os);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        System.out.println(name + "-" + age);
        ServletTest02 st = new ServletTest02();
        st.outputPic(name,response);

    }
}
