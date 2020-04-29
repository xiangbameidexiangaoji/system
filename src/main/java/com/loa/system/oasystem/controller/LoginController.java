package com.loa.system.oasystem.controller;

import com.loa.system.oasystem.util.Result;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 李涵林
 */
@RestController
@RequestMapping("/user")
@ApiOperation(value = "用户登录")
public class LoginController {


    @PostMapping("/login")
    public Result login(String username, String password, HttpServletRequest request) {
        //获取 Subject
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //登录
        try {
            subject.login(token);
            return Result.ok();
        } catch (UnknownAccountException e) {
            String message = "账号错误";
            return Result.error(message);
        } catch (IncorrectCredentialsException e) {
            String message = "密码错误";
            return Result.error(message);
        }
    }

    @RequiresRoles(value = {"admin"})
    @GetMapping("/test")
    public Result test(){
        return Result.ok("测试");
    }
}
