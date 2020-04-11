package com.loa.system.oasystem.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@ApiOperation(value = "用户登录")
public class LoginController {

    @GetMapping("/login")
    public String login(){
        return "main";
    }
}
