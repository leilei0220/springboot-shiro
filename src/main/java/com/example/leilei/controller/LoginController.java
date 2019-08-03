package com.example.leilei.controller;

import com.example.leilei.entity.Employee;
import com.example.leilei.util.AjaxResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    /**
     * 登录请求
     * @param employee
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(@RequestBody Employee employee){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(employee.getUsername(),employee.getPassword());
        try {
            subject.login(token);
            return new AjaxResult();
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return new AjaxResult("登录失败！");
        }
    }

}
