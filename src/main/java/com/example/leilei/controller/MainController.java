package com.example.leilei.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    /**
     * 跳转到首页面
     * @return
     */
    @RequestMapping(value = "/main",method = RequestMethod.GET)
    public String index(){
        return "main";
    }

}
