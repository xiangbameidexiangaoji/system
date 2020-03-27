package com.loa.system.oasystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class LoginController {

    @GetMapping("/login")
    @ResponseBody
    public String login(){
        System.out.println("访问请求");
        return "登录成功";
    }
}
