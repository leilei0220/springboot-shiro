package com.example.leilei.controller;


import com.example.leilei.entity.Employee;
import com.example.leilei.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leilei
 * @since 2019-04-26
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {

    /**
     * 跳转到部门管理首页
     * @return
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "department/index";
    }




}

