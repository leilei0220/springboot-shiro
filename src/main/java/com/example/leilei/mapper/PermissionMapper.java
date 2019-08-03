package com.example.leilei.mapper;

import com.example.leilei.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author leilei
 * @since 2019-04-26
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> selectByEmpId(Long empId);
}
