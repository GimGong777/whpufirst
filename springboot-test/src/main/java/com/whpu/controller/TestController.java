package com.whpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: testController
 * @Author: Gim Gong
 * @Date: 2020/10/23 11:23
 */
@RestController
public class TestController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
