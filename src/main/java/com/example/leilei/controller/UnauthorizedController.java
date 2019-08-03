package com.example.leilei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UnauthorizedController {

    /**
     * 跳转到没有权限的页面
     * @return
     */
    @RequestMapping(value = "/unauthorized",method = RequestMethod.GET)
    public String index(){
        return "unauthorized";
    }

}
