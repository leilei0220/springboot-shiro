package com.example.leilei.service.impl;

import com.example.leilei.entity.Employee;
import com.example.leilei.mapper.EmployeeMapper;
import com.example.leilei.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leilei
 * @since 2019-04-26
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
