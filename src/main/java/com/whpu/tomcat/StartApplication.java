package com.whpu.tomcat;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import javax.servlet.ServletException;
import java.io.File;
/**
 * @ClassName: StartApplication
 * @Author: Gim Gong
 * @Date: 2020/10/7 10:49
 */
public class StartApplication {
    public static void start(Class<?> clazz,String[] args)  {
        Tomcat tomcat = new Tomcat();
        int port = 8080;
        String contextPath = "/whpufirst";
        String docBase = "src/main/webapp";
        tomcat.setPort(port);

        try {
            tomcat.addWebapp(contextPath,new File(docBase).getAbsolutePath());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        try {
            tomcat.start();
            System.out.println("tomcat成功启动！");
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        tomcat.getServer().await();
    }

    public static void main(String[] args)  {
        StartApplication.start(StartApplication.class,args);
    }

}
