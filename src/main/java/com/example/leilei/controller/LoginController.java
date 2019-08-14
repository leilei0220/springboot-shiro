package com.example.leilei.controller;

import com.example.leilei.entity.Employee;
import com.example.leilei.util.AjaxResult;
import com.example.leilei.util.SessionUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.font.TrueTypeFont;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class LoginController {

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isRemembered()){
            return "main";
        }else if(subject.isAuthenticated()){
            return "main";
        }
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
        //尝试获取获取用户信息
        Subject subject = SecurityUtils.getSubject();
        /*Boolean rememberMe = true;*/
        //将输入的账户密码封装为一个tocken对象
        UsernamePasswordToken token = new UsernamePasswordToken(employee.getUsername(),employee.getPassword(),employee.getRememberMe());
        try {
            //使用封装的tocken对象尝试通过shiro完成认证---->会调用自定义MyRealm类的AuthenticationInfo方法，尝试认证，
            if(!subject.isAuthenticated()){//判断当前用户是否登录 布尔值  取反
                subject.login(token);//认证登陆
            }
            //将登陆的用户信息存入域对象之中
            Employee logiuser = ((Employee) subject.getPrincipal());//获取当前用户
            SessionUtil.setSession(logiuser);
            return AjaxResult.success();
        }  catch (UnknownAccountException e) {
            e.printStackTrace();
            return AjaxResult.error("账户不存在");
        }catch (IncorrectCredentialsException e){
            e.printStackTrace();
            return AjaxResult.error("密码错误");
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return AjaxResult.error("未知错误，检查后台");
        }
    }

    //退出登录
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        return "redirect:/logout";
    }


}
