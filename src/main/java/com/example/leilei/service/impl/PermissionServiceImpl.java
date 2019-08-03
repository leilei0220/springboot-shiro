package com.example.leilei.service.impl;

import com.example.leilei.entity.Permission;
import com.example.leilei.mapper.PermissionMapper;
import com.example.leilei.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leilei
 * @since 2019-04-26
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getByEmpId(Long empId) {
        return permissionMapper.selectByEmpId(empId);
    }
}
