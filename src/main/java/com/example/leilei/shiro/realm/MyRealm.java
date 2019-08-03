package com.example.leilei.shiro.realm;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.leilei.entity.Employee;
import com.example.leilei.entity.Permission;
import com.example.leilei.service.IEmployeeService;
import com.example.leilei.service.IPermissionService;
import com.example.leilei.util.MD5Utils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IPermissionService permissionService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Employee employee = (Employee) principalCollection.getPrimaryPrincipal();
        Long empId = employee.getId();
        //根据员工id查询员工权限
        List<Permission> permissions = permissionService.getByEmpId(empId);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getSn());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        //根据用户名查询用户
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Employee employee = employeeService.getOne(wrapper);
        if(employee==null){
            throw new UnknownAccountException(username);
        }
        //封装info对象
        return new SimpleAuthenticationInfo(employee,employee.getPassword(), ByteSource.Util.bytes(MD5Utils.SALT),getName());
    }
}
