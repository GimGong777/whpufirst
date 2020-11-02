package com.whpu.security;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;

import javax.sql.DataSource;


/**
 * @ClassName: AuthByGivenInfo
 * @Author: Gim Gong
 * @Date: 2020/10/21 11:05
 */
public class AuthByGivenInfo {
    /*
    *  1.新建一个realm对象
    *  2.添加用户realm.addAccount()
    *  3.将DefaultSecurityManager设置realm
    *  4.将DefaultSecurityManager
    * */
    private SimpleAccountRealm realm;
    private DruidDataSource dataSource;

    public void authByJDBC() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("");
        dataSource.setUsername("root");
        dataSource.setPassword("ghk520wy");
        dataSource.setDriverClassName("com.apache.");
    }
    public AuthByGivenInfo() {
        IniRealm iniRealm = new IniRealm();
       // realm = new SimpleAccountRealm();
       // realm.addAccount("lisi","123");
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(realm);
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("lisi","123");
        subject.login(token);
        System.out.println("认证结果：" + subject.isAuthenticated());
        System.out.println(realm);
    }


    public static void  main(String[] args) {
        AuthByGivenInfo  authByGivenInfo = new AuthByGivenInfo();
    }
}
