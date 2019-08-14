package com.example.leilei.util;

import com.example.leilei.entity.Employee;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

public class SessionUtil {
    public static final String LOGINSESSION = "loginuser";

    //将登陆对象存入域对象之中
    public static void setSession(Employee employee){//将登陆用户存入域对象
        Subject subject = SecurityUtils.getSubject();//获取登陆对象
        subject.getSession().setAttribute(LOGINSESSION,employee);
    }

    //Session中获取当前登陆对象
    public static Employee getSession(){//获取登陆对象域对象信息
        Subject subject = SecurityUtils.getSubject();//获取登陆对象
        return (Employee) subject.getSession().getAttribute(LOGINSESSION);
    }
}
