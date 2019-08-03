package com.example.leilei.service;

import com.example.leilei.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leilei
 * @since 2019-04-26
 */
public interface IPermissionService extends IService<Permission> {

    List<Permission> getByEmpId(Long empId);
}
