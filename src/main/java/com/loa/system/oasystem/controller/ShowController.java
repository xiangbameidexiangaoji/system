package com.loa.system.oasystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {
//    @RequestMapping("/{url}")
//    public String showIndex(@PathVariable String url){
//        return url;
//    }

    @RequestMapping("/showUser")
    public String showIndex(){
        return "login";
    }
}
